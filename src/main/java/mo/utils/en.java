package mo.utils;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/8
 */
public class en {

    static class Solution {
        public int randrange(int begin, int end) {
            if (begin > end) return randrange(end, begin);
            return (int) (Math.random() * (end - begin)) + begin;
        }

        public int clamp(int n, int minV, int maxV) {
            return Math.max(minV, Math.min(maxV, n));
        }

        public int findKthLargest(int[] a, int k) {
            return findKthLargest(a, 0, a.length, clamp(k, 1, a.length));
        }

        public void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private int findKthLargest(int[] a, int iBegin, int iEnd, int k) {
            int iRandom = randrange(iBegin, iEnd);
            swap(a, iBegin, iRandom);
            int iBigger = iBegin;
            for (int i = iBegin + 1; i < iEnd; i++) {
                if (a[i] >= a[iBegin]) swap(a, i, ++iBigger);
            }
            swap(a, iBegin, iBigger);
            int leftNum = iBigger - iBegin + 1;
            if (leftNum > k) return findKthLargest(a, iBegin, iBigger, k);
            if (leftNum < k) return findKthLargest(a, iBigger + 1, iEnd, k - leftNum);
            return a[iBigger];
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, -1));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 0));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 1));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 3));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 4));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 5));
        System.out.println(new Solution().findKthLargest(new int[]{ 1, 2, 3,4, 5}, 6));

//        Map<String, Object> map = Maps.newHashMap();
//        for (EventPlanningRules rule : EventPlanningRules.values()) {
//            System.out.println(String.valueOf(rule) + "   " + rule.getCode());
//        }
//        List<Long> list = getReview(10);
//        list.remove(0);
////        System.out.println(list.get(0));
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
//        descriptiveStatistics.addValue(.1);
//        descriptiveStatistics.addValue(.2);
//        descriptiveStatistics.addValue(.3);
//        descriptiveStatistics.addValue(.4);
//        descriptiveStatistics.addValue(.5);
//        descriptiveStatistics.addValue(.5);
//        descriptiveStatistics.addValue(.5);
//        descriptiveStatistics.addValue(.5);
//        descriptiveStatistics.addValue(.5);
//        System.out.println(descriptiveStatistics.getPercentile(50));
    }

    private static List<Long> getReview(int reviewCount) {
        // 假定今天是第7天

        List<Long> accuracyExercise = Arrays.asList(1L, 2L);
        List<Long> routineExercise = Arrays.asList(3L, 4L);
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
