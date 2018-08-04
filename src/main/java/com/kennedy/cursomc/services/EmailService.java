package com.kennedy.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.kennedy.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
