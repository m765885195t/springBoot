package mo;

import mo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

//注册拦截器
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    //WebMvcConfigurerAdapter 已过时   2.0  新的实现  WebMvcConfigurationSupport/WebMvcConfiguration

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html");
    }

//    //过滤掉swagger界面
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/swagger-ui.html")
//        .addResourceLocations("classpath:/META-INF/resources/");
//
//    }
}
