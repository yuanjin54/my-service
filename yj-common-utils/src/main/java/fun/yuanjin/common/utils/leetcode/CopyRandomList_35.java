package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CopyRandomList_35
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-01-08 10:10
 * @Version 1.0
 */
public class CopyRandomList_35 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Node cp = head;
        Map<Node, Node> map = new HashMap<>();
        while (cp != null) {
            map.put(cp, new Node(cp.val));
            cp = cp.next;
        }
        cp = head;
        while (cp != null) {
            map.get(cp).next = map.get(cp.next);
            map.get(cp).random = map.get(cp.random);
            cp = cp.next;
        }
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
