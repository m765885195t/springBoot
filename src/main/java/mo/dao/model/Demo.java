package mo.dao.model;

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
public class Demo {
    @NonNull
    private String name;
    @NonNull
    private String age;
    @NonNull
    private String sex;
}
