package com.dius.checkout.meta;

import java.util.List;

public interface PricingRules {
   
    public double applyRules(List<Item> scannedItems);  
    
}
