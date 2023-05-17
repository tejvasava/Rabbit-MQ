package com.rabbitMq.main.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequest {

	private String transactionId;
	private String srcAccouont;
	private String destAccount;
	private int txnAmount;
	private Date txnDate;
}
