package com.dius.checkout;

import com.dius.checkout.meta.Catalogue;
import com.dius.checkout.meta.Item;
import com.dius.checkout.meta.OpeningDaySpecials;
import com.dius.checkout.meta.PricingRules;


public class ExamplesTest {
	   public void testScenario1() {
	        runScenario("atv, atv, atv, vga", 249.00);
	    }

	  public  void testScenario2() {
	        runScenario("mbp, vga, ipd", 1949.98);
	    }

	   public void testScenario3() {
	        runScenario("atv, ipd, ipd, atv, ipd, ipd, ipd", 2718.95);
	    }
	public void runScenario(String items, double expectedPrice) {
		 PricingRules pricingRules = new OpeningDaySpecials();   
	     Checkout checkout = new Checkout(pricingRules);
	     Catalogue catalogue = new Catalogue("product.txt");
		String[] output = items.split("\\,");
		for(int i=0;i<output.length;i++){
	        String sku=output[i];
	        //System.out.println(sku.trim());
	       Item itemToScan= catalogue.findProduct(sku.trim());
	        checkout.scan(itemToScan);
		}
		
		checkout.total();
		}
		 public static void main(String[] args) {
			 
			 ExamplesTest example=new ExamplesTest();
			 example.testScenario1();
			 example.testScenario2();
			 example.testScenario3();
		 }
		
		
}
