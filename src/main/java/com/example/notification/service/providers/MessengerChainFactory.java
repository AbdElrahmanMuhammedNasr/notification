package com.example.notification.service.providers;

import com.example.notification.model.enumeration.ProviderType;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.email.EmailChainFactory;
import com.example.notification.service.providers.sms.SmsChainFactory;
import com.example.notification.service.providers.whatsapp.WhatsAppChainFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessengerChainFactory {
    NotificationLogsService notificationLogsService;

    public ChainFactory getProviderFactory(ProviderType type) {
        return switch (type) {
            case WHATSAPP -> new WhatsAppChainFactory(notificationLogsService);
            case EMAIL -> new EmailChainFactory(notificationLogsService);
            case SMS -> new SmsChainFactory(notificationLogsService);
            default -> throw new IllegalArgumentException("Invalid messenger type");
        };
    }
}
