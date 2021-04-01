package fun.yuanjin.common.utils.leetcode;

import java.util.Stack;

/**
 * @ClassName w1047
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-09 19:19
 * @Version 1.0
 */
public class RemoveDuplicates_1047 {

    public static void main(String[] args) {
        RemoveDuplicates_1047 m = new RemoveDuplicates_1047();
        System.out.println(m.removeDuplicates1("abbaca"));
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.size() == 0 || !stack.peek().equals(S.charAt(i))) {
                stack.add(S.charAt(i));
                continue;
            }
            while (stack.size() > 0 && stack.peek().equals(S.charAt(i))) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public String removeDuplicates1(String S) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        boolean f = false;
        while (i < S.length()) {
            if (res.length() == 0) {
                res.append(S.charAt(i));
                i++;
                continue;
            }
            if (res.charAt(res.length() - 1) == S.charAt(i)) {
                f = true;
            }
            if (res.charAt(res.length() - 1) != S.charAt(i)) {
                if (f) {
                    res.delete(res.length() - 1, res.length());
                    continue;
                }
                res.append(S.charAt(i));
                f = false;
            }
            i++;
        }
        return res.toString();
    }
}
