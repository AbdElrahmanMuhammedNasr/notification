package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.RecipientDTO;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class EmailRecipientValidation implements Validations<List<RecipientDTO>> {

    @Override
    public void validate(List<RecipientDTO> body) {
        body .forEach(r-> validateEmail(r.getEmail()));
    }

    private void validateEmail(String email){

    }
}
