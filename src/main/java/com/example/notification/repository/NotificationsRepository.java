package com.example.notification.repository;

import com.example.notification.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationsRepository extends JpaRepository<Notifications, Long>, JpaSpecificationExecutor<Notifications> {
}