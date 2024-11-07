package com.example.notification.service.validations.messages;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.validations.Validations;

import java.util.Objects;

public class EmailMessageValidation implements Validations<MessageDTO> {
    @Override
    public void validate(MessageDTO body) {

        if(Objects.isNull(body.getSubject())){

        }
        if(Objects.isNull(body.getBody())){

        }

    }
}
