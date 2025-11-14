package dev.java10x.email.service;

import dev.java10x.email.domain.EmailModel;
import dev.java10x.email.enums.EmailStatus;
import dev.java10x.email.repositorie.EmailRepository;
import jakarta.transaction.Transactional;
import lombok.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;

public class EmailService {

    private JavaMailSender mailSender;
    private EmailRepository emailRepository;

    @Value("${EMAIL_USERNAME}")
    private String emailFrom;


    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository, String emailFrom) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
        this.emailFrom = emailFrom;
    }


    @Transactional
    public void sendEmail(EmailModel emailModel) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getEmailSubject());
            message.setText(emailModel.getBody());
            mailSender.send(message);
            emailModel.setStatusEmail(EmailStatus.SENT);
            emailModel.setSendDateEmai(LocalDateTime.now());
        } catch (Exception e) {
            emailModel.setStatusEmail(EmailStatus.FAILED);
            System.out.println("Erro ao enviar email: " + e.getMessage());
        }

        emailRepository.save(emailModel);
    }

}
