package com.example.notification.service.providers.sms;

import com.example.notification.model.dto.NotificationDTO;
import com.example.notification.model.dto.request.MessageDTO;
import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.model.enums.DeliveryStatus;
import com.example.notification.model.enums.Provider;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.Messenger;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Twillio implements  Messenger<NotificationDTO, RecipientDTO> {
    Messenger next;

    NotificationLogsService notificationLogsService;
    public Twillio(NotificationLogsService notificationLogsService) {
        this.notificationLogsService = notificationLogsService;
    }

    @Override
    public boolean send(NotificationDTO notification,  RecipientDTO recipient) {
        log.info("send sms using TWILIO");
        if(Boolean.TRUE){
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.TWILLIO, DeliveryStatus.SENT, null, notification.getId(), recipient.getId()));
            return true;
        }else {
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.TWILLIO, DeliveryStatus.FAILED, null, notification.getId(), recipient.getId()));
            if(Objects.isNull(this.next))
                throw new IllegalStateException("No next messenger set");
            return this.next.send(notification, recipient);

        }
    }

    public void setNext(Messenger next) {
        this.next = next;
    }
}