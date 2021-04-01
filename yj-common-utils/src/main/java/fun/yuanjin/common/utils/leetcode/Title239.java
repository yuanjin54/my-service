package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName Title239
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-28 22:09
 * @Version 1.0
 */
public class Title239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 超出范围，移除
            if (deque.size() > 0 && i - deque.getFirst() >= k) {
                deque.pollFirst();
            }
            // 移除队列中小于等于当前值的元素
            while (deque.size() > 0 && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // 从k-1开始记录
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}
