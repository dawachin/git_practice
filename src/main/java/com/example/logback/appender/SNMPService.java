package com.example.logback.appender;

/**
 * @author anil.dhulipalla
 */
public interface SNMPService {
    void sendEvent(String message, String detail, String priority, String escalation);
}
