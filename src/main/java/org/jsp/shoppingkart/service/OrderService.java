package org.jsp.shoppingkart.service;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dao.OrdersDao;
import org.jsp.shoppingkart.dao.ProductDao;
import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Orders;
import org.jsp.shoppingkart.dto.Product;
import org.jsp.shoppingkart.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrdersDao orderdao;	
	@Autowired
	private ProductDao productdao;
	
	
	public ResponseEntity<ResponseStructure<Orders>> saveOrders(Orders order, int product_id) {
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		Optional<Product> recProduct = productdao.findProduct(product_id);
		if (!recProduct.isEmpty()) {
//			Product product = recProduct.get();
//			product.getOrder().add(order);
			orderdao.saveOrders(order);
			structure.setBody(order);
			structure.setCode(HttpStatus.CREATED.value());
			structure.setMessage("Branch Saved Succefully");
		} else {
			structure.setBody(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Hospital ID NOT FOUND");
		}
		return new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Orders>>> findAll() {
		ResponseStructure<List<Orders>> structure = new ResponseStructure<>();

		structure.setMessage(" All Products found sucessfully");
		structure.setBody(orderdao.findAll());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Orders>>>(structure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Orders>> findOrder(int id) {
		Optional<Orders> recUser = orderdao.findOrders(id);
		ResponseStructure<Orders> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("Order Found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}
	


}
