package org.jsp.shoppingkart.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, decription;
	private String brand;
	private String catagory;
	private double price;
	@ManyToOne
	@JoinColumn
	private Merchant merchant;
	@ManyToOne
	@JoinColumn
	private Orders order;

}
