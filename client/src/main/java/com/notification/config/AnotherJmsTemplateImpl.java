//package com.notification.config;
//
//import org.springframework.jms.core.JmsTemplate;
//
//import javax.jms.ConnectionFactory;
//
//public class AnotherJmsTemplateImpl implements AnotherJmsTemplate {
//
//    public AnotherJmsTemplateImpl(){
//    }
//
//    public AnotherJmsTemplateImpl(String USER_RECEIVE_QUEUE, ConnectionFactory connectionFactory){
//        this.USER_RECEIVE_QUEUE = USER_RECEIVE_QUEUE;
//        this.connectionFactory = connectionFactory;
//    }
//
//    private String USER_RECEIVE_QUEUE;
//    private ConnectionFactory connectionFactory;
//
//    public void setUserQueue(String USER_RECEIVE_QUEUE) {
//        this.USER_RECEIVE_QUEUE = USER_RECEIVE_QUEUE;
//    }
//
//    public void setConnectionFactory(ConnectionFactory connectionFactory) {
//        this.connectionFactory = connectionFactory;
//    }
//
//    public JmsTemplate jmsTemplate(){
//        JmsTemplate template = new JmsTemplate();
//        template.setConnectionFactory(connectionFactory);
//        template.setDefaultDestinationName(USER_RECEIVE_QUEUE);
//        return template;
//    }
//
//}
