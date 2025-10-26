package com.example.notification.service.validations.recipients;

import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.service.validations.Validations;

import java.util.List;

public class MobileRecipientValidation implements Validations<List<RecipientsDTO>> {

    @Override
    public void validate(List<RecipientsDTO> body) {
        body.forEach(r-> validateNumber(r.getMobile() , r.getCountryCode() ,r.getCountry()));
    }

    private void validateNumber(String mobile , String countryCode , String country){
        System.out.println("validating is processing");
    }
}
