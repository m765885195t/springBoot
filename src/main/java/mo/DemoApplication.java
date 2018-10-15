package mo;

import mo.dao.model.Stu;
import mo.filter.TestFilter;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "mo")
public class DemoApplication {
    // todo 统一管理api
    private String filterUrlPatterns = "/*";

    public static void main(String[] args) {
//        启动方式
//        SpringApplication.run(mo.DemoApplication.class,args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);//关闭banner
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
}
