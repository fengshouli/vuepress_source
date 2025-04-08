package com.msb.mq.service.rocket.trans.producer;


import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

@Component
public class OrderTransactionListener implements TransactionListener {

    /**
     * 发送half msg 返回send ok后调用的方法
     * @param message
     * @param o
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("开始执行本地事务....");
        LocalTransactionState state;
        try{
            //1.解析消息内容
            String body = new String(message.getBody(),"UTF-8");
            //TODO 这里可以引入service类处理

            //    这里可以由自身的业务去定你的返回状态信息
            //     同步的处理---返回commit后，消息能被消费者消费
            // state = LocalTransactionState.COMMIT_MESSAGE;

            // 同步的处理---返回commit后，消息能被消费者消费
           // state = LocalTransactionState.ROLLBACK_MESSAGE;
           // System.out.println("本地事务已回滚："+message.getTransactionId());

           // 异步的处理---(还有一些逻辑没有 处理完)
            state=LocalTransactionState.UNKNOW;
            System.out.println("本地事务未知："+message.getTransactionId());

        }catch (Exception e){
            System.out.println("执行本地事务失败："+e);
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    /**
     * 定时回查的方法(  定时去调用 RocketMQ  --- >  应用)
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        System.out.println("开始回查本地事务状态："+messageExt.getTransactionId());
        LocalTransactionState state;
        String transactionId = messageExt.getTransactionId();
        //这里如果发现事务表已经插入成功了，那么事务回查  commit
        //这里可以利用本地事务表的记录，进行事务
        int flag=1;
        if (flag==1){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else {
            //返回重试，或者业务上如果认定失败了也可以返回失败
            state = LocalTransactionState.UNKNOW;
        }
        System.out.println("结束本地事务状态查询："+state);
        return state;
    }
}