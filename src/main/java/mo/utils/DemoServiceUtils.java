package mo.utils;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/5
 */
public class DemoServiceUtils {
    public static void main(String[] args) {

        System.out.println(getTodayStartTime());
        System.out.println(getYesterdayStartTime());
        System.out.println(getTomorrowStartTime());


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
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-1);
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
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);
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