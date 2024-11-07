package com.example.notification.service.providers.sms;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.providers.ChainFactory;
import com.example.notification.service.providers.email.Gmail;

public class SmsChainFactory implements ChainFactory<MessageDTO> {

    Vodafone vodafone= new Vodafone();
    Twillio twillio= new Twillio();
    SmsMasr smsMasr= new SmsMasr();

    public SmsChainFactory() {
        vodafone.setNext(twillio);
        twillio.setNext(smsMasr);
    }

    @Override
    public void send(MessageDTO message) {
        if (vodafone.send(message)) {
            System.out.println("Message could not be sent.");
        }
    }

}
