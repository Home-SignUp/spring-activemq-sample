###Spring 4 MVC + JMS + ActiveMQ annotation based Example

* [websystique.com/springmvc/spring-4-mvc-jms-activemq-annotation-based-example](http://websystique.com/springmvc/spring-4-mvc-jms-activemq-annotation-based-example/)
* [https://github.com/bsnyder/spring-jms-examples](https://github.com/bsnyder/spring-jms-examples)
* **Java-7** | **Spring-4** | **Tomcat-7** | **ActiveMQ-5**

###Messaging Configuration:

Spring4MVCJmsActiveMQExample
Tomcat 7.0.70
[http://localhost:8086/](http://localhost:8086/)
1099

Spring4MVCJmsActiveMQExample
Tomcat 7.0.70
[http://localhost:8087/](http://localhost:8087/)
1098


![jms-pointToPoint](http://websystique.com/wp-content/uploads/2016/06/jms-pointToPoint.gif)

![jms-publishSubscribe](http://websystique.com/wp-content/uploads/2016/06/jms-publishSubscribe.gif)


**d:**
**cd D:\server\apache-activemq-5.11.1\bin**
**activemq start**


You can quickly check the WebConsole [available at [http://localhost:8161/admin/](http://localhost:8161/admin/) with credentials `admin/admin`.
![SpringMVCJMSEX1_img1](http://websystique.com/wp-content/uploads/2016/06/SpringMVCJMSEX1_img1.png)

[http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp)

          Имя         |  Количество ожидающих сообщений  |  Количество потребителей  |  Сообщения помещенные в очередь  |  Отправленные сообщения  |  Просмотры               |  Операции
                      |                                  |                           |                                  |                          |                          |
 order-queue          | 2                                | 0                         | 2                                | 0                        | Browse, Active Consumers | Send To, Purge, Delete
                                                                                                                                                     Active Producers
                      |                                  |                           |                                  |                          |                          |
 order-response-queue | 0                                | 1                         | 0                                | 0                        | Browse, Active Consumers | Send To, Purge, Delete
                                                                                                                                                     Active Producers
                      |                                  |                           |                                  |                          |                          |
                      |                                  |                           |                                  |                          |                          |
 order-queue          | 0                                | 1                         | 2                                | 2                        | Browse, Active Consumers | Send To, Purge, Delete
                                                                                                                                                     Active Producers
                      |                                  |                           |                                  |                          |                          |
 order-response-queue | 0                                | 1                         | 2                                | 2                        | Browse, Active Consumers | Send To, Purge, Delete
                                                                                                                                                     Active Producers


[http://localhost:8161/admin/topics.jsp](http://localhost:8161/admin/topics.jsp)

                          Имя                      |  Количество потребителей  |  Сообщения помещенные в очередь  |  Отправленные сообщения  |  Операции
                                                   |                           |                                  |                          |
ActiveMQ.Advisory.Connection                       | 0                         | 5                                | 0                        | Send To, Active Subscribers
                                                                                                                                               Active Producers
                                                                                                                                               Delete
                                                   |                           |                                  |                          |
ActiveMQ.Advisory.Consumer.Queue.order-response... | 0                         | 1                                | 0                        | Send To, Active Subscribers
                                                                                                                                               Active Producers
                                                                                                                                               Delete
                                                   |                           |                                  |                          |
ActiveMQ.Advisory.Producer.Queue.order-queue       | 0                         | 4                                | 0                        | Send To, Active Subscribers
                                                                                                                                               Active Producers
                                                                                                                                               Delete
                                                   |                           |                                  |                          |
ActiveMQ.Advisory.Queue                            | 0                         | 2                                | 0                        | Send To, Active Subscribers
                                                                                                                                               Active Producers
                                                                                                                                               Delete


[http://localhost:8086/](http://localhost:8086/)
[http://localhost:8086/newOrder](http://localhost:8086/newOrder)
[http://localhost:8086/checkStatus](http://localhost:8086/checkStatus)
![SpringMVCJMSEX1_img7](http://websystique.com/wp-content/uploads/2016/06/SpringMVCJMSEX1_img7.png)

![SpringMVCJMSEX1_img8](http://websystique.com/wp-content/uploads/2016/06/SpringMVCJMSEX1_img8.png)

![SpringMVCJMSEX1_img9](http://websystique.com/wp-content/uploads/2016/06/SpringMVCJMSEX1_img9.png)

[http://localhost:8087/](http://localhost:8087/)
![SpringMVCJMSEX1_img10](http://websystique.com/wp-content/uploads/2016/06/SpringMVCJMSEX1_img10.png)


###ActiveMQ Installation For Windows

* `Installation Procedure for Windows`: [http://apacheactivemq.blogspot.com/2011/11/activemq-installation-procedure-for.html](http://apacheactivemq.blogspot.com/2011/11/activemq-installation-procedure-for.html)

* `Introduction`: [http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation](http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation)

* `apache-activemq-5.11.1-bin.zip`: [http://apache.volia.net/activemq/5.11.1/apache-activemq-5.11.1-bin.zip](http://apache.volia.net/activemq/5.11.1/apache-activemq-5.11.1-bin.zip)
