package com.msb.mq.service.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**

 *类说明：监听类（自动提交ACK确认，。  只要消息进入了 process 方法，那么RabbitMQ里面内部的处理：消息就从queue中删除 ）
 *
 * 如果 在配置中手动写了绑定queue1的消费者（Receiver类），那么这个 方法就没用了 针对queue1的
 */
@Component
@RabbitListener(queues = "queue1")
public class Consumer1 {

    @RabbitHandler
    public void process(String msg) {
        int i =0;
        System.out.println("Consumer1-Receiver : " + msg);
        //业务代码(同步到MySQL 、sql、 redis、ES 、调用其他接口的操作)，异常    或者就是  有些返回结果就是失败的..怎么办？
    }

}
