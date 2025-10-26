package com.example.notification.service.impl;

import com.example.notification.model.Notifications;
import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.model.enumeration.ProviderType;
import com.example.notification.repository.NotificationsRepository;
import com.example.notification.service.NotificationsService;
import com.example.notification.service.mapper.NotificationsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class NotificationsServiceImpl implements NotificationsService {
    NotificationsRepository notificationsRepository;
    NotificationsMapper notificationsMapper;
    @Override
    public NotificationDTO saveNotification(NotificationDTO notificationDTO) {
        Notifications entity = notificationsMapper.toEntity(notificationDTO);
        Notifications save = notificationsRepository.save(entity);
        return notificationsMapper.toDto(save);
    }
}
