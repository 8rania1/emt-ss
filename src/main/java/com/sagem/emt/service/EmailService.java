package com.sagem.emt.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
	private final String from = "rania.mensi.2000@gmail.com";
	private final JavaMailSender emailSender;

	public void notification(String recipient, String subject, String content) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(from);
			helper.setTo(recipient);
			helper.setText(content, true);
			helper.setSubject(subject);
			emailSender.send(message);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
