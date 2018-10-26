package mo.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "demo")
@ApiModel(value = "Demo", description = "样例相关")
public class Demo {
    @ApiModelProperty(value = "用户名", example = "motian")
    private String name;
    @ApiModelProperty(value = "年龄", example = "20 ")
    private int age;
    @ApiModelProperty(value = "性别", example = "nan ")
    private em.PublishState sex;
}
