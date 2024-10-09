package com.example.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSenderApplication {

	private EmailService emailService;

	public EmailSenderApplication(EmailService emailService) {
		this.emailService = emailService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}

	private void Run(){
		emailService.senEmail("eduvemba18@gmail.com","Email do Foda-se","Se não funcionar ja não sei");
	}


}
