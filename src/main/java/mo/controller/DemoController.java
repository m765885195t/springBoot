package mo.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import mo.dao.model.Stu;
import mo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

@RestController
@RequestMapping(DemoController.URL)
@Slf4j
public class DemoController {
    static final String URL = "/demo";

    @Autowired
    public Stu bean;

    @Autowired
    public DemoService demoService;

    @RequestMapping
    public Map<String, Object> show(@RequestParam(value = "name", required = true) String name,
                                    HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = Maps.newHashMap();
        log.warn(bean.toString() + "{}", "hahaha");// 日志中的占位符
        map.put("demo", demoService.get(name));
        return map;
    }


}
