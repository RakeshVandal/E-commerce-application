package org.jsp.shoppingkart.repositry;



import org.jsp.shoppingkart.dto.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepositry extends JpaRepository<Orders, Integer> {
	
}
