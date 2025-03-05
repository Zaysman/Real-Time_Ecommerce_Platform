package com.isaiah.notificationmicroservice.object;

import jakarta.persistence.*;

@Entity
@Table(name = "notifications", uniqueConstraints = @UniqueConstraint(columnNames = "notificationId"))
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notificationId")
	private long notificationId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "notificationContent")
	private String notificationContent;
	
	@Column(name = "viewed")
	private boolean viewed;
	
	public Notification() {
		this(-1, -1, "default content", false);
	}

	public Notification(long notificationId, long userId, String notificationContent, boolean viewed) {
		super();
		this.notificationId = notificationId;
		this.userId = userId;
		this.notificationContent = notificationContent;
		this.viewed = viewed;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", userId=" + userId + ", notificationContent="
				+ notificationContent + ", viewed=" + viewed + "]";
	}
	
	
	

}
