package com.example.notification.service.validations.recipients;

import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class PushNotificationRecipientValidation implements Validations<List<RecipientsDTO>> {

    @Override
    public void validate(List<RecipientsDTO> body) {
        body .forEach(r-> validatePushNotification(r.getUserId()));
    }

    private void validatePushNotification(String userId){

    }
}
