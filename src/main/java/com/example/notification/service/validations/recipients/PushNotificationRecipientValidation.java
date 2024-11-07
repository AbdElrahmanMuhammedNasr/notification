package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class PushNotificationRecipientValidation implements Validations<List<RecipientDTO>> {

    @Override
    public void validate(List<RecipientDTO> body) {
        body .forEach(r-> validatePushNotification(r.getUserId()));
    }

    private void validatePushNotification(String userId){

    }
}
