package com.example.notification.service.mapper;

import com.example.notification.model.Recipients;
import com.example.notification.service.dto.request.RecipientsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper extends EntityMapper<RecipientsDTO, Recipients> {


}
