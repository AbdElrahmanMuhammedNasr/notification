package com.example.notification.model.dto;


import com.example.notification.model.enums.NotificationType;
import com.example.notification.model.enums.ProviderType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationRequestDTO {

    NotificationType notificationType;

    ProviderType providerType;

    List<Recipient> recipients;

    Message message;

    Metadata metadata;
}
