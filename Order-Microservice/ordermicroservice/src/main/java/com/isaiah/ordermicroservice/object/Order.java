package com.isaiah.ordermicroservice.object;

import com.realtimee_commerceplatform.common.object.Product;

import jakarta.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name="orders", uniqueConstraints = @UniqueConstraint(columnNames = "orderId"))
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long orderId;
	
//	private LinkedList<OrderedProduct> orderedProducts;
	
	private List<OrderedProduct> orderedProducts;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "orderCost")
	private float orderCost;
	
	@Column(name = "orderStatus")
	private String orderStatus;
	
	public Order() {
		this(-1l, new LinkedList<>(), 0.0f, "created");
	}

	public Order(long orderId, LinkedList<OrderedProduct> orderProducts, float orderCost, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderedProducts = orderProducts;
		this.orderCost = orderCost;
		this.orderStatus = orderStatus;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	

//	public LinkedList<OrderedProduct> getOrderProducts() {
//		return orderedProducts;
//	}
	
	public List<OrderedProduct> getOrderProducts() {
		return orderedProducts;  
	}

//	public void setOrderProducts(LinkedList<OrderedProduct> orderProducts) {
//		this.orderedProducts = orderProducts;
//	}
	
	public void setOrderProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	public float getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderProducts=" + orderedProducts + ", orderCost=" + orderCost
				+ ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	

}
