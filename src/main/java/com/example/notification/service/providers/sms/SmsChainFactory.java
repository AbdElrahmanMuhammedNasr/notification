package com.example.notification.service.providers.sms;

import com.example.notification.model.dto.NotificationDTO;
import com.example.notification.model.dto.request.MessageDTO;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.ChainFactory;

public class SmsChainFactory implements ChainFactory<NotificationDTO> {

    Twillio twillio;
    SmsMasr smsMasr;

    public SmsChainFactory(NotificationLogsService notificationLogsService) {
        twillio = new Twillio(notificationLogsService);
        smsMasr = new SmsMasr(notificationLogsService);
        twillio.setNext(smsMasr);
    }

    @Override
    public void send(NotificationDTO notificationDTO) {
        notificationDTO.getRecipients().forEach(recipient -> twillio.send(notificationDTO, recipient));

    }

}
