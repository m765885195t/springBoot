package mo.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: gongzhanjing
 * @Date: 2019/1/11
 */

@Component
@RabbitListener(queues = "motian")
public class Receiver {
    @RabbitHandler
    public void proccer(String context) {
        System.out.println("Receiver" + context);
    }
}
