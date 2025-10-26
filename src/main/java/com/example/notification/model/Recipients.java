package com.example.notification.model;

import com.example.notification.service.dto.NotificationDTO;
import com.example.notification.service.dto.request.NotificationRequestDTO;
import com.example.notification.service.dto.request.RecipientsDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipients  extends AbstractAuditingEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;


    // push notification
    @Column(name = "user_id")
    String userId;

    // sms and whatsapp
    @Column(name = "mobile")
    String mobile;

    @Column(name = "country_code")
    String countryCode;

    @Column(name = "country")
    String country;

    // email
    @Column(name = "email")
    String email;

    @OneToMany(mappedBy = "recipient")
    @JsonIgnoreProperties(value = { "recipient", "notifications" }, allowSetters = true)
    @JsonManagedReference
    Set<NotificationsLogs> notificationsLogs;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id" ,nullable = false)
    @JsonIgnoreProperties(value = { "recipient", "notifications" }, allowSetters = true)
    @JsonManagedReference
    Notifications notification;



    public static List<RecipientsDTO> createRecipientsDTO(NotificationRequestDTO notification, Long notificationId){
        return notification.getRecipients().stream().peek(recipient ->recipient.setNotification(NotificationDTO.builder().id(notificationId).build())   ).toList();
    }
}
