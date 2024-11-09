package com.example.notification.service.providers.push;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.service.providers.Messenger;

public class FireBase implements  Messenger<NotificationDTO, RecipientsDTO> {
    @Override
    public boolean send(NotificationDTO notification,  RecipientsDTO recipient) {
        return false;
    }
}