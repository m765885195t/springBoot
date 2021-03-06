package mo.controller.in;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mo.constant.aa;
import mo.dao.model.Demo;
import mo.dao.model.Stu;
import mo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

@Api(tags = "用户接口3", description = "URL:/in/demo1")
@RestController
@RequestMapping(Demo1Controller.URL)
@Slf4j
public class Demo1Controller {
    static final String URL = "/in/demo1";

    @Autowired
    public Stu bean;

    @Autowired
    public DemoService demoService;



    // value是方法描述      notes是注意事项  response是返回类型的描述
    @ApiOperation(value = "展示用户信息",response = Demo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名",defaultValue="motian",
                    paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "name2", value = "用户名1",
                    paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "name3", value = "用户名2",
                    paramType = "query", dataType = ""),
            @ApiImplicitParam(name = "name4", value = "用户名3",
                    paramType = "query", dataType = "boolean"),
            @ApiImplicitParam(name = "name5", value = "用户名4",
                    paramType = "query"),

    })
    @RequestMapping(params = "method=get", method = RequestMethod.GET)
    public Map<String, Object> get(@RequestParam(value = "name", required = true) String name,
                                   @RequestParam(value = "name2", required = true) long name2,
                                   @RequestParam(value = "name3", required = true) String name3,
                                   @RequestParam(value = "name4", required = true) boolean name4,
                                   @RequestParam(value = "name5", required = true) String name5,

                                   HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        log.warn("开始调用server{}", "hahaha");// 日志中的占位符
        map.put("demo", demoService.list());
        map.put("demo1", 1);
        return map;
    }


    // value是方法描述      notes是注意事项  response是返回类型的描述
    @ApiOperation(value = "展示用户信息")
    @RequestMapping(params = "method=list", method = RequestMethod.GET)
    public Map<String, Object> list(
            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        log.warn("开始调用server{}", "hahaha");// 日志中的占位符
        map.put("demo", demoService.list());
        return map;
    }

}
