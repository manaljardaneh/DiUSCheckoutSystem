package com.dius.checkout.meta;

import java.util.ArrayList;
import java.util.List;

public class OpeningDaySpecialsTest {
	public static void main(String[] args) {
    	List<Item> itemList = new ArrayList<Item>();
        Item item1 = new Item("ipd","Super iPad",549.99);
        itemList.add(item1);
        Item item2 = new Item("mbp","MacBook Pro",1399.99);
        itemList.add(item2);
        Item item3 = new Item("atv","Apple TV",109.50);
        itemList.add(item3);
        Item item4 = new Item("vga","VGA adapter",30.00);
        itemList.add(item4);
        
        OpeningDaySpecials specialOffers=new OpeningDaySpecials();
       double totalPrice= specialOffers.applyRules(itemList);
       System.out.println("Total Price:"+totalPrice);
        }
}
