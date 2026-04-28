package com.softserve.academy.model;

import com.softserve.academy.exception.NotDeliverableException;

public class SmsNotification extends Notification {
    private String phoneNumber;
    private boolean isFlash;

    public SmsNotification(String recipient, String message, int priority, String phoneNumber, boolean isFlash) {
        super(recipient, message, priority);
        // TODO: Ініціалізація додаткових полів
        this.phoneNumber = phoneNumber;
        this.isFlash = isFlash;
    }

    @Override
    public boolean isDeliverable() {
        // TODO: Номер починається з + і має довжину 10-15 символів
        return phoneNumber != null && phoneNumber.startsWith("+") && phoneNumber.length()>=10 && phoneNumber.length()<=15;
    }

    public boolean isOverLimit() {
        // TODO: true якщо message > 160 символів

        return message !=null && message.length()>160;
    }

    @Override
    public String getFormattedMessage() {
        // TODO: Обрізає до 160 символів якщо довше
        if (message.length() > 160) {
            return message.substring(0, 160);
        }
        return message;
    }

    @Override
    public int estimateDeliverySeconds() {
        // TODO: 5
        return 5;
    }

    @Override
    protected void performSend() {
        System.out.println("SMS IS SENDING"+ message);
    }

    public String getPhoneNumber() { return phoneNumber; }
    public boolean isFlash() { return isFlash; }
}
