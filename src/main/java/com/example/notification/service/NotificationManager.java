package com.example.notification.service;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.providers.MessengerChainFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class NotificationManager {
    MessengerChainFactory messengerChainFactory;

    public void send(NotificationDTO notification) {
        messengerChainFactory.getProviderFactory(notification.getProviderType()).start(notification);
    }
}
