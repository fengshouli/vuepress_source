package com.msb.mq.service.rocket.trans.producer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConsumerDld {
    //这里创建一个消费者 %DLQ%consumer-group
    String consumerGroup = "consumer-group-dld";
    DefaultMQPushConsumer consumer;

    @Autowired
    OrderListenerDld orderListenerDld;
    
    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        //这里的consumer-group  就是和分布式事务的消费者端的消费者分组对应
        consumer.subscribe("%DLQ%consumer-group","*");
        consumer.registerMessageListener(orderListenerDld);
        consumer.start();
    }
}