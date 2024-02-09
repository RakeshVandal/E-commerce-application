package org.jsp.shoppingkart.controller;

import java.util.List;

import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Product;
import org.jsp.shoppingkart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	
	@PostMapping("/addproduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int id) {
		return service.saveProduct(product, id);
	}
	@PutMapping("/addproduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@PathVariable int id) {
		return service.saveProduct(product, id);
	}
	@GetMapping("/viewproduct")
	public ResponseEntity<ResponseStructure<List<Product>>> findProduct() {
		return service.findAll();
	}
	@GetMapping("/viewproduct/{id}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable int id) {
		return service.findProduct(id);
	}
	@GetMapping("/viewproductby/{name}")
	public ResponseEntity<ResponseStructure<Product>> findProduct(@PathVariable String name) {
		return service.findProduct(name);
	}
}
