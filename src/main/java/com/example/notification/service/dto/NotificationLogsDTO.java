package com.example.notification.service.dto;

import com.example.notification.model.Notifications;
import com.example.notification.model.Recipient;
import com.example.notification.model.enumeration.DeliveryStatus;
import com.example.notification.model.enumeration.Provider;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationLogsDTO {
    Long id;
    Provider provider;
    DeliveryStatus deliveryStatus;
    String errorMessage;
    Recipient recipient;
    Notifications notifications;
}
