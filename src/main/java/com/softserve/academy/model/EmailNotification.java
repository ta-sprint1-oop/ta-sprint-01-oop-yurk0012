package com.softserve.academy.model;

import com.softserve.academy.exception.NotDeliverableException;

import java.util.List;

public class EmailNotification extends Notification {
    private String senderEmail;
    private String subject;
    private boolean hasAttachment;

    public EmailNotification(String recipient, String message, int priority, String senderEmail, String subject, boolean hasAttachment) {
        super(recipient, message, priority);
        // TODO: Ініціалізація додаткових полів
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.hasAttachment = hasAttachment;


    }

    @Override
    public boolean isDeliverable() {
        return recipient.contains("@") && recipient.contains(".");
    }

    public boolean isSpam() {
        if (subject == null) return false;

        String lower = subject.toLowerCase();
        return lower.contains("free") || lower.contains("win") || lower.contains("click");
    }

    @Override
    public String getFormattedMessage() {
        return "Subject: " + subject + "\n" + message;
    }

    @Override
    public int estimateDeliverySeconds() {
        // TODO: 30
        return 30;
    }

    @Override
    protected void performSend() {
        System.out.println("Sending email...");
        System.out.println("Content:" + getFormattedMessage());
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }
}
