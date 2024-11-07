package com.example.notification.service.providers.email;

import com.example.notification.model.dto.NotificationDTO;
import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.model.enums.DeliveryStatus;
import com.example.notification.model.enums.Provider;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.Messenger;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gmail implements Messenger<NotificationDTO , RecipientDTO> {
    Messenger next;
    final NotificationLogsService notificationLogsService;

    public Gmail(NotificationLogsService notificationLogsService) {
        this.notificationLogsService = notificationLogsService;
    }

    @Override
    public boolean send(NotificationDTO notification, RecipientDTO recipient) {
        log.info("send email using Gmail");
        if (Boolean.TRUE) {
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.GMAIL, DeliveryStatus.SENT, null, notification.getId(), recipient.getId()));
            return true;
        } else {
            notificationLogsService.saveNotificationLogs(this.createLog(Provider.GMAIL, DeliveryStatus.FAILED, "error", notification.getId(), recipient.getId()));
            if (Objects.isNull(this.next))
                throw new IllegalStateException("No next messenger set");
            return this.next.send(notification, recipient);
        }
    }

    public void setNext(Messenger next) {
        this.next = next;
    }
}
