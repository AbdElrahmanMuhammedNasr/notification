package com.example.notification.service.providers;

public interface ChainFactory<B> {
    void start(B message);
}
