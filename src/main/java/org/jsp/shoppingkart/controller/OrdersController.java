package org.jsp.shoppingkart.controller;

import java.util.List;

import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Orders;
import org.jsp.shoppingkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	@Autowired
	private OrderService service;

	
	@PostMapping("/order/{id}")
	public ResponseEntity<ResponseStructure<Orders>> saveOrders(@RequestBody Orders order,@PathVariable int id) {
		return service.saveOrders(order, id);
	}
	@GetMapping("/vieworder")
	public ResponseEntity<ResponseStructure<List<Orders>>> findOrders() {
		return service.findAll();
	}
	@GetMapping("/vieworder/{id}")
	public ResponseEntity<ResponseStructure<Orders>> findOrder(@PathVariable int id) {
		return service.findOrder(id);
	}
	
}
