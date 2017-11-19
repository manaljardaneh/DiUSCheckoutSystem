package com.dius.shop;


public class Product {


     String sku;
     String name;
     Double price;
     int qty;

    Product(String sku, String name, String price)
    {
        this.setSku(sku.trim());
        this.setName(name.trim());
        this.setPrice(Double.parseDouble((price.trim().substring(1))));
       
    }

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

