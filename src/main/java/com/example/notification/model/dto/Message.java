package com.example.notification.model.dto;

import com.example.notification.model.enums.Language;
import com.example.notification.model.enums.MessageContentType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {

        String subject;
        String body;
        List<String> attachmentsUrls;
        Language language;
        MessageContentType messageContentType;

}
