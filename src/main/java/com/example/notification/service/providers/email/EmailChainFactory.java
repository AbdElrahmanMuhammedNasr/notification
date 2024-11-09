package com.example.notification.service.providers.email;
import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.NotificationLogsService;
import com.example.notification.service.providers.ChainFactory;

public class EmailChainFactory implements ChainFactory<NotificationDTO> {

    Gmail gmail ;

    public EmailChainFactory(NotificationLogsService notificationLogsService) {
        gmail = new Gmail(notificationLogsService);
    }

    @Override
    public void start(NotificationDTO notificationDTO) {
        notificationDTO.getRecipients().forEach(recipient -> gmail.send(notificationDTO, recipient));

    }

}
