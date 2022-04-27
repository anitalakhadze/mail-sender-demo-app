package com.example.mailsenderdemoapp.service;

import com.example.mailsenderdemoapp.model.Mail;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Async
    @Override
    public void sendEmail(Mail mail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setSubject(mail.getMailSubject());
            helper.setFrom(mail.getMailFrom());
            helper.setTo(mail.getMailTo());
            helper.setText(mail.getMailContent(), true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
