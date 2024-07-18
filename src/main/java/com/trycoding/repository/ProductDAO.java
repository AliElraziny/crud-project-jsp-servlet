package com.trycoding.repository;

import java.util.ArrayList;
import java.util.List;

import com.trycoding.model.Product;

public class ProductDAO {

	private List<Product> products;
	
	private static ProductDAO dao;

	private ProductDAO() {
		products = new ArrayList<>();
		products.add(new Product(1, "Product 1", 10.0));
		products.add(new Product(2, "Product 2", 20.0));
	}
	
	public static ProductDAO getProductDAO() {
		if(dao==null) {
			dao = new ProductDAO();
			return dao;
		}
		return dao;
		
	}
	

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProduct(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public void addProduct(Product product) {
		int lastId = products.get(products.size()-1).getId();
		product.setId(lastId+1);
		products.add(product);
	}

	public void updateProduct(Product product) {
		for (Product existingProduct : products) {
			if (existingProduct.getId() == product.getId()) {
				existingProduct.setName(product.getName());
				existingProduct.setPrice(product.getPrice());
			}
		}
	}

	public void deleteProduct(int id) {
		Product productToRemove = null;
		for (Product product : products) {
			if (product.getId() == id) {
				productToRemove = product;
				break;
			}
		}
		if (productToRemove != null) {
			products.remove(productToRemove);
		}
	}

}
