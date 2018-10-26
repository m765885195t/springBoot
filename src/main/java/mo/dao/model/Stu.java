package mo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "stu")
public class Stu {
    private String id;
    private String name;
    private String pass;

    public static void main(String[] args) {
        System.out.println(A.ONLINE);
    }

    public enum A {
        ALL, ONLINE
    }

}
