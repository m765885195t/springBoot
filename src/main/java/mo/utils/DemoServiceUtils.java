package mo.utils;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Calendar;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/5
 */
public class DemoServiceUtils {
    public static void main(String[] args) {


        System.out.println(getWeekStartTime(getTodayStartTime()));
        System.out.println(getNextWeekStartTime(getTodayStartTime()));
        System.out.println(getTuesdayStartTime(getTodayStartTime()));


    }
    /**
     * 获取指定时间所在周的周一开始时间
     */
    public static long getWeekStartTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
    /**
     * 获取指定时间所在周的下周一开始时间
     */
    public static long getNextWeekStartTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getWeekStartTime(time));
        cal.add(Calendar.DATE, 7);
        return cal.getTimeInMillis();
    }
    /**
     * 获取指定时间所在周的周二开始时间
     */
    public static long getTuesdayStartTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getWeekStartTime(time));
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.add(Calendar.DATE, 1);
        return cal.getTimeInMillis();
    }


    public static long getWeekStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getDayStartTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getTodayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        return getDayStartTime(cal);
    }

    public static long getYesterdayStartTime(Calendar cal) {
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getYesterdayStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        return getYesterdayStartTime(cal);
    }

    public static long getTomorrowStartTime(Calendar cal) {
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    public static long getTomorrowStartTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        return getTomorrowStartTime(cal);
    }

}

@Data
@RequiredArgsConstructor
class MT {
    String name;
    @NonNull
    int age;

}