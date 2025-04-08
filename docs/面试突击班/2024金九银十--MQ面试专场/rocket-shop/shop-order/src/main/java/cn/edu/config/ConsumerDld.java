package cn.edu.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConsumerDld {

    String consumerGroup = "consumer-group1";
    DefaultMQPushConsumer consumer;

    @Autowired
    OrderListenerDld orderListener;
    
    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("%DLQ%consumer-group","*");
        consumer.registerMessageListener(orderListener);

        consumer.setMaxReconsumeTimes(2); //这里消费失败2次后（总计3次） 进入死信队列
        consumer.start();
    }
}