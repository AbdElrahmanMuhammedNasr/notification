package com.example.notification.service.dto.request;


import com.example.notification.model.enumeration.NotificationType;
import com.example.notification.model.enumeration.ProviderType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationRequestDTO {

    NotificationType notificationType;

    ProviderType providerType;

    List<RecipientDTO> recipients;

    MessageDTO message;

    Metadata metadata;
}
