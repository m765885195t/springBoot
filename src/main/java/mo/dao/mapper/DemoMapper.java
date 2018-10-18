package mo.dao.mapper;

import mo.dao.model.Demo;
import mo.redis.RedisCache;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */

public interface DemoMapper {

    @RedisCache(type = Demo.class)
    Demo get(@Param("name") String name);

    @RedisCache(type = List.class)
    List<Demo> list();
}
