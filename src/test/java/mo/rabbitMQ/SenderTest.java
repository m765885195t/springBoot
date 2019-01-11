package mo.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import mo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: gongzhanjing
 * @Date: 2019/1/11
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class) // 指定启动类
public class SenderTest {
    @Autowired
    private Sender sender;

    @Test
    public void hello() {
        sender.send();
    }

}