package fun.yuanjin.common.utils.leetcode;

import java.util.Stack;

/**
 * @ClassName Title84
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-12-27 22:52
 * @Version 1.0
 */
public class Title84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int idx = stack.peek();
            while (idx != -1 && heights[idx] > heights[i]) {
                int h = stack.pop();
                idx = stack.peek();
                int area = heights[h] * (i - idx - 1);
                max = Math.max(max, area);
                System.out.println("h=" + heights[h] + " area=" + area);
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int h = stack.pop();
            int area = heights[h] * (heights.length - stack.peek() - 1);
            System.out.println("h=" + heights[h] + " area=" + area);
            max = Math.max(max, area);
        }
        return max;
    }
}
