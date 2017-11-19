package com.dius.shop;

import java.util.HashMap;

public class ExamplesTest {

	CheckoutSystem checkout;

	public void setUp() {

		Catalogue catalogue = new Catalogue("product.txt");
		checkout = new CheckoutSystem();
		checkout.catalogue = catalogue;
	}

	public void runScenario(String items) {

		String[] output = items.split("\\,");
		for (int i = 0; i < output.length; i++) {
			String sku = output[i];

			checkout.scan(sku.trim());

		}
HashMap<String,Number> checkoutTotal=checkout.total();

double totalPrice=(double) checkoutTotal.get("subtotal");
int mbpCount=(int) checkoutTotal.get("mbpCount");
	System.out.println("---->The total amount of the Purchase is:$"+totalPrice);	
	if(mbpCount>0){
	System.out.println("----->You will recieve "+mbpCount  +" VGA adapter for free as reward for buying "+mbpCount+" MacBook Pro");
	}
	}

	public static void main(String[] args) {

		ExamplesTest example = new ExamplesTest();
		example.setUp();
		String items = "atv, ipd, ipd, atv, ipd, ipd, ipd,mbp";
		example.runScenario(items);
	}

}
