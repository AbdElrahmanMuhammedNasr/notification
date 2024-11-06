package com.example.notification.service.providers;

import com.example.notification.model.enums.ProviderType;
import com.example.notification.service.providers.email.EmailChainFactory;
import com.example.notification.service.providers.sms.SmsChainFactory;
import com.example.notification.service.providers.whatsapp.WhatsAppChainFactory;
import org.springframework.stereotype.Service;

@Service
public class MessengerChainFactory {

    public ChainFactory getProviderFactory(ProviderType type) {
        return switch (type) {
            case WHATSAPP -> new WhatsAppChainFactory();
            case EMAIL -> new EmailChainFactory();
            case SMS -> new SmsChainFactory();
            default -> throw new IllegalArgumentException("Invalid messenger type");
        };
    }
}
