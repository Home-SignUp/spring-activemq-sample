package com.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class MessagingConfiguration {

    private static final String USER_SEND_QUEUE = "send-user"; //TODO: Очередь уже подтвержденных клиентских заказов (ID-клиента отправителя... confirmed-order)

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultDestinationName(USER_SEND_QUEUE);
        return template;
    }
}
