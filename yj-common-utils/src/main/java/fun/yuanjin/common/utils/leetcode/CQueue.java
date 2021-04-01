package fun.yuanjin.common.utils.leetcode;

import java.util.Stack;

/**
 * @ClassName Cq
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-03 22:58
 * @Version 1.0
 */
public class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (s1.size()>0){
            s2.add(s1.pop());
        }
        s1.push(value);
        while (s2.size()>0){
            s1.add(s2.pop());
        }
    }

    public int deleteHead() {
        if (s1.size()>0){
            return s1.pop();
        }
        return -1;
    }
}
