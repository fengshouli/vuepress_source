package com.msb.mq.service.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional // 开启事务
    public void sendTransactionalMessage() {
        String sendMsg = "Transactional MSG:" + System.currentTimeMillis();

        try {
            // 发送消息
            rabbitTemplate.convertAndSend("DirectExchange", "transactional.queue", sendMsg);

            // 模拟业务逻辑
            boolean businessSuccess = doBusinessLogic();
            if (!businessSuccess) {
                throw new RuntimeException("业务逻辑失败，回滚事务");
            }

            System.out.println("事务消息发送成功！");
        } catch (Exception e) {
            System.out.println("事务消息发送失败，已回滚！");
            throw e; // 抛出异常触发回滚
        }
    }

    private boolean doBusinessLogic() {
        // 模拟业务逻辑（比如mybatis的操作）
        return true; // 返回 true 表示成功，false 表示失败
    }
}
