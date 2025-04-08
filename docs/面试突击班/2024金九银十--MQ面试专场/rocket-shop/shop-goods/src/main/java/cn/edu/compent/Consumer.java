package cn.edu.compent;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
//分布式事务的--消费者
@Component
public class Consumer {

    String consumerGroup = "consumer-group";
    DefaultMQPushConsumer consumer;

    @Autowired
    OrderListener orderListener;
    
    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("trans-order","*");
        consumer.registerMessageListener(orderListener);
        // 2次重试就进死信队列（为了演示的方式。默认是16，不去设置的话）
        consumer.setMaxReconsumeTimes(2);
        consumer.start();
    }
}