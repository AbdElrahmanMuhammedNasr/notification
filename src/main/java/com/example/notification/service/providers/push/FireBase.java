package com.example.notification.service.providers.push;

import com.example.notification.model.dto.Message;
import com.example.notification.service.providers.Messenger;

public class FireBase implements Messenger {
    @Override
    public boolean send(Message message) {
        return false;
    }
}