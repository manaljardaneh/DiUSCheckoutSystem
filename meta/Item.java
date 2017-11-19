package com.dius.checkout.meta;

public class Item {
    private String sku;
    private String name;
    private double price;
    
    public Item() {   
    }
    
    public Item(String _sku, String _name, double _price) {
        this.sku = _sku;
        this.name = _name;
        this.price = _price;
    }

    public void setSku(String _sku) {
        this.sku = _sku;
    }

    public String getSku() {
        return sku;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double _price) {
        this.price = _price;
    }

    public double getPrice() {
        return price;
    }
}
