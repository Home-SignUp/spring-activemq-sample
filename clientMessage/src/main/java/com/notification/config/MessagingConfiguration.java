package com.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class MessagingConfiguration {

    private static final String ORDER_NEW_QUEUE = "receive-user"; //TODO: Очередь новых клиентских заказов (ID-клиента получателя... new-order)

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultDestinationName(ORDER_NEW_QUEUE);
        return template;
    }
}
