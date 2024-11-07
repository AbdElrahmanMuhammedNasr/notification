package com.example.notification.service.providers.push;

import com.example.notification.model.dto.NotificationDTO;
import com.example.notification.model.dto.request.MessageDTO;
import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.service.providers.Messenger;

public class FireBase implements  Messenger<NotificationDTO, RecipientDTO> {
    @Override
    public boolean send(NotificationDTO notification,  RecipientDTO recipient) {
        return false;
    }
}