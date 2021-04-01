package fun.yuanjin.common.utils.leetcode;

import java.util.Stack;

/**
 * @ClassName EvalRPN_150
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-20 22:28
 * @Version 1.0
 */
public class EvalRPN_150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("-".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a - b);
            } else if ("+".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a + b);
            } else if ("*".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a * b);
            } else if ("/".equals(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a / b);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


}
