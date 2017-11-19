package com.dius.checkout;

import com.dius.checkout.meta.Item;

import com.dius.checkout.meta.PricingRules;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<Item> scannedItems = new ArrayList<Item>();
    private PricingRules pricingRules;
    
    public Checkout(PricingRules _pricingRules) {
        this.pricingRules = _pricingRules;
    }

    public void scan(Item item){
    	
        scannedItems.add(item);
        System.out.println("Scanned:" + item.getName()+" excpected price :"+item.getPrice());
    }
    
    public void total(){
    	
        double total = pricingRules.applyRules(scannedItems);
        System.out.println("total price=$" + total);
    }
}
