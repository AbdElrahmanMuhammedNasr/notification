package com.example.notification.service.impl;

import com.example.notification.model.Notifications;
import com.example.notification.model.Recipient;
import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.model.enumeration.ProviderType;
import com.example.notification.repository.NotificationsRepository;
import com.example.notification.service.NotificationsService;
import com.example.notification.service.mapper.NotificationsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class NotificationsServiceImpl implements NotificationsService {
    NotificationsRepository notificationsRepository;
    NotificationsMapper notificationsMapper;
    @Override
    public NotificationDTO saveNotification(NotificationDTO notificationDTO) {
        Notifications notification = new Notifications();
        notification.setProviderType(ProviderType.EMAIL);
        notification.setBody("this is body");
        List<Recipient> recipients = new ArrayList<>();

        Recipient mobileRecipient = new Recipient();
        mobileRecipient.setMobile("1234569");
        recipients.add(mobileRecipient);

        Recipient mobileRecipient2 = new Recipient();
        mobileRecipient2.setMobile("00000");
        recipients.add(mobileRecipient2);

        mobileRecipient.setNotifications(notification);
        mobileRecipient2.setNotifications(notification);

        notification.setRecipients(recipients);
        Notifications save = notificationsRepository.save(notification);
        return notificationsMapper.toDto(save);
    }
}
