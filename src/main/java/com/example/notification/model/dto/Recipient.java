package com.example.notification.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipient {

    // mobile sms
    String mobile;
    String countryCode;
    String country;

    // email
    String email;

    // push notification
    String userId;
}
