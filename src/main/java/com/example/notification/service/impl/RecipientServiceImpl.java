package com.example.notification.service.impl;

import com.example.notification.model.dto.request.RecipientDTO;
import com.example.notification.repository.RecipientRepository;
import com.example.notification.service.RecipientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class RecipientServiceImpl implements RecipientService {
    RecipientRepository recipientRepository;
    @Override
    public void saveRecipient(RecipientDTO recipientDTO) {

    }
}
