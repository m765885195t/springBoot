package mo.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import mo.dao.model.Demo;

import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/5
 */
public class aa {
    @Data
    @ApiModel
    public static class response1{
        private List<Demo> demo;
        @ApiModelProperty( example = "motian")
        private String  demo1;
    }

}
