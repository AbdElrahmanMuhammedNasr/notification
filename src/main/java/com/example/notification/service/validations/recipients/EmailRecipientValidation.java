package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.Recipient;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class EmailRecipientValidation implements Validations<List<Recipient>> {

    @Override
    public void validate(List<Recipient> body) {
        body .forEach(r-> validateEmail(r.getEmail()));
    }

    private void validateEmail(String email){

    }
}