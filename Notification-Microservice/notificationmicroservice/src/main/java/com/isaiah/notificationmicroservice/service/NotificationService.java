package com.isaiah.notificationmicroservice.service;

import com.isaiah.notificationmicroservice.object.Notification;
import com.isaiah.notificationmicroservice.repository.NotificationRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public Notification createNotification(Notification notification) {
		Optional<Notification> existingNotification = notificationRepository.findByNotificationId(notification.getNotificationId());
		if(existingNotification.isPresent()) {
			throw new RuntimeException("Notification with Id: " + existingNotification.get().getNotificationId() + " already exists");
		}
		
		Notification savedNotification = notificationRepository.save(notification);
		return savedNotification;
	}
	
	public Notification readNotificationByNotificationId(long notificationId) {
		return notificationRepository.findByNotificationId(notificationId).orElse(null);
	}
	
	public List<Notification> readNotificationsByUserId(long userId) {
		return notificationRepository.findByUserId(userId);
	}
	
	public Notification updateNotification(Notification notification) {
		return notificationRepository.save(notification);
	}
	
	@Transactional
	public void deleteNotificationByNotificationId(long notificationId) {
		notificationRepository.deleteByNotificationId(notificationId);
	}
	
	@Transactional
	public void deleteNotificationsByUserId(long userId) {
		notificationRepository.deleteByUserId(userId);
	}
	
	@Transactional
	public void deleteNotification(Notification notification) {
		notificationRepository.delete(notification);
	}
	
	
	
}
