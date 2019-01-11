package mo.utils;

import com.google.common.collect.Lists;

import java.util.Calendar;
import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/30
 */
public class TimeUtils {
    public static void main(String[] args) {
//        long time = 1536462671000L;
        long time = System.currentTimeMillis();

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);

        // 设置每周第一天是周一
//        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 设置每周一为 一周的起点
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);


        // 获取  指定时间是周几
        int weekOrder = cal.get(Calendar.DAY_OF_WEEK);
        weekOrder = weekOrder - 1;
        if (weekOrder == 0) {
            weekOrder = 7;
        }
        System.out.println(weekOrder);
        // 获取指定时间所在天的  经过的 小时数
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));

        cal.setTimeInMillis(1536423071000L);
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));

        // 获取 指定时间是一个月中的第几天
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//        System.out.println(cal.getTime());

        //指定时间段   每天重复---小时区间
        Calendar cal2 = Calendar.getInstance();
        // 开始时间对应的 小时 所属周的顺序,所属月的顺序
        cal2.setTimeInMillis(1544371200934L);
        int startHour = cal2.get(Calendar.HOUR_OF_DAY);
        int startDayOfWeek = cal2.get(Calendar.DAY_OF_WEEK);
        startDayOfWeek = startDayOfWeek - 1;
        if (startDayOfWeek == 0) {
            startDayOfWeek = 7;
        }
        int startDayOfMonth = cal2.get(Calendar.DAY_OF_MONTH);

        // 结束时间对应的 小时 所属周的顺序,所属月的顺序
        cal2.setTimeInMillis(1544543999311L);
        int endHour = cal2.get(Calendar.HOUR_OF_DAY);
        int endDayOfWeek = cal2.get(Calendar.DAY_OF_WEEK);
        endDayOfWeek = endDayOfWeek - 1;
        if (endDayOfWeek == 0) {
            endDayOfWeek = 7;
        }
        int endDayOfMonth = cal2.get(Calendar.DAY_OF_MONTH);
        System.out.println(startHour + "   " +
                startDayOfWeek + "    " +
                startDayOfMonth + "    " +
                endHour + "    " +
                endDayOfWeek + "    " +
                endDayOfMonth);

        List<String> list = Lists.newArrayList();
//        list.add(null);
        list.add("");
//        list.add("adas");
//        list.add("adwww");
        System.out.println(list);
    }
}
