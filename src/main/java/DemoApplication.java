import mo.dao.model.Stu;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "mo")
@Configuration
public class DemoApplication {

    public static void main(String[] args) {
//        启动方式
//        SpringApplication.run(DemoApplication.class,args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
        builder.bannerMode(Banner.Mode.OFF).run(args);//关闭banner
    }

    @Bean
    public Stu stuBean(){
        return new Stu();
    }
}
