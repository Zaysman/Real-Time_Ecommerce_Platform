package com.isaiah.ordermicroservice.object;

import jakarta.persistence.*;

import java.util.LinkedList;


@Entity
@Table(name="orders", uniqueConstraints = @UniqueConstraint(columnNames = "orderId"))
public class Order {
	
	private long orderId;
	
	private float orderCost;
	
	private String orderStatus;
	
	

}
