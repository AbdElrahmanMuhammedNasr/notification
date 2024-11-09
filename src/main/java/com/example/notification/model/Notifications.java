package com.example.notification.model;


import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.NotificationRequestDTO;
import com.example.notification.model.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notifications extends AbstractAuditingEntity<Long>  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "provider_type")
    @Enumerated(EnumType.STRING)
    ProviderType providerType;

    @Column(name = "notification_type")
    @Enumerated(EnumType.STRING)
    NotificationType notificationType;

    @Column(name = "subject")
    String subject;


    @Column(name = "body")
    String body;

    List<String> attachmentsUrls;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    Language language;

    @Column(name = "message_content_type")
    @Enumerated(EnumType.STRING)
    MessageContentType messageContentType;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    Priority priority;

    @Column(name = "sent_by")
    @Enumerated(EnumType.STRING)
    SentBy sentBy;

    @OneToMany(mappedBy = "notifications", orphanRemoval = true)
    @JsonIgnoreProperties(value = { "recipient", "notifications" }, allowSetters = true)
    @JsonManagedReference
    Set<NotificationsLogs> notificationsLogs;

    @OneToMany(mappedBy = "notification", cascade ={CascadeType.ALL}  , orphanRemoval = true)
    @JsonIgnoreProperties(value = { "notificationsLogs" }, allowSetters = true)
    @JsonManagedReference
    Set<Recipients> recipients;




    public static NotificationDTO  createNotificationDTO(NotificationRequestDTO notifications){
        return NotificationDTO.builder()
                .body(notifications.getMessage().getBody())
                .subject(notifications.getMessage().getSubject())
                .attachmentsUrls(notifications.getMessage().getAttachmentsUrls())
                .language(notifications.getMessage().getLanguage())
                .messageContentType(notifications.getMessage().getMessageContentType())
                .notificationType(notifications.getNotificationType())
                .priority(notifications.getMetadata().getPriority())
                .providerType(notifications.getProviderType())
                .sentBy(notifications.getMetadata().getSentBy())
                .build();
    }

}
