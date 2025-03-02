package com.isaiah.ordermicroservice.object;

import jakarta.persistence.*;

@Entity
@Table(name="orderedProducts", uniqueConstraints = @UniqueConstraint(columnNames = "entryId"))
public class OrderedProduct {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long entryId;
	
	@Column(name = "orderId")
	private long orderId;
	
	@Column(name = "productId")
	private long productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "priceAtOrder")
	private float priceAtOrder;
	
	public OrderedProduct() {
		this(-1l, -1l, -1l, 0, 0.0f);
	}

	public OrderedProduct(long entryId, long orderId, long productId, int quantity, float priceAtOrder) {
		super();
		this.entryId = entryId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.priceAtOrder = priceAtOrder;
	}

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPriceAtOrder() {
		return priceAtOrder;
	}

	public void setPriceAtOrder(float priceAtOrder) {
		this.priceAtOrder = priceAtOrder;
	}

	@Override
	public String toString() {
		return "OrderedProduct [entryId=" + entryId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", priceAtOrder=" + priceAtOrder + "]";
	}

}
