package com.example.notification.service.validations.recipients;

import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.service.validations.Validations;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@Slf4j
public class EmailRecipientValidation implements Validations<List<RecipientsDTO>> {

    @Override
    public void validate(List<RecipientsDTO> body) {
        body .forEach(r-> validateEmail(r.getEmail()));
    }

    private void validateEmail(String email){
        log.info("Validation email "+ email);
        if(Objects.isNull(email)){
            throw new IllegalArgumentException("Email is null");
        }

    }
}
