package com.example.notification.model.dto;

import com.example.notification.model.Notifications;
import com.example.notification.model.Recipient;
import com.example.notification.model.enums.DeliveryStatus;
import com.example.notification.model.enums.Provider;
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
