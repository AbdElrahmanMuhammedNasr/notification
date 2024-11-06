package com.example.notification.service.providers.whatsapp;

import com.example.notification.model.dto.Message;
import com.example.notification.service.providers.ChainFactory;

public class WhatsAppChainFactory implements ChainFactory<Message> {

    WhatsApp whatsapp = new WhatsApp();
    Twillio twilio = new Twillio();

    public WhatsAppChainFactory() {
        whatsapp.setNext(twilio);
    }

    @Override
    public void send(Message message) {
        if (!whatsapp.send(message)) {
            System.out.println("Message could not be sent.");
        }
    }

}
