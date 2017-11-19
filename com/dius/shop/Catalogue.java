package com.dius.shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dius.shop.Product;

public class Catalogue {
	ArrayList<Product> products;

	public Catalogue(String filename) {
		Scanner scan = null;
		ArrayList<Product> productList = new ArrayList<Product>();
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

				Product proItem = new Product();
				proItem.setSku(fields[1]);
				proItem.setName(fields[2].trim());
				proItem.setPrice(Double.parseDouble(fields[3].trim().substring(1)));
				productList.add(proItem);
				System.out.print(productList.size());

			}
			products = productList;
		}

	}

	public Product findProduct(String sku) {

		Product product = null;
		Product productFinal = null;
		for (int i = 0; i < products.size(); i++) {
			product = (Product) products.get(i);
			if (product.getSku().trim().equalsIgnoreCase(sku.trim())) {

				productFinal = product;
			}

		}
		return productFinal;
	}

}
