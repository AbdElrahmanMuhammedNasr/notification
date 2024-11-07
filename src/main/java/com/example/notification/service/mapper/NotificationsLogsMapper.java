package com.example.notification.service.mapper;

import com.example.notification.model.NotificationsLogs;
import com.example.notification.model.dto.NotificationLogsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationsLogsMapper extends EntityMapper<NotificationLogsDTO, NotificationsLogs> {
}
