package com.example.notification.service.providers;


public interface Messenger<B> {
    boolean send(B message);
}
