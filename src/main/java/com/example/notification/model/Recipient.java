package com.example.notification.model;

import com.example.notification.service.dto.request.NotificationRequestDTO;
import com.example.notification.service.dto.request.RecipientDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "recipients")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipient  extends AbstractAuditingEntity<Long> implements Serializable {

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
    List<NotificationsLogs> notificationsLogs;


    @ManyToOne(cascade ={CascadeType.ALL})
    @JoinColumn(name = "notification_id" ,nullable = false)
    @JsonIgnoreProperties(value = { "recipient", "notifications" }, allowSetters = true)
    Notifications notifications;

    public static RecipientDTO createRecipientDTO(NotificationRequestDTO notification){
        return new RecipientDTO();
    }
}
