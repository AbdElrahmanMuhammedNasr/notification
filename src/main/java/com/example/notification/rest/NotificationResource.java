package com.example.notification.rest;


import com.example.notification.model.dto.NotificationRequestDTO;
import com.example.notification.service.SendNotificationFacade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,  makeFinal = true)
public class NotificationResource {

    SendNotificationFacade sendNotificationFacade;

    @PostMapping("/notifications")
    public void  sendNotification(@RequestBody NotificationRequestDTO notification){
        sendNotificationFacade.sendNotification(notification);
    }

}
