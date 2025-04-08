package com.msb.mq.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

/**
 * 类说明：
 */
@Component
public class OrderMessageListener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = "your-topic")
    @RetryableTopic(
            attempts = "5", // 重试次数
            backoff = @Backoff(delay = 2000) // 重试间隔
    )
    public void listen(String message) {
        // 处理消息的逻辑
    }
}
