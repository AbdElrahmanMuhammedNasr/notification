package com.example.notification.model;


import com.example.notification.model.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "notifications")
    @JsonIgnoreProperties(value = { "recipient", "notifications" }, allowSetters = true)
    List<NotificationsLogs> notificationsLogs;

}
