package com.example.notification.service.validations.recipients;

import com.example.notification.model.enumeration.ProviderType;
import com.example.notification.service.validations.Validations;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ValidationRecipientFactory {

     Validations validation;

    public ValidationRecipientFactory(ProviderType providerType){
        System.out.println("create validation factory");
        switch (providerType) {
            case SMS, WHATSAPP:  validation =  new MobileRecipientValidation(); break;
            case EMAIL : validation = new EmailRecipientValidation(); break;
            case PUSH_NOTIFICATION : validation = new PushNotificationRecipientValidation(); break;
            default: throw new IllegalArgumentException("Invalid provider type: " + providerType);
        }
    }

}
