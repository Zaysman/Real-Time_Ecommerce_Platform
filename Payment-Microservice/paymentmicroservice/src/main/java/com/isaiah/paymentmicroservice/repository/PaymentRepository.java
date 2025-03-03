package com.isaiah.paymentmicroservice.repository;

import com.isaiah.paymentmicroservice.object.Payment;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	//Save or update Payment
	<S extends Payment> S save (S payment);
	
	//Read Operations
	Optional<Payment> findBypaymentId(long paymentId);
	Optional<Payment> findByorderId(long orderId);
	List<Payment> findByuserId(long userId);
	
	//Delete Operations
	void deleteBypaymentId(long paymentId);
	void deleteByorderId(long orderId);
	void deleteByuserId(long userId);
	void delete(Payment payment);
	
	
	
}
