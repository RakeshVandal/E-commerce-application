package org.jsp.shoppingkart.service;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dao.MerchantDao;
import org.jsp.shoppingkart.dao.ProductDao;
import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Merchant;
import org.jsp.shoppingkart.dto.Product;
import org.jsp.shoppingkart.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int merchant_id) {
		ResponseStructure<Product> structure = new ResponseStructure<Product>();
		Optional<Merchant> recMerchant = merchantDao.findMerchant(merchant_id);
		if (!recMerchant.isEmpty()) {
			Merchant merchant = recMerchant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			productDao.saveProduct(product);
			structure.setBody(product);
			structure.setCode(HttpStatus.CREATED.value());
			structure.setMessage("Product Saved ");
		} else {
			structure.setBody(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Admin ID NOT FOUND");
		}
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int merchant_id) {
		ResponseStructure<Product> structure = new ResponseStructure<Product>();
		Optional<Merchant> recMerchant = merchantDao.findMerchant(merchant_id);
		if (!recMerchant.isEmpty()) {
			Merchant merchant = recMerchant.get();
			merchant.getProducts().add(product);
			product.setMerchant(merchant);
			productDao.updateProduct(product);
			structure.setBody(product);
			structure.setCode(HttpStatus.CREATED.value());
			structure.setMessage("product updated Succefully");
		} else {
			structure.setBody(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Admin ID NOT FOUND");
		}
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();

		structure.setMessage(" All Products found sucessfully");
		structure.setBody(productDao.findAll());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Product>> findProduct(int id) {
		Optional<Product> recUser = productDao.findProduct(id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("Product Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Product>> findProduct(String name) {
		Optional<Product> recUser = productDao.findProduct(name);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("Product Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}

}
