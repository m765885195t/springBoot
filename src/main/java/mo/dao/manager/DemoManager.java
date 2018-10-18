package mo.dao.manager;

import mo.dao.mapper.DemoMapper;
import mo.dao.model.Demo;
import mo.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */
@Repository
public class DemoManager {

    @Autowired
    @Lazy

    private DemoMapper demoMapper;

    public Demo get(String name) {
        return  demoMapper.get(name);
    }

    public List<Demo> list() {
        return  demoMapper.list();
    }
}
