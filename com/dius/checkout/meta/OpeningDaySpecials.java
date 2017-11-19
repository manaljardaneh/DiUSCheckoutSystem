package com.dius.checkout.meta;

import java.util.List;

public class OpeningDaySpecials implements PricingRules {
    public OpeningDaySpecials() {
        super();
    }

    public double applyRules(List<Item> scannedItems) {
        double total = 0.0;
        int atvCount = 0;
        int ipdCount = 0;
        int vgaCount = 0;
        int mbpCount = 0;
        double atvPrice = 0.0;
        double vgaPrice = 0.0;
        
        for (Item item : scannedItems){
            if(item.getSku().equals("vga")){
                vgaCount +=1; //just count them, price will be calcualted later
                vgaPrice = item.getPrice();
            }
            else if(item.getSku().equalsIgnoreCase("atv")){
                total += item.getPrice();
                atvPrice = item.getPrice();
                atvCount +=1;   
            }
            else if(item.getSku().equals("ipd")){
                total += item.getPrice();
                ipdCount +=1;
            }
            else if(item.getSku().equals("mbp")){
                total += item.getPrice();
                mbpCount +=1;
            }
        }
        
        if(ipdCount >4){
            total -= (ipdCount*50); //discount 50$ per each
            System.out.println("Price Discount for " + ipdCount + " Super Ipads");
        }
        
        int freeAtvs = atvCount/3;
        if(freeAtvs >0){
            total -=(freeAtvs* atvPrice);
            System.out.println("3 for 2 ATV Discount X "+freeAtvs);
        }
        
        if(mbpCount < vgaCount){
            total += ((vgaCount-mbpCount)* vgaPrice);
        }else if(mbpCount > vgaCount){
            System.out.println("Extra free " + (mbpCount-vgaCount) + " VGA Adapter(s) bundled for free");
        }
        
        return total;
    }
                    
    
}
