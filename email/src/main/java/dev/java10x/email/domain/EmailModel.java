package dev.java10x.email.domain;

import dev.java10x.email.enums.EmailStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_EMAIL")
public class EmailModel {

    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String emailSubject;

    @Column(columnDefinition = "BODY")
    private String body;
    private LocalDateTime sendDateEmai;
    private EmailStatus statusEmail;

    public EmailModel() {
    }

    public EmailModel(UUID emailId, UUID userId, String emailFrom, String emailTo, String emailSubject, String body, LocalDateTime sendDateEmai, EmailStatus statusEmail) {
        this.emailId = emailId;
        this.userId = userId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.emailSubject = emailSubject;
        this.body = body;
        this.sendDateEmai = sendDateEmai;
        this.statusEmail = statusEmail;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSendDateEmai() {
        return sendDateEmai;
    }

    public void setSendDateEmai(LocalDateTime sendDateEmai) {
        this.sendDateEmai = sendDateEmai;
    }

    public EmailStatus getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(EmailStatus statusEmail) {
        this.statusEmail = statusEmail;
    }
}
