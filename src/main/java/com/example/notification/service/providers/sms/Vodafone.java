package com.example.notification.service.providers.sms;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.providers.Messenger;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Vodafone implements Messenger<MessageDTO> {
    Messenger next;

    @Override
    public boolean send(MessageDTO message) {
        log.info("send sms  using Vodafone");
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