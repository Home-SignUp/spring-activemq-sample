package com.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.config.java.plugin.context.AnnotationDrivenConfig;

import javax.jms.ConnectionFactory;

/**
 * @see http://www.basilv.com/psd/blog/2009/java-based-configuration-of-spring-dependency-injection
 * @see https://github.com/basilv/Java-Examples/blob/master/Examples/src/java/com/basilv/examples/spring/autowire/AutowireConfig.java
 *      http://www.sql.ru/forum/792593/spring-ioc-strannosti-springa
 *      https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm
 *      http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-java-combining
 * @see http://docs.spring.io/spring-javaconfig/docs/1.0.0.m3/reference/html/quick-start.html
 *      http://przewidywalna-java.blogspot.com/2014/06/introduce-to-spring-framework-basic.html
 */

@Configuration
@AnnotationDrivenConfig // Needed for @Autowire to work
public class MessagingConfiguration {

    private static final String USER_RECEIVE_QUEUE = "receiver"; //TODO: Очередь новых клиентских заказов (ID-клиента получателя)

    @Autowired
    ConnectionFactory connectionFactory;

    @Bean
////    @Scope("singleton")
//    @Scope("prototype")
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultDestinationName(USER_RECEIVE_QUEUE);
        return template;
    }

//    @Bean
//    public AnotherJmsTemplate jmsTemplate(){
//        AnotherJmsTemplate template = new AnotherJmsTemplateImpl(USER_RECEIVE_QUEUE, connectionFactory);
//        template.jmsTemplate();
//        return template;
//    }

}

