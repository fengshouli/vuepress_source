package com.msb.mq.service.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "rpc.queue")
public class ConsumerRPC {
public String handleRpcMessage(String message) {
    System.out.println("收到 RPC 请求: " + message);
        // 处理消息并返回响应
        return "处理后的响应: " + message.toUpperCase();
    }
}
