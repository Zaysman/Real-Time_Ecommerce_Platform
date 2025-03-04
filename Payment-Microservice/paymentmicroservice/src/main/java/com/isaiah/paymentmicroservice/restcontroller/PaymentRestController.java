package com.isaiah.paymentmicroservice.restcontroller;

import com.isaiah.paymentmicroservice.object.Payment;
import com.isaiah.paymentmicroservice.service.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/payments")
public class PaymentRestController {
	
	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private PaymentService paymentService;

	
	
	//Create a new payment
	@PostMapping(value = "/pay", produces = JSON, consumes = JSON)
	public Payment createPayment(@RequestBody Payment payment) {
		payment = paymentService.createPayment(payment);
		return payment;
	}
	
	//Read payment by Payment Id
	@GetMapping(value = "/{paymentId}", produces = JSON)
	public Payment readPaymentByPaymentId(@PathVariable long paymentId) {
		Payment payment = paymentService.readPaymentByPaymentId(paymentId);
		return payment;	
	}
	
	//Read Payment by Order Id
	@GetMapping(value = "/orderId/{orderId}")
	public Payment readPaymentByOrderId(@PathVariable long orderId) {
		Payment payment = paymentService.readPaymentByOrderId(orderId);
		return payment;
	}
	
	//Read Payments by User Id
	@GetMapping(value = "/userId/{userId}", produces = JSON)
	public List<Payment> readPaymentsByUserId(@PathVariable long userId) {
		List<Payment> payments = paymentService.readPaymentsByUserId(userId);
		return payments;
	}
	
	//Update Payment
	@PutMapping(value = "/update/{paymentId}")
	public Payment updatePayment(@PathVariable long paymentId, @RequestBody Payment payment) {
		Payment existingPayment = paymentService.readPaymentByPaymentId(paymentId);
		
		if(existingPayment != null) {
			existingPayment.setOrderId(payment.getOrderId());
			existingPayment.setPaymentAmount(payment.getPaymentAmount());
			existingPayment.setUserId(payment.getUserId());
			
			paymentService.updatePayment(existingPayment);
			return existingPayment;
		} else {
			return null;
		}
		
	}
	
	//Delete Payment by PaymentId
	@DeleteMapping(value = "/delete/paymentId/{paymentId}")
	public void deletePaymentByPaymentId(@PathVariable long paymentId) {
		paymentService.deletePaymentByPaymentId(paymentId);
	}
	
	//Delete Payment by OrderId
	@DeleteMapping(value = "/delete/orderId/{orderId}")
	public void deletePaymentByOrderId(@PathVariable long orderId) {
		paymentService.deletePaymentByOrderId(orderId);	
	}
	
	//Delete Payments by userId
	@DeleteMapping(value = "/delete/userId/{userId}")
	public void deletePaymentsByUserId(@PathVariable long userId) {
		paymentService.deletePaymentsByUserId(userId);
	}
	
}
