package mo.dao.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/12
 */
@Configuration
public class Prop {

    @Bean
    @Profile("dev")
    public Demo devDemo(){
        return new Demo("dev");
    }


    @Bean
    @Profile("oline")
    public Demo onlineDemo(){
        return new Demo("online");
    }
}
