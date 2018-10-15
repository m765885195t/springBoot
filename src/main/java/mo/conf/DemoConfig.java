package mo.conf;

import mo.dao.mapper.DemoMapperMarker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/15
 */

// 扫描mapper文件
@Configuration
@MapperScan(basePackageClasses = {DemoMapperMarker.class})
public class DemoConfig {
}
