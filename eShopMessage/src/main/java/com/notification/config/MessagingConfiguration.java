package com.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class MessagingConfiguration {

    private static final String ORDER_CONFIRMED_QUEUE = "confirmed-order"; //TODO: Очередь уже подтвержденных клиентских заказов (ID-клиента отправителя)

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultDestinationName(ORDER_CONFIRMED_QUEUE);
        return template;
    }
}
