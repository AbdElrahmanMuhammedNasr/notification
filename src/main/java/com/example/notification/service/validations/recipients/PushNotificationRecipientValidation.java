package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.Recipient;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class PushNotificationRecipientValidation implements Validations<List<Recipient>> {

    @Override
    public void validate(List<Recipient> body) {
        body .forEach(r-> validatePushNotification(r.getUserId()));
    }

    private void validatePushNotification(String userId){

    }
}
