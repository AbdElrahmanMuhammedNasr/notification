package com.example.notification.service;


import com.example.notification.model.dto.NotificationRequestDTO;
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
      public void sendNotification(NotificationRequestDTO notification){
           new ValidationRecipientFactory(notification.getProviderType()).getValidation().validate(notification.getRecipients());
           new ValidationMessageFactory(notification.getProviderType()).getValidation().validate(notification.getMessage());
          notificationManager.send(notification);

      }

}
