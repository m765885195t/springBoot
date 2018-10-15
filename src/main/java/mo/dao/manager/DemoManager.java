package mo.dao.manager;

import mo.dao.mapper.DemoMapper;
import mo.dao.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */
@Repository
public class DemoManager {

    @Autowired
    private DemoMapper demoMapper;

    public Demo get(String name) {
        return demoMapper.get(name);
    }
}
