package com.example.notification.service.mapper;

import com.example.notification.model.Notifications;
 import com.example.notification.service.dto.NotificationDTO;
 import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.management.Notification;

@Mapper(componentModel = "spring" , uses = { RecipientMapper.class})
public interface NotificationsMapper extends EntityMapper<NotificationDTO, Notifications> {


}
