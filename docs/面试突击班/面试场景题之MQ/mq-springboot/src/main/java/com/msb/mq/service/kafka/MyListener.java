package com.msb.mq.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 类说明：
 */
@Component
public class MyListener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"kTopic"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("收到服务器的应答: " + record.value().toString());
    }
}
