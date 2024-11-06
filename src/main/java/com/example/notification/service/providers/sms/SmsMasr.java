package com.example.notification.service.providers.sms;

import com.example.notification.model.dto.Message;
import com.example.notification.service.providers.Messenger;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class SmsMasr implements Messenger {
    Messenger next;

    @Override
    public boolean send(Message message) {
        log.info("send sms using SMS masr");
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