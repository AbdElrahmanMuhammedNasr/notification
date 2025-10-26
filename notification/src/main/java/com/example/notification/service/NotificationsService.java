package com.example.notification.service;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.NotificationRequestDTO;

public interface NotificationsService {

    NotificationDTO saveNotification(NotificationDTO notification);
}
