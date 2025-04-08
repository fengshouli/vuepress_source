package com.msb.mq.service.rocket.trans.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
        try{
            //1.解析消息内容
            for (MessageExt message:list) {
                String body = new String(message.getBody(),"UTF-8");
                //TODO 这里可以引入service类处理

                System.out.println("处理消费者数据：成功:"+message.getTransactionId());
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }catch (Exception e){
            System.out.println("处理消费者数据发生异常"+e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}