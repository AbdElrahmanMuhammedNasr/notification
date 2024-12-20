package com.example.notification.service.dto;

import com.example.notification.service.dto.request.MessageDTO;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.model.enumeration.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NotificationDTO {
    Long id;
    ProviderType providerType;
    NotificationType notificationType;

    String subject;
    String body;
    Language language;
    MessageContentType messageContentType;

    MessageDTO messageDTO;

    Priority priority = Priority.NORMAL;
    SentBy sentBy = SentBy.SYSTEM;
    List<RecipientsDTO> recipients;
}
