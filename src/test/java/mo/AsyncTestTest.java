package mo;

import lombok.extern.slf4j.Slf4j;
import mo.async.AsyncTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class) // 指定启动类
public class AsyncTestTest {
    @Autowired
    private AsyncTest asyncTest;

    @Test
    public void Test() throws ExecutionException {
        try {
            asyncTest.asyncInnerSimple();
            log.warn("结束1");

            asyncTest.asyncInnerWithParameter("void");
            log.warn("结束2");

            Future<String> future = asyncTest.asyncInnerRetureFuture();
            log.warn("结束3");

            log.warn(future.get());
        } catch (InterruptedException e) {

        }
    }
}