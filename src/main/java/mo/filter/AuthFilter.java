package mo.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */


//过滤器的实现方式1-----通过注解

@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
@Order(50)
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("过滤器AuthFilter doFilter开始初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.warn("过滤器AuthFilter doFilter开始执行");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.warn("过滤器AuthFilter doFilter开始销毁");

    }
}
