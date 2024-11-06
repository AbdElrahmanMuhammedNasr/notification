package com.example.notification.service.providers;

import com.example.notification.model.dto.Message;

public interface Messenger {
    boolean send(Message message);
}
