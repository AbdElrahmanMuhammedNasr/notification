package com.example.notification.model.dto;

import com.example.notification.model.dto.request.MessageDTO;
import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.model.enums.*;
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
