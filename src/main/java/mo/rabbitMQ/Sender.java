package mo.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: gongzhanjing
 * @Date: 2019/1/11
 */

// 发送者
@Component
public class Sender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello" + new Date();
        amqpTemplate.convertAndSend("motian", context);
    }
}
