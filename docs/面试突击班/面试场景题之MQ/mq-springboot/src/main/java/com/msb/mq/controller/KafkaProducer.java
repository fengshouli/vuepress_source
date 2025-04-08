package com.msb.mq.controller;


import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

 *类说明： Kafka生产者
 */
@RestController
@RequestMapping("/kafka")
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 普通类型测试
     */
    @GetMapping("/send")
    public String send() throws Exception{ //mq的消息发送
        String txtMsg = "hello kafka";
        kafkaTemplate.send("kTopic",null,txtMsg);
        return  "MQ发送消息成功！！";
    }



}
