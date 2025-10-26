package com.example.notification.service.dto.request;

  import com.example.notification.model.enumeration.Priority;
 import com.example.notification.model.enumeration.SentBy;
 import lombok.AccessLevel;
 import lombok.Data;
 import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Metadata {

    Priority priority;

    SentBy sentBy;

    String senderId;

    boolean isSchedule;

    String  schedulePattern;
}
