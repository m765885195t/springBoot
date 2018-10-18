package mo.redis;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

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


    @Around(value = "execution(* mo.dao.mapper.*.*(..))")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取类名和方法名,参数
        String clazzName = joinPoint.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        //根据类名,方法名,参数生成key
        String key = getKey(clazzName, methodName, args);
        log.info("生成的key={}", key);

        //获取被代理的方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取被代理方法上的注解
        Class modelType = method.getAnnotation(RedisCache.class).type();

        //查询缓存
        String value = (String) redisTemplate.opsForHash().get(modelType.getName(), key);

        Object result = null;
        if (null == value) { // 缓存中没有
            log.info("缓存中没有");
            result = joinPoint.proceed(args);
            //将结果序列化化    加入缓存
            String json = serialize(result);
            redisTemplate.opsForHash().put(modelType.getName(), key, json);
            log.info("modelType.getName()={},key={},json={}",modelType.getName(),key,json);

        } else {
            log.info("在缓存");
            //反序列化获取结果
            Class returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
            result = deserialize(value, returnType, modelType);

            log.info("value={},returnType={},modelType={}",value,returnType,modelType);

        }
        log.info("result={}", result);
        return result;
    }

    /**
     * 根据类名+方法名+参数生成key
     *
     * @param clazzName
     * @param methodName
     * @param args
     * @return
     */
    private String getKey(String clazzName, String methodName, Object[] args) {
        StringBuilder stringBuilder = new StringBuilder(clazzName);
        stringBuilder.append(methodName);

        for (Object o : args) {
            stringBuilder.append(o);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }


    /**
     * 序列化对象
     *
     * @param target
     * @return
     */
    private String serialize(Object target) {
        return JSON.toJSONString(target);
    }

    /**
     * 反序列化对象
     *
     * @param json
     * @param clazz
     * @param modeType
     * @return
     */
    private Object deserialize(String json, Class clazz, Class modeType) {
        // 结果为list
        if (clazz.isAssignableFrom(List.class)) {
            return JSON.parseObject(json, modeType);
        }

        //普通对象
        return JSON.parseObject(json, clazz);
    }
}
