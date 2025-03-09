package com.isaiah.notificationmicroservice.repository;

import com.isaiah.notificationmicroservice.object.Notification;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	//Save or update Notification
	<S extends Notification> S save(S notification);
	
	//Read operations
	Optional<Notification> findByNotificationId(long notificationId);
	List<Notification> findByUserId(long userId);
	
	//Delete Operations
	void deleteByNotificationId(long notificationId);
	void deleteByUserId(long userId);
	void delete(Notification notification);
	
	

}
