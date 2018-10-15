package mo.service;

import mo.dao.manager.DemoManager;
import mo.dao.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */
@Service
public class DemoService {

    @Autowired
    DemoManager demoManager;

    public Demo get(String name) {
        return demoManager.get(name);
    }
}
