package mo;

import lombok.extern.slf4j.Slf4j;
import mo.dao.model.Stu;
import mo.filter.TestFilter;
import mo.rabbitMQ.Sender;
import org.junit.Test;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;

@Slf4j
@SpringBootApplication(scanBasePackages = "mo")
@EnableAsync
@EnableRabbit
public class DemoApplication implements AsyncConfigurer {
    // todo 统一管理api
    private String filterUrlPatterns = "/*";


    public static void main(String[] args) {
//        启动方式
//        SpringApplication.run(mo.DemoApplication.class,args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
        //关闭banner
        builder.bannerMode(Banner.Mode.OFF).run(args);
        log.trace("das");
    }

    @Bean
    public Stu stuBean() {
        return new Stu();
    }

    @Bean
    public FilterRegistrationBean<TestFilter> filterRegistrationBean() {
        FilterRegistrationBean<TestFilter> filterRegistrationBean = new FilterRegistrationBean<>(new TestFilter());

        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.setOrder(100);
        filterRegistrationBean.addUrlPatterns(filterUrlPatterns);
        return filterRegistrationBean;
    }

    // 自定义线程池
    @Override
    public AsyncTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();

        //设置线程前缀名
        threadPoolExecutor.setThreadNamePrefix("motian Thread-");
        threadPoolExecutor.setMaxPoolSize(10);
        threadPoolExecutor.setCorePoolSize(1);
        threadPoolExecutor.setQueueCapacity(5);
        // 设置拒绝策略
        threadPoolExecutor.setRejectedExecutionHandler((r, executor) -> {
        });
        threadPoolExecutor.initialize();

        return threadPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }


    /**
     * 自定义异常处理类
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            log.info("Exception message - " + throwable.getMessage());
            log.info("Method name - " + method.getName());
            for (Object param : obj) {
                log.info("Parameter value - " + param);
            }
        }

    }
}
