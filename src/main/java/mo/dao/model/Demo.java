package mo.dao.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class Demo {
    @NonNull
    private String name;
    private String age;
}
