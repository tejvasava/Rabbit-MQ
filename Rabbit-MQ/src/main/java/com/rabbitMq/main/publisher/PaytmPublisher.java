package com.rabbitMq.main.publisher;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitMq.main.config.MessagingConfig;
import com.rabbitMq.main.dto.PaymentRequest;

@Service
public class PaytmPublisher {

	@Autowired
	private RabbitTemplate template;
	
	public void doPaymentTransaction(PaymentRequest request)
	{
		request.setTransactionId(UUID.randomUUID().toString());
		request.setTxnDate(new Date());
		template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,request);
	}
	
}
