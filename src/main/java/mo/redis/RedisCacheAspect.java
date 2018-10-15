package mo.redis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */
@Aspect
@Component
@Slf4j
public class RedisCacheAspect {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Pointcut("execution(* mo.dao.mapper.*(..)) && @annotation(RedisCache)")
    public void cacheMeth() {
    }

    @Around("cacheMeth())")
    public Object cache(ProceedingJoinPoint joinPoint) {
        //获取类名和方法名,参数
        String clazzName = joinPoint.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        //根据类名,方法名,参数生成key
        String key = getKey(clazzName, methodName, args);
        log.info("生成的key={}",key);

        //获取被代理的方法
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        //获取被代理方法上的注解
        Class modelType = method.getAnnotation(RedisCache.class).type();


        return null;
    }

    private String getKey(String clazzName, String methodName, Object[] args) {
        String key="";
    }
}
