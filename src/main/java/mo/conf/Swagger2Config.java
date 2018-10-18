package mo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/16
 */

//接口文档配置相关
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})  //只在测试开发环境使用
public class Swagger2Config{
    private static final String internalPackage = "mo.controller.in";
    private static final String publicPackage = "mo.controller.out";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()  //文档生成
//                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                    .apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage(publicPackage))
                .paths(PathSelectors.any())
                    .build()
                .groupName("外部")

                .useDefaultResponseMessages(false)  //使用默认响应信息
                .apiInfo(apiInfo())
                .enableUrlTemplating(true)
                ;
    }
    @Bean
    public Docket create2RestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()  //文档生成
//                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage(internalPackage))
                .paths(PathSelectors.any())
                .build()
                .groupName("内部")
                .useDefaultResponseMessages(false)  //使用默认响应信息
                .apiInfo(apiInfo())
                .enableUrlTemplating(true)
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("有道数学接口文档")
                .description("描述:接口分为内外部")
//                .termsOfServiceUrl("k12sandbox.youdao.com/yxt/swagger-ui.html")
                .version("1.0")
                .build();

    }
}
