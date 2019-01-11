package mo.rabbitMQ;

import com.google.common.collect.Queues;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

/**
 * @Author: gongzhanjing
 * @Date: 2019/1/11
 */

// 队列配置
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue() {
        return Queues.newArrayDeque();
    }
}
