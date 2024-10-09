package com.example.EmailSender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String remetente;

    @Async
    public String senEmail(String to, String subject, String body) {
        try {


            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(remetente);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);

             return  "Menssagem enviada com sucesso";
        }
        catch (Exception e) {
            return "Erro ao tentar enviar o email " + e.getLocalizedMessage();
        }
    }
}
