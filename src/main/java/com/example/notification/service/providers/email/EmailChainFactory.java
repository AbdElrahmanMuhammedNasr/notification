package com.example.notification.service.providers.email;

import com.example.notification.model.dto.MessageDTO;
import com.example.notification.service.providers.ChainFactory;
import com.example.notification.service.providers.whatsapp.Twillio;
import com.example.notification.service.providers.whatsapp.WhatsApp;

public class EmailChainFactory implements ChainFactory<MessageDTO> {

    Gmail gmail = new Gmail();

    @Override
    public void send(MessageDTO message) {
        if (gmail.send(message)) {
            System.out.println("Message could not be sent.");
        }
    }

}
