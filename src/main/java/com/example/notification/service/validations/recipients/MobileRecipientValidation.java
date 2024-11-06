package com.example.notification.service.validations.recipients;

import com.example.notification.model.dto.Recipient;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class MobileRecipientValidation implements Validations<List<Recipient>> {

    @Override
    public void validate(List<Recipient> body) {
        body.forEach(r-> validateNumber(r.getMobile() , r.getCountryCode() ,r.getCountry()));
    }

    private void validateNumber(String mobile , String countryCode , String country){
        System.out.println("validating is processing");
    }
}
