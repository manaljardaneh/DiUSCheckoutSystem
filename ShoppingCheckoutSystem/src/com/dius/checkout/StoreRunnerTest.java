package com.dius.checkout;


import com.dius.checkout.meta.Item;
import com.dius.checkout.meta.OpeningDaySpecials;
import com.dius.checkout.meta.PricingRules;



public class StoreRunnerTest {
    public StoreRunnerTest() {
    }

    public static void main(String[] args) {
        Item item1 = new Item("ipd","Super iPad",549.99);
        Item item2 = new Item("mbp","MacBook Pro",1399.99);
        Item item3 = new Item("atv","Apple TV",109.50);
        Item item4 = new Item("vga","VGA adapter",30.00);
        
        PricingRules pricingRules = new OpeningDaySpecials();
        
        Checkout co = new Checkout(pricingRules);
        co.scan(item1);
        co.scan(item1);
        co.scan(item1);
        co.scan(item1);
        co.scan(item1);
        co.scan(item2);
        co.scan(item3);
        co.scan(item3);
        co.scan(item3);
        co.scan(item4);
        co.scan(item4);
        co.total();
    }
}
