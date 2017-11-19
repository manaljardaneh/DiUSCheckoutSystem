package com.dius.checkout.meta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dius.shop.Product;

public class Catalogue {

		ArrayList<Item> products;

		public Catalogue(String filename) {
			Scanner scan = null;
			ArrayList<Item> productList = new ArrayList<Item>();
			try {
				scan = new Scanner(new File(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] fields = line.trim().split("\\|");

				if (!fields[0].trim().equalsIgnoreCase("1")) {

					Item proItem = new Item();
					proItem.setSku(fields[1]);
					proItem.setName(fields[2].trim());
					proItem.setPrice(Double.parseDouble(fields[3].trim().substring(1)));
					productList.add(proItem);
					//System.out.prin(productList.size());

				}
				products = productList;
			}

		}
		 public int size()
		    {
		        return products.size();
		    }
		public Item findProduct(String sku) {

			Item product = null;
			Item productFinal = null;
			for (int i = 0; i < products.size(); i++) {
				product = (Item) products.get(i);
				if (product.getSku().trim().equalsIgnoreCase(sku.trim())) {

					productFinal = product;
				}

			}
			return productFinal;
		}

}
