package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.service.validations.Validations;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@Slf4j
public class EmailRecipientValidation implements Validations<List<RecipientDTO>> {

    @Override
    public void validate(List<RecipientDTO> body) {
        body .forEach(r-> validateEmail(r.getEmail()));
    }

    private void validateEmail(String email){
        log.info("Validation email "+ email);
        if(Objects.isNull(email)){
            throw new IllegalArgumentException("Email is null");
        }

    }
}
