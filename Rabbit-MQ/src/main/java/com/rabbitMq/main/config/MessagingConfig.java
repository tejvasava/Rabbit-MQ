package com.rabbitMq.main.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;






@Configuration
public class MessagingConfig {

	
	public static final String ROUTING_KEY = "paytm_routingkey";
	public static final String EXCHANGE = "paytm_exchange";

	@Bean
	public Queue queue() {
		return new Queue("paytm_queue");
	}
	
	@Bean
	public Exchange exchange()
	{
		return new TopicExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("ROUTING_KEY");
	}
	
	public AmqpTemplate template(ConnectionFactory factory)
	{
		RabbitTemplate template=new RabbitTemplate(factory);
		
		template.setMessageConverter(convertor());
		return template;
	}

	@Bean
	public MessageConverter convertor() {
		// TODO Auto-generated method stub
		return new Jackson2JsonMessageConverter();
	}
}
