package com.msb.mq.controller;


import com.msb.mq.service.rabbit.TransactionalProducerService;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

 *类说明：  RabbitMQ生产者
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TransactionalProducerService transactionalProducerService;

    /**
     * 普通直接交换器的测试
     */
    @GetMapping("/direct")
    public String direct() { //mq的消息发送
        String sendMsg = "direct MSG:"+ System.currentTimeMillis();
        //这个方法没有返回值（）
        this.rabbitTemplate.convertAndSend("DirectExchange","lijin.mq2", sendMsg);
        return "发送direct消息成功！";
    }
    /**
     * RPC模式
     */
    @GetMapping("/rpc")
    public String rpc() {
        String sendMsg = "RPC MSG:" + System.currentTimeMillis();

        // 发送消息并等待响应
        Object response = this.rabbitTemplate.convertSendAndReceive("DirectExchange", "rpc.queue", sendMsg);

        return "RPC 响应: " + response;
    }


    /**
     * 事务消息模式
     */
    @GetMapping("/transactional")
    public String sendTransactionalMessage() {
        try {
            transactionalProducerService.sendTransactionalMessage();
            return "事务消息发送成功！";
        } catch (Exception e) {
            return "事务消息发送失败，已回滚！";
        }
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @GetMapping("/fanout")
    public String fanout() {
        String sendMsg = "Fanout MSG:"+ System.currentTimeMillis();;
        this.rabbitTemplate.convertAndSend("FanoutExchange", "",sendMsg);
        return "发送fanout消息成功！";
    }
}
