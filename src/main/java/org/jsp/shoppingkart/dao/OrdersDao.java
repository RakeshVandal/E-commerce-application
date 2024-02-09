package org.jsp.shoppingkart.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dto.Orders;
import org.jsp.shoppingkart.repositry.OrdersRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao {
	@Autowired
	private OrdersRepositry repositry;

	public Orders saveOrders(Orders order) {
		return repositry.save(order);
	}

	public Orders updateOrders(Orders orders) {
		return repositry.save(orders);
	}

	public List<Orders> findAll() {
		return repositry.findAll();
	}

	public Optional<Orders> findOrders(int id) {
		return repositry.findById(id);
	}
	


	public void deleteOrders(int id) {
		repositry.deleteById(id);
	}
}
