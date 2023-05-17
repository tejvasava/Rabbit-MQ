package com.rabbitMq.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitMq.main.dto.PaymentRequest;
import com.rabbitMq.main.publisher.PaytmPublisher;

@RestController
public class PaytmController {

	@Autowired
	private PaytmPublisher publisher;
	
	@PostMapping("/mqPay")
	public String payUsingUPI(@RequestBody PaymentRequest request) {
		
		publisher.doPaymentTransaction(request);
		return "payment request is in process !!";
		
	}
}
