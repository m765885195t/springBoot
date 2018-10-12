package mo.controller;

import mo.dao.model.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping
    public String show(HttpServletRequest request, HttpServletResponse response) {
        log.warn("进来show方法了");
        log.warn(bean.toString() +"{}" ,"hahaha");// 日志中的占位符

        return bean.toString();
    }


}
