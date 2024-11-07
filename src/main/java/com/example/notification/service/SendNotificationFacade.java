package com.example.notification.service;


import com.example.notification.model.Notifications;
import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.NotificationRequestDTO;
import com.example.notification.service.validations.messages.ValidationMessageFactory;
import com.example.notification.service.validations.recipients.ValidationRecipientFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SendNotificationFacade {

    NotificationManager notificationManager;
    NotificationsService notificationsService;

    public void sendNotification(NotificationRequestDTO notification) {
        new ValidationRecipientFactory(notification.getProviderType()).getValidation().validate(notification.getRecipients());
        new ValidationMessageFactory(notification.getProviderType()).getValidation().validate(notification.getMessage());

        NotificationDTO notificationDTO = notificationsService.saveNotification(Notifications.createNotificationDTO(notification));
        notificationManager.send(notificationDTO);

      }

}
