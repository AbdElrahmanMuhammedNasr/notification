package com.example.notification.service.dto.request;

import com.example.notification.model.enumeration.Language;
import com.example.notification.model.enumeration.MessageContentType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {

        String subject;
        String body;
        List<String> attachmentsUrls;
        Language language;
        MessageContentType messageContentType;

}
