package org.jsp.shoppingkart.repositry;

import java.util.Optional;

import org.jsp.shoppingkart.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepositry extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.name=?1")
	public Optional<Product> findProduct(String name);

	
	
	
}
