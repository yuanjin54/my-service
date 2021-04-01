package fun.yuanjin.common.utils.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName NextGreaterElements_503
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-07 09:12
 * @Version 1.0
 */
public class NextGreaterElements_503 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        NextGreaterElements_503 o = new NextGreaterElements_503();
        System.out.println(Arrays.toString(o.nextGreaterElements(arr)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 0 && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.add(i);
        }
        System.out.println(stack);
        while (stack.size() > 0) {
            Integer pop = stack.pop();
            res[pop] = -1;
            for (int num : nums) {
                if (num > nums[pop]) {
                    res[pop] = num;
                    break;
                }
            }
        }
        return res;
    }
}
