package com.example.notification.service.providers.whatsapp;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.model.enumeration.DeliveryStatus;
import com.example.notification.model.enumeration.Provider;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.Messenger;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WhatsApp implements  Messenger<NotificationDTO, RecipientsDTO> {
    Messenger next;

    final NotificationLogsService notificationLogsService;


    public WhatsApp(NotificationLogsService notificationLogsService) {
        this.notificationLogsService = notificationLogsService;
    }


    @Override
    public boolean send(NotificationDTO notification,  RecipientsDTO recipient) {
        log.info("send Message to whatsapp  using whatsapp");
        if(Boolean.FALSE){
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.WHATS_APP, DeliveryStatus.SENT, null, notification.getId(), recipient.getId()));
            return true;
        }else {
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.WHATS_APP, DeliveryStatus.FAILED, "error", notification.getId(), recipient.getId()));
            if(Objects.isNull(this.next))
                throw new IllegalStateException("No next messenger set");
            return this.next.send(notification, recipient);
        }
    }

    public void setNext(Messenger next) {
        this.next = next;
    }
}
