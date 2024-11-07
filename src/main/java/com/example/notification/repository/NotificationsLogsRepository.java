package com.example.notification.repository;

import com.example.notification.model.NotificationsLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationsLogsRepository extends JpaRepository<NotificationsLogs, Long>, JpaSpecificationExecutor<NotificationsLogs> {
}