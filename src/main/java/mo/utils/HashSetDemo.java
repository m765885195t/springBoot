package mo.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/22
 */
public class HashSetDemo {
    public static void main(String[] args) {
        List<Long> payJigsawPieceList = Arrays.asList(1L,2L,3L);
        Set<Long> set = new HashSet<>(payJigsawPieceList);
        List<Long> payJigsawPieceList1= Arrays.asList(1L,2L,3L);
        set.removeAll(payJigsawPieceList1);

        System.out.println(set);
    }
}
