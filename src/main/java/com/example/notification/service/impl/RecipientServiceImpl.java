package com.example.notification.service.impl;

import com.example.notification.model.Recipients;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.example.notification.repository.RecipientRepository;
import com.example.notification.service.RecipientService;
import com.example.notification.service.mapper.RecipientMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class RecipientServiceImpl implements RecipientService {
    RecipientRepository recipientRepository;
    RecipientMapper recipientMapper;
    @Override
    public void saveRecipient(RecipientsDTO recipientDTO) {
        Recipients entity = recipientMapper.toEntity(recipientDTO);
        recipientRepository.save(entity);

    }

    @Override
    public List<RecipientsDTO> saveRecipient(List<RecipientsDTO> recipientDTOs) {
        List<Recipients> list = recipientDTOs.stream().map(recipient -> recipientMapper.toEntity(recipient)).toList();
        List<Recipients> recipients = recipientRepository.saveAll(list);
        return recipientMapper.toDto(recipients);
    }
}
