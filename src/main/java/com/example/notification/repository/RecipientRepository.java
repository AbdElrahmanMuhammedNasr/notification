package com.example.notification.repository;

import com.example.notification.model.Recipients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecipientRepository extends JpaRepository<Recipients, Long>, JpaSpecificationExecutor<Recipients> {
}