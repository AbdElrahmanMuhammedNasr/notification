package com.example.notification.service.providers;


import com.example.notification.model.Notifications;
import com.example.notification.model.Recipient;
import com.example.notification.model.dto.NotificationLogsDTO;
import com.example.notification.model.enums.DeliveryStatus;
import com.example.notification.model.enums.Provider;

public interface Messenger<B, R> {

    boolean send(B notification,  R recipient);
    default NotificationLogsDTO createLog(Provider provider, DeliveryStatus status, String errorMessage,  Long notificationId, Long recipientId) {
        NotificationLogsDTO log = new NotificationLogsDTO();
        log.setProvider(provider);
        log.setDeliveryStatus(status);
        log.setErrorMessage(errorMessage);
        log.setRecipient(Recipient.builder().id(recipientId).build());
        log.setNotifications(Notifications.builder().id(notificationId).build());
        return log;
    }
}
