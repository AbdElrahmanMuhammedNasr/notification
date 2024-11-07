package com.example.notification.service.providers.push;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.providers.Messenger;

public class FireBase implements Messenger<MessageDTO> {
    @Override
    public boolean send(MessageDTO message) {
        return false;
    }
}