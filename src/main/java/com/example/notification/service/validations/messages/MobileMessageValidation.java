package com.example.notification.service.validations.messages;

import com.example.notification.model.dto.Message;
import com.example.notification.service.validations.Validations;

import java.util.Objects;

public class MobileMessageValidation implements Validations<Message> {
    @Override
    public void validate(Message body) {

        if(Objects.isNull(body.getBody())){

        }

    }
}
