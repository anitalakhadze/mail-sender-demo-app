package com.example.mailsenderdemoapp;

import com.example.mailsenderdemoapp.model.Mail;
import com.example.mailsenderdemoapp.service.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MailSenderDemoAppApplication {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setMailFrom("hello@anita.com");
        mail.setMailTo("medium.readers@gmail.com");
        mail.setMailSubject("Thanks!");
        mail.setMailContent("Thank you for reading my blogs!");

        ApplicationContext ctx = SpringApplication.run(MailSenderDemoAppApplication.class, args);
        MailService mailService = (MailService) ctx.getBean("mailServiceImpl");
        mailService.sendEmail(mail);
    }

}
