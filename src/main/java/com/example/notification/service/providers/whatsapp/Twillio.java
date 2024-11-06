package com.example.notification.service.providers.whatsapp;

import com.example.notification.model.dto.Message;
import com.example.notification.service.providers.Messenger;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Twillio implements Messenger {
    Messenger next;

    @Override
    public boolean send(Message message) {
        log.info("send Message  to whatsapp using Twillio");
        if(Boolean.TRUE){
            return true;
        }else {
            if(Objects.isNull(this.next))
                throw new IllegalStateException("No next messenger set");
            return this.next.send(message);
        }
    }

    public void setNext(Messenger next) {
        this.next = next;
    }
}