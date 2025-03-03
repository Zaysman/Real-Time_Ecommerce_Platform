package com.isaiah.paymentmicroservice.object;

import jakarta.persistence.*;


@Entity
@Table(name="payments", uniqueConstraints = @UniqueConstraint(columnNames = "paymentId"))
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private long paymentId;
	
	@Column(name = "orderId")
	private long orderId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "paymentAmount")
	private float paymentAmount;
	
	public Payment() {
		this(-1l, -1l, -1, 0.0f);
	}

	public Payment(long paymentId, long orderId, long userId, float paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.userId = userId;
		this.paymentAmount = paymentAmount;
	}
	
	
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
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

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", userId=" + userId + ", paymentAmount="
				+ paymentAmount + "]";
	}

	
	
	

}
