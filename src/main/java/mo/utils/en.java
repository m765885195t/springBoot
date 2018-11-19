package mo.utils;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/8
 */
public class en {
    public static void main(String[] args) {

//        Map<String, Object> map = Maps.newHashMap();
//        for (EventPlanningRules rule : EventPlanningRules.values()) {
//            System.out.println(String.valueOf(rule) + "   " + rule.getCode());
//        }
        List<Long> list = getReview(10);

        list.remove(0);
        list.removeIf(o->1==1);

        System.out.println(list.get(0));
    }
    private static List<Long> getReview(int reviewCount) {
        // 假定今天是第7天

        List<Long> accuracyExercise = Arrays.asList(1L,2L);
        List<Long> routineExercise = Arrays.asList(3L,4L);
        List<Long> countExercise = new ArrayList<>();

        countExercise.addAll(accuracyExercise);
        countExercise.addAll(routineExercise);

        return countExercise.subList(0, 4);
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
