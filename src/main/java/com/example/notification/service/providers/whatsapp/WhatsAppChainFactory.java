package com.example.notification.service.providers.whatsapp;

import com.example.notification.model.dto.NotificationDTO;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.ChainFactory;

public class WhatsAppChainFactory implements ChainFactory<NotificationDTO> {
    WhatsApp whatsapp;
    Twillio twilio;
    public WhatsAppChainFactory(NotificationLogsService notificationLogsService) {
        whatsapp = new WhatsApp(notificationLogsService);
        twilio = new Twillio(notificationLogsService);

        whatsapp.setNext(twilio);
    }

    @Override
    public void send(NotificationDTO notificationDTO) {
        notificationDTO.getRecipients().forEach(recipient -> whatsapp.send(notificationDTO, recipient));
    }

}
