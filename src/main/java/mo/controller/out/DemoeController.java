package mo.controller.out;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.extern.slf4j.Slf4j;
import mo.dao.model.Stu;
import mo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

@Api(tags = "用户接口2", description = "URL:/out/demoe")
@RestController
@RequestMapping(DemoeController.URL)
@Slf4j
public class DemoeController {
    static final String URL = "/out/demoe";

    @Autowired
    public Stu bean;

    @Autowired
    public DemoService demoService;


    // value是方法描述      notes是注意事项  response是返回类型的描述
    @ApiOperation(value = "展示用户信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name", value = "用户名", required = true),
            @ApiImplicitParam(name = "name1", value = "用户名2", required = false,
                    examples = @Example(value = {
                            @ExampleProperty(value = "{'property': 'test'}", mediaType = "application/json")
                    }))
    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "无权限访问",
//                    examples = @Example(value = {
//                            @ExampleProperty(value = "{'property': 'test'}", mediaType = "application/json")
//                    })
//            )
//    })

    @RequestMapping(params = "method=get", method = RequestMethod.GET)
    public Map<String, Object> get(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "name1", required = false) String name1,
                                   HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = Maps.newHashMap();
        log.warn("开始调用server{}", "hahaha");// 日志中的占位符
        map.put("demo", demoService.get(name));
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
