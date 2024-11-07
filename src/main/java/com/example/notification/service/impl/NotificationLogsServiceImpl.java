package com.example.notification.service.impl;

import com.example.notification.model.NotificationsLogs;
import com.example.notification.service.dto.NotificationLogsDTO;
import com.example.notification.repository.NotificationsLogsRepository;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.mapper.NotificationsLogsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class NotificationLogsServiceImpl implements NotificationLogsService {
    NotificationsLogsRepository notificationsLogsRepository;
    NotificationsLogsMapper notificationsLogsMapper;
    @Override
    public void saveNotificationLogs(NotificationLogsDTO notificationLogsDTO) {
        NotificationsLogs NotificationsLogsEntity = notificationsLogsMapper.toEntity(notificationLogsDTO);
        notificationsLogsRepository.save(NotificationsLogsEntity);

    }
}
