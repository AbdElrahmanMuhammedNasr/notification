package com.example.notification.service.validations.messages;

import com.example.notification.service.dto.request.MessageDTO;
import com.example.notification.service.validations.Validations;

import java.util.Objects;

public class MobileMessageValidation implements Validations<MessageDTO> {
    @Override
    public void validate(MessageDTO body) {

        if(Objects.isNull(body.getBody())){

        }

    }
}
