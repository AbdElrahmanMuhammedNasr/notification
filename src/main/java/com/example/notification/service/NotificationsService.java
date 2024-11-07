package com.example.notification.service;

import com.example.notification.model.dto.NotificationDTO;

public interface NotificationsService {

    NotificationDTO saveNotification(NotificationDTO notification);
}
