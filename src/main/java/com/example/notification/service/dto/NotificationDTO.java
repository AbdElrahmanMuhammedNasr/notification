package com.example.notification.service.dto;

import com.example.notification.service.dto.request.MessageDTO;
import com.example.notification.service.dto.request.RecipientDTO;
import com.example.notification.model.enumeration.*;
import lombok.Data;

import java.util.List;

@Data
public class NotificationDTO {
    Long id;
    ProviderType providerType;
    NotificationType notificationType;

    String subject;
    String body;
    List<String> attachmentsUrls;
    Language language;
    MessageContentType messageContentType;

    MessageDTO messageDTO;

    Priority priority = Priority.NORMAL;
    SentBy sentBy = SentBy.SYSTEM;
    List<RecipientDTO> recipients;
}
