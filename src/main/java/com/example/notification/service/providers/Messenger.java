package com.example.notification.service.providers;


import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.NotificationLogsDTO;
import com.example.notification.model.enumeration.DeliveryStatus;
import com.example.notification.model.enumeration.Provider;
import com.example.notification.service.dto.request.RecipientsDTO;

public interface Messenger<B, R> {

    boolean send(B notification,  R recipient);
    default NotificationLogsDTO createLog(Provider provider, DeliveryStatus status, String errorMessage,  Long notificationId, Long recipientId) {
        NotificationLogsDTO log = new NotificationLogsDTO();
        log.setProvider(provider);
        log.setDeliveryStatus(status);
        log.setErrorMessage(errorMessage);
        log.setRecipient(RecipientsDTO.builder().id(recipientId).build());
        log.setNotifications(NotificationDTO.builder().id(notificationId).build());
        return log;
    }
}
