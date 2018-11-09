package mo.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/8
 */
public class en {
    public static void main(String[] args) {

        Map<String, Object> map = Maps.newHashMap();
        for (EventPlanningRules rule : EventPlanningRules.values()) {
            System.out.println(String.valueOf(rule) + "   " + rule.getCode());
        }

    }

    // 活动勋章的规则类别
    public static enum EventPlanningRules {
        Continuous_Login(0),   //连续登录
        Cumulative_Login(1),   //累计登录

        ;

        final int code;

        EventPlanningRules(int code) {
            this.code = code;
        }

        public static boolean checkCode(int code) {
            for (EventPlanningRules type : EventPlanningRules.values()) {
                if (type.getCode() == code) {
                    return true;
                }
            }
            return false;
        }

        public int getCode() {
            return code;
        }

    }
}
