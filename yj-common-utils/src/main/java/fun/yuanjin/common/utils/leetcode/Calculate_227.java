package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Calculate_227
 * @Description 227. 基本计算器 II
 * @Author yuanjin
 * @Date 2021-03-11 08:41
 * @Version 1.0
 */
public class Calculate_227 {
    public static void main(String[] args) {
        Calculate_227 obj = new Calculate_227();
        System.out.println(obj.calculate(" 3+5 / 2 "));
    }

    public int calculate(String s) {
        int res = 0;
        List<String> list = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                continue;
            }
            if (s.charAt(j) == '*' || s.charAt(j) == '/' || s.charAt(j) == '-' || s.charAt(j) == '+') {
                list.add(s.substring(i, j).trim());
                list.add(s.charAt(j) + "");
                i = j + 1;
            }
        }
        list.add(s.substring(i).trim());
        Stack<String> stack = new Stack<>();
        for (String value : list) {
            if ("+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value)) {
                stack.add(value);
                continue;
            }
            if (stack.size() == 0) {
                stack.add(value);
            } else {
                int parseInt = Integer.parseInt(value);
                if ("*".equals(stack.peek())) {
                    stack.pop();
                    int dd = Integer.parseInt(stack.pop()) * parseInt;
                    stack.add(dd + "");
                } else if ("/".equals(stack.peek())) {
                    stack.pop();
                    int dd = Integer.parseInt(stack.pop()) / parseInt;
                    stack.add(dd + "");
                } else if ("-".equals(stack.peek())) {
                    stack.add(stack.pop() + parseInt);
                } else {
                    stack.add(value);
                }
            }
        }
        while (stack.size() > 0) {
            if ("+".equals(stack.peek())) {
                stack.pop();
                continue;
            }
            res += Integer.parseInt(stack.pop());
        }
        return res;
    }
}
