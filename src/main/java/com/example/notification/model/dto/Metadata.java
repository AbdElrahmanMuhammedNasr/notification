package com.example.notification.model.dto;

  import com.example.notification.model.enums.Priority;
 import com.example.notification.model.enums.SentBy;
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
