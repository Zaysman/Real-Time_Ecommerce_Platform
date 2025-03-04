package com.isaiah.paymentmicroservice.service;

import com.isaiah.paymentmicroservice.object.Payment;
import com.isaiah.paymentmicroservice.repository.PaymentRepository;


import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment createPayment(Payment payment) {
		Optional<Payment> existingPayment = paymentRepository.findBypaymentId(payment.getPaymentId());
		if(existingPayment.isPresent()) {
			throw new RuntimeException("Payment with paymentId: " + payment);
		}
		
		Payment savedPayment = paymentRepository.save(payment);
		return savedPayment;
	}
	
	public Payment readPaymentByPaymentId(long paymentId) {
		return paymentRepository.findBypaymentId(paymentId).orElse(null);
	}
	
	public Payment readPaymentByOrderId(long orderId) {
		return paymentRepository.findByorderId(orderId).orElse(null);
	}
	
	public List<Payment> readPaymentsByUserId(long userId) {
		return paymentRepository.findByuserId(userId);
	}
	
	public Payment updatePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	@Transactional
	public void deletePaymentByPaymentId(long paymentId) {
		paymentRepository.deleteBypaymentId(paymentId);
	}
	
	@Transactional
	public void deletePaymentByOrderId(long orderId) {
		paymentRepository.deleteByorderId(orderId);
	}
	
	@Transactional
	public void deletePaymentsByUserId(long userId) {
		paymentRepository.deleteByuserId(userId);
	}
	
	
	
	
	
	
}
