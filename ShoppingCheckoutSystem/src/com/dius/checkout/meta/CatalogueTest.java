package com.dius.checkout.meta;


public class CatalogueTest {
	
	  public  void testReadingInProducts()
	    {
	        Catalogue catalogue = new Catalogue("product.txt");
	       System.out.println("Number of Items in  the Catalogues is:"+catalogue.size());
	        
	    }

	   public void testFindingProduct(String skuItem)
	    {
	        Catalogue catalogue = new Catalogue("product.txt");

	        Item product = catalogue.findProduct(skuItem);
	        System.out.println("Item sku:"+product.getSku());
	        System.out.println("Item name:"+product.getName());
	        System.out.println("Item price:"+product.getPrice());


	    }
	    public static void main(String[] args) {
	         CatalogueTest test=new CatalogueTest();
	    	 test.testReadingInProducts();
	    	 test.testFindingProduct("mbp");
	    	 test.testFindingProduct("ipd");
	    	 test.testFindingProduct("vga");
	    	 test.testFindingProduct("atv");
	    	
	    	 
	    }
}
