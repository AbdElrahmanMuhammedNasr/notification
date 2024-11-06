package com.example.notification.service.validations.messages;

import com.example.notification.model.enums.ProviderType;
import com.example.notification.service.validations.Validations;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ValidationMessageFactory {

    Validations validation;

    public ValidationMessageFactory(ProviderType providerType){
        System.out.println("create Message validation factory");
        switch (providerType) {
            case SMS,WHATSAPP : validation =  new MobileMessageValidation(); break;
            case EMAIL : validation = new EmailMessageValidation(); break;
            case PUSH_NOTIFICATION : validation = new PushNotificationMessageValidation(); break;
            default: throw new IllegalArgumentException("Invalid provider type: " + providerType);
        }
    }

}
