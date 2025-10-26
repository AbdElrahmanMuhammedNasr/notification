package com.example.notification.service.dto.request;

import com.example.notification.service.dto.NotificationDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipientsDTO {
    Long id;
    // mobile sms
    String mobile;
    String countryCode;
    String country;

    // email
    String email;

    // push notification
    String userId;

    NotificationDTO notification;
}
