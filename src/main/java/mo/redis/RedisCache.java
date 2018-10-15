package mo.redis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */

/**
 * 该注解标记使用redis缓存
 */
//四种元注解  用来注解自定义注解
@Retention(RetentionPolicy.RUNTIME)   //注解生命周期
@Target(ElementType.METHOD)   //注解用于的地方
@Documented  //是否包含在javadoc中
@Inherited   //允许子类继承该注解
public @interface RedisCache {
    Class type();
}
