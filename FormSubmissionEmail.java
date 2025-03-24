package com.example.Assessment.Tracking.forms;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class FormSubmissionEmail implements FormSubmissionManager{
    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public FormSubmissionEmail(MailSender mailSender, SimpleMailMessage templateMessage) {
        this.mailSender = mailSender;
        this.templateMessage = templateMessage;
    }

    public void processFormSubmission(TrackingForm trackingForm) {
        SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
        message.setTo("hassanm4687@gmail.com");
        message.setSubject("Internal Moderator Form");
        message.setText("Internal Moderator Form Submitted!");

        try {
            this.mailSender.send(message);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void processFormSubmission(PanelForm panelForm) {
        SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
        message.setTo("hassanm4687@gmail.com");
        message.setSubject("Panel Moderator Form");
        message.setText("Panel Moderator Form Submitted!");

        try {
            this.mailSender.send(message);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void processFormSubmission(ExternalForm externalForm) {
        SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
        message.setTo("hassanm4687@gmail.com");
        message.setSubject("External Moderator Form");
        message.setText("External Moderator Form Submitted!");

        try {
            this.mailSender.send(message);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
