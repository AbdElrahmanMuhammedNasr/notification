package com.example.notification.model;


import com.example.notification.model.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Entity
@Table(name = "notifications_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationsLogs extends AbstractAuditingEntity<Long>  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    Provider provider;

    @Column(name = "delivery_status")
    @Enumerated(EnumType.STRING)
    DeliveryStatus deliveryStatus;

    @Column(name = "error_message")
    String errorMessage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    @JsonIgnoreProperties(value = { "notificationsLogs" }, allowSetters = true)
    Recipient recipient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id")
    @JsonIgnoreProperties(value = { "notificationsLogs" }, allowSetters = true)
    Notifications notifications;

}
