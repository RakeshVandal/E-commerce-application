package org.jsp.shoppingkart.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dto.Product;
import org.jsp.shoppingkart.repositry.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepositry repositry;
	public Optional<Product> findProduct(String name) {
		return repositry.findProduct(name);
	}
	public Optional<Product> findProduct(int id) {
		return repositry.findById(id);
	}

	public List<Product> findAll() {
		return repositry.findAll();
	}
	public Product saveProduct(Product product) {
		return repositry.save(product);
	}

	public Product updateProduct(Product product) {
		return repositry.save(product);	
	}

	
}
