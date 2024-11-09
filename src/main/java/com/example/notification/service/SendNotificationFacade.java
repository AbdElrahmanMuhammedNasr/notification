package com.example.notification.service;


import com.example.notification.model.Notifications;
import com.example.notification.model.Recipients;
import com.example.notification.model.enumeration.ProviderType;
import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.NotificationRequestDTO;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.service.validations.messages.ValidationMessageFactory;
import com.example.notification.service.validations.recipients.ValidationRecipientFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SendNotificationFacade {

    NotificationManager notificationManager;
    NotificationsService notificationsService;
    RecipientService recipientService;

    public void sendNotification(NotificationRequestDTO notification) {
        new ValidationRecipientFactory(notification.getProviderType()).getValidation().validate(notification.getRecipients());
        new ValidationMessageFactory(notification.getProviderType()).getValidation().validate(notification.getMessage());

        NotificationDTO notificationDTO = Notifications.createNotificationDTO(notification);
        NotificationDTO savedNotificationDTO = notificationsService.saveNotification(notificationDTO);

        List<RecipientsDTO> recipientsDTO = Recipients.createRecipientsDTO(notification, savedNotificationDTO.getId());
        List<RecipientsDTO> recipientDTOS = recipientService.saveRecipient(recipientsDTO);

        if (notification.getProviderType().equals(ProviderType.APPLICATION))
            return;

        savedNotificationDTO.setRecipients(recipientDTOS);
        notificationManager.send(savedNotificationDTO);

    }

}
