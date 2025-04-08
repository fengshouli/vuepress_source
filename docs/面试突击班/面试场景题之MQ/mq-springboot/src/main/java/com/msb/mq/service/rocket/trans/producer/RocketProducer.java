package com.msb.mq.service.rocket.trans.producer;


import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

 *类说明： RocketMQ生产者
 */
@RestController
@RequestMapping("/rocket")
public class RocketProducer {
    private static final String SUCCESS = "success";
    private static final String FAILUER = "failure";
    @Autowired
    TransactionProducer producer;  //这里已经转成事务消息的发送

    /**
     * 这里已经转成事务消息的发送
     */
    @GetMapping("/send")
    public String send() throws Exception{ //mq的消息发送
        String txtMsg = "hello rocket";
        //发送半事务消息
        SendResult  sendResult =producer.send(txtMsg,"TransactionTopic");
        if(sendResult.getSendStatus() == SendStatus.SEND_OK){
            return  SUCCESS;
        }else{
            return  FAILUER;
        }
    }
}
