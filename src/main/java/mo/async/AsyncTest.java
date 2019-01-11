package mo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/19
 */
@Slf4j
@Component
public class AsyncTest {
    @Async
    public void asyncInnerSimple() throws InterruptedException {
        Thread.sleep(1000);
        log.warn("无返回值调用");
    }
    @Async
    void asyncInnerPrivate() throws InterruptedException {
        Thread.sleep(1000);

        log.warn("私有方法");
    }
    @Async
    public void asyncInnerWithParameter(String str) throws InterruptedException {
        Thread.sleep(1000);
        log.warn("无返回值带参数调用 str=" + str);
        throw new IllegalArgumentException(str);
    }
    @Async
    public Future<String> asyncInnerRetureFuture() {
        Future<String> future;
        try {
            Thread.sleep(2000);
            throw  new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
            future = new AsyncResult<>("false");
        }
        log.warn("带返回值调用");
        return future;

    }
}
