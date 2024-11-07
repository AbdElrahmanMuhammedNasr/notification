package com.example.notification.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("MOBILE")
public class MobileRecipient  extends Recipient {

    @Column(name = "mobile")
    String mobile;

    @Column(name = "country_code")
    String countryCode;

    @Column(name = "country")
    String country;
}
