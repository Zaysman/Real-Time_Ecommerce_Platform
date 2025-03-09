package com.isaiah.notificationmicroservice.restcontroller;

import com.isaiah.notificationmicroservice.object.Notification;
import com.isaiah.notificationmicroservice.service.NotificationService;

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
@RequestMapping("api/notifications")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationRestController {

	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private NotificationService notificationService;
	
	
	//Create Notification
	@PostMapping(value = "/create", produces = JSON, consumes = JSON)
	public Notification createNotification(@RequestBody Notification notification) {
		notification = notificationService.createNotification(notification);
		return notification;
	}
	
	
	@GetMapping(value = "/{notificationId}", produces = JSON)
	public Notification getNotificationByNotificationId(@PathVariable long notificationId) {
		return notificationService.readNotificationByNotificationId(notificationId);
	}
	
	@GetMapping(value = "/user/{userId}", produces = JSON)
	public List<Notification> getNotificationsByUserId(@PathVariable long userId) {
		return notificationService.readNotificationsByUserId(userId);
	}
	
	@PutMapping(value = "/update/{notificationId}", produces = JSON, consumes = JSON)
	public Notification updateNotification(@PathVariable long notificationId, @RequestBody Notification notification) {
		Notification existingNotification = notificationService.readNotificationByNotificationId(notificationId);
		
		if(existingNotification != null) {
			existingNotification.setNotificationContent(notification.getNotificationContent());
			existingNotification.setUserId(notification.getUserId());
			existingNotification.setViewed(notification.isViewed());
			
			notificationService.updateNotification(existingNotification);
			return existingNotification;
		} else {
			return null;
		}
	}
	
	@DeleteMapping(value = "/delete/{notificationId}")
	public void deleteNotificationByNotificationId(@PathVariable long notificationId) {
		notificationService.deleteNotificationByNotificationId(notificationId);
	}
	
	@DeleteMapping(value = "/delete/user/{userId}")
	public void deleteNotificationsByUserId(@PathVariable long userId) {
		notificationService.deleteNotificationsByUserId(userId);
	}
	
	@DeleteMapping(value = "/delete")
	public void deleteNotification(@RequestBody Notification notification) {
		notificationService.deleteNotification(notification);
	}
	
}
