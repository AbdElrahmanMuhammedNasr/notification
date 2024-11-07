package com.example.notification.service.mapper;

import com.example.notification.model.Recipient;
import com.example.notification.model.dto.request.RecipientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper extends EntityMapper<RecipientDTO, Recipient> {
}
