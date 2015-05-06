###[Spring JMS Tutorial with ActiveMQ](http://briansjavablog.blogspot.com/2012/09/spring-jms-tutorial-with-activemq.html)

If you don't already have ActiveMQ you'll need to download it at [http://activemq.apache.org/download.html](http://activemq.apache.org/download.html)

1. Copy the downloaded zip to C:\Program Files and unzip.
2. Open a command window and cd to C:\Program Files\apache-activemq-5.6.0-bin\apache-activemq-5.6.0\bin.
3. Start ApacheMQ by calling activemq.bat

![Figure 1.0 ActiveMQ Start-up](http://3.bp.blogspot.com/-aVmTFntFNSE/UFX-OYUlhnI/AAAAAAAAAEo/4LG3PXwdxtk/s640/ActiveMQ-Startup.png)

Now that ActiveMQ has started we can open the admin console by navigating to [http://localhost:8161/admin/index.jsp](http://localhost:8161/admin/index.jsp)

![Figure 2.0 ActiveMQ Admin Console](http://1.bp.blogspot.com/-OllAQmonD3Y/UFX_2HcyONI/AAAAAAAAAEw/NLmJki8Lsk0/s1600/ActiveMQ-Admin-Console.png)

![Figure 3.0 Create New Queues](http://4.bp.blogspot.com/-cC69v_iPTzQ/UFYBepJy2gI/AAAAAAAAAE4/LUojBMVi59I/s1600/ActiveMQ-Admin-Console-Create-Queues.png)

![Figure 4.0 Project Structure](http://2.bp.blogspot.com/-INelMdqFLAE/UFYnuFA0PqI/AAAAAAAAAFI/FNUWPZ8OI28/s1600/Project-Structure.png)

![Figure 5.0 Send JMS Message](http://1.bp.blogspot.com/-yV6eB95FxOk/UFZJhIN7KFI/AAAAAAAAAFY/lC-aHInGfqM/s1600/Put-Message-TestQueueOne.png)

![Figure 6.0 Messages pushed to TestQueueTwo](http://3.bp.blogspot.com/-vEUtTi0eHDI/UFZNmzNpmAI/AAAAAAAAAFo/nhrX-FIFOC8/s1600/MessageQueue-Consumed-Messages.png)

###activemq spring 3 example:

* `Summary`: If you want to run this tutorial locally you can grab the full source code ([here](https://docs.google.com/folder/d/0B_SZOyniHfc1YXE0M3BER242X28/edit)).

* `Другие ссылки`: [Spring JMS with ActiveMQ – hello world example – send message](http://shengwangi.blogspot.com/2014/10/spring-jms-with-activemq-helloworld-example-send.html), [Simple Spring JMS](http://www.springbyexample.org/examples/simple-spring-jms.html)


###ActiveMQ Installation For Windows

* `Installation Procedure for Windows`: [http://apacheactivemq.blogspot.com/2011/11/activemq-installation-procedure-for.html](http://apacheactivemq.blogspot.com/2011/11/activemq-installation-procedure-for.html)

* `Introduction`: [http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation](http://activemq.apache.org/getting-started.html#GettingStarted-WindowsBinaryInstallation)

* `apache-activemq-5.11.1-bin.zip`: [http://apache.volia.net/activemq/5.11.1/apache-activemq-5.11.1-bin.zip](http://apache.volia.net/activemq/5.11.1/apache-activemq-5.11.1-bin.zip)


###Проверено

* `работает на jdk1.8 и Tomcat-8`: (в Tomcat-7 почему-то ругается на '.../servlet-api-2.4')

* `TestQueueOne >> TestQueueTwo`: (предварительно запустить ActiveMQ 'apache-activemq-5.11.1\bin>activemq.bat start') нужно послать из (web-админки) [ActiveMQ](http://localhost:8161/admin/index.jsp) N-сообщений от (брокера) '[TestQueueOne](http://localhost:8161/admin/send.jsp?JMSDestination=TestQueueOne&JMSDestinationType=queue)'. После этого программа будет слушать очередь сообщений и перенаправит их на (подписчика) 'TestQueueTwo'.

* `работает на Tomcat-7.0.59`: (под Ubuntu...)