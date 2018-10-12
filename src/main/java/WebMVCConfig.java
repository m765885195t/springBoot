import mo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

//注册拦截器
@Configuration
//public class WebMVCConfig extends WebMvcConfigurationSupport {
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    //WebMvcConfigurerAdapter 已过时   2.0  新的实现  WebMvcConfigurationSupport

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**")

        ;
        super.addInterceptors(registry);
    }
}
