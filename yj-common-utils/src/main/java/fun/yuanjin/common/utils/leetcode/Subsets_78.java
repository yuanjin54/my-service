package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subsets_78
 * @Description 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @Author yuanjin
 * @Date 2021-01-09 21:53
 * @Version 1.0
 */
public class Subsets_78 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        return dfs(0, nums, res);
    }

    private static List<List<Integer>> dfs(int level, int[] nums, List<List<Integer>> res) {
        if (level == nums.length) {
            return res;
        }
        int k = res.size();
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>(res.get(i));
            list.add(nums[level]);
            res.add(list);
        }
        return dfs(level + 1, nums, res);
    }
}
