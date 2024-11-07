package com.example.notification.service.mapper;

import com.example.notification.model.Notifications;
 import com.example.notification.model.dto.NotificationDTO;
 import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = { RecipientMapper.class})
public interface NotificationsMapper extends EntityMapper<NotificationDTO, Notifications> {
}
