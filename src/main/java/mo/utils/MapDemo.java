package mo.utils;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/29
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> demo = Maps.newHashMap();
        demo.put(1, 1);
        demo.put(2, 1);
        demo.put(3, 1);

        demo.merge(2, 2, (x, y) -> x + y);
        demo.merge(3, 3, (x, y) -> y);
        demo.merge(1, 5, (x, y) -> x);
        demo.merge(5, 5, (x, y) -> x+y);
        System.out.println(demo);
    }
}
