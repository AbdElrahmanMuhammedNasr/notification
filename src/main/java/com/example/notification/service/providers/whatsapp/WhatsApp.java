package com.example.notification.service.providers.whatsapp;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.providers.Messenger;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WhatsApp implements Messenger<MessageDTO> {
    Messenger next;

    @Override
    public boolean send(MessageDTO message) {
        log.info("send Message to whatsapp  using whatsapp");
        if(Boolean.FALSE){
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
