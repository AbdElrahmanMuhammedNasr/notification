package com.example.notification.repository;

import com.example.notification.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecipientRepository extends JpaRepository<Recipient, Long>, JpaSpecificationExecutor<Recipient> {
}