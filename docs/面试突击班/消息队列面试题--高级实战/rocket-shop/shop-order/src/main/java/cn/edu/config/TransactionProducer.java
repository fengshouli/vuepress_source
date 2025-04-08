package cn.edu.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class TransactionProducer {
    
    private String producerGroup = "order_trans_group";

    // 事务消息
    private TransactionMQProducer producer;

    //用于执行本地事务和事务状态回查的监听器
    @Autowired
    OrderTransactionListener orderTransactionListener;
    //执行（定时回查）任务的线程池
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));
            
    @PostConstruct
    public void init(){
        //这里一定要设置一个 与其他 生产者名字不同个生产者分组
        producer = new TransactionMQProducer(producerGroup);
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setSendMsgTimeout(Integer.MAX_VALUE);
        producer.setExecutorService(executor);
        producer.setTransactionListener(orderTransactionListener); //这个监听很重要
        this.start();
    }
    private void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    //事务消息发送(半事务消息发送)
    public TransactionSendResult send(String data, String topic) throws MQClientException {
        Message message = new Message(topic,data.getBytes());
        return this.producer.sendMessageInTransaction(message, null);
    }
}