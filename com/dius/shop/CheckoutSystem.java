package com.dius.shop;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckoutSystem {
	Catalogue catalogue;
	ArrayList<String> pricingRules;// = [];
	ArrayList<Product> items = new ArrayList<Product>();// = new String[];

	public CheckoutSystem() {

	}

	public CheckoutSystem(ArrayList<String> pricingRules) {
		this.pricingRules = pricingRules;
	}

	public void scan(String sku) {
		
		Product product = catalogue.findProduct(sku);

		if (product != null)
			items.add(product);
		else
			throw new RuntimeException("sku not found :" + sku);
	}

	@SuppressWarnings("rawtypes")
	public HashMap total() {
		HashMap<String, Number> outputMap = new HashMap();
		double subtotal = 0.0;
		int mbpCount = 0;
		int ipdCount = 0;
		int atvCount = 0;
		int vgaCount = 0;
		double atvPrice = 0.0;
		double mbpPrice = 0.0;
		double ipdPrice = 0.0;
		double vgaPrice = 0.0;

		for (int i = 0; i < items.size(); i++) {
			Product product = (Product) items.get(i);
			
			if (product.getSku().trim().equalsIgnoreCase("atv")) {
				atvCount += 1;
				atvPrice = product.getPrice();
			} else if (product.getSku().trim().equalsIgnoreCase("mbp")) {
				mbpCount += 1;
				mbpPrice = product.getPrice();
			} else if (product.getSku().trim().equalsIgnoreCase("ipd")) {
				ipdCount += 1;
				ipdPrice = product.getPrice();
			} else if (product.getSku().trim().equalsIgnoreCase("vga")) {
				vgaCount += 1;
				vgaPrice = product.getPrice();
			}
		}

		if (atvCount >= 3) {
			int freeItems = atvCount / 3;
			atvPrice = freeItems * atvPrice;
		} else {
			atvPrice = atvCount * atvPrice;
		}
		if (ipdCount > 4) {
			ipdPrice = ipdCount * 499.99;
		} else {
			ipdPrice = ipdCount * ipdPrice;

		}
		if (mbpCount > 0) {
			mbpPrice = mbpCount * mbpPrice;
		}
		if (vgaCount > 0) {
			vgaPrice = vgaCount * vgaPrice;
		}
	
		subtotal = atvPrice + ipdPrice + vgaPrice + mbpPrice;
		
		outputMap.put("subtotal", subtotal);
		outputMap.put("mbpCount", mbpCount);
		return outputMap;
	
	}

}
