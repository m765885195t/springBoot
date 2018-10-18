package mo.dao.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "demo")
//@ApiModel(value = "Demo", description = "demo类")
public class Demo {
    @NonNull
    @ApiModelProperty(value = "用户名",example ="motian")
    private String name;
    @NonNull
    @ApiModelProperty(value = "年龄",example ="20 ")

    private String age;
    @NonNull
    @ApiModelProperty(value = "性别",example ="nan")

    private String sex;
}
