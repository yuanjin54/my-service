package fun.yuanjin.common.utils.leetcode;

import java.util.*;

/**
 * @ClassName SubsetsWithDup_90
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-31 11:09
 * @Version 1.0
 */
public class SubsetsWithDup_90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{2, 1, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        System.out.println(result);
        return result;
    }
}
