package mo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */
@Slf4j
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("过滤器TestFilter doFilter开始初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.warn("过滤器TestFilter doFilter开始执行");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.warn("过滤器TestFilter doFilter开始注销");
    }
}
