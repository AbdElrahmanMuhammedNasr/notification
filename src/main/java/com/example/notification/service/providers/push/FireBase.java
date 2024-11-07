package com.example.notification.service.providers.push;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.RecipientDTO;
import com.example.notification.service.providers.Messenger;

public class FireBase implements  Messenger<NotificationDTO, RecipientDTO> {
    @Override
    public boolean send(NotificationDTO notification,  RecipientDTO recipient) {
        return false;
    }
}