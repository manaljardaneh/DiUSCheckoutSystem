package com.dius.checkout.meta;

public class ItemTest {
	
	public void TestCreatingItem(String skuItem,String nameItem,double priceItem){
		Item itemtest = new Item(skuItem,nameItem,priceItem);
		System.out.println("Item sku:"+itemtest.getSku());
		System.out.println("Item name:"+itemtest.getName());
		System.out.println("Item price:"+itemtest.getPrice());
	}
	 public static void main(String[] args) {
		 ItemTest itemTest=new ItemTest();
		 itemTest.TestCreatingItem("ipd", "Super iPad", 549.99);
	 }
}
