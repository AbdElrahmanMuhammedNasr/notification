package com.example.notification.service;

import com.example.notification.service.dto.request.RecipientsDTO;

import java.util.List;

public interface RecipientService {

    void saveRecipient(RecipientsDTO recipientDTO);
    List<RecipientsDTO> saveRecipient(List<RecipientsDTO> recipientDTOs);
}
