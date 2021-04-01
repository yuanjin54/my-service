package fun.yuanjin.common.utils.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName CircularLinkedList
 * @Description 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * @Author yuanjin
 * @Date 2020-11-14 23:33
 * @Version 1.0
 */
public class CircularLinkedList142 {

    public static void main(String[] args) {
        List<String> urlList = new ArrayList<>();

        urlList.add("sss");
        urlList.add("sds");
        urlList.add("sds");

        System.out.println(urlList);
        Map<String, String> urlMap = urlList.stream().collect(Collectors.toMap(key -> key, key -> key));
        System.out.println(urlMap);



        /*int[] arr = {};
        ListNode head = ListNodeUtil.createNode(arr);
        ListNode result = detectCycle(head);
        System.out.println(ListNodeUtil.nodeToList(result));*/
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.size() == 0 || !stack.pop().equals(map.get(s.charAt(i)))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    // "abcdddeeeeaaaabbbcd"
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(i)) {
                System.out.println(i + "=" + j);
                if (j - i > 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
                i = j + 1;
            }
        }
        if (s.length() - i > 2) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(s.length() - 1);
            res.add(list);
        }
        return res;
    }

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                res[i] = stack.size();
                stack.push(seq.charAt(i));
            } else {
                stack.pop();
                res[i] = stack.size();
            }
        }
        return res;
    }

    /**
     * 方法一：
     * 通过遍历
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 方法二：
     * 通过遍历
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        while (null != head) {
            if (null != map.get(head)) {
                return head;
            }
            map.put(head, head);
            head = head.next;
        }
        return null;
    }

    /**
     * 方法三：
     * 快慢指针：慢指针走一步，快指针走两步
     * 这其实只能证明该链表是否有环，不能解决当前的问题
     * 思考：
     * 但是快慢指针之间在步子上是存在一定的关系
     * 当快慢指针相遇的时候：
     * 1、快指针的步数=慢指针的步数+整数倍环的长度
     * 2、快指针的步数=2倍慢指针的步数
     * 根据1和2计算出环的长度=慢指针的步数
     * <p>
     * 上面知道环的长度后，让指针1和指针2都从头开始，
     * 当指针1走了环的长度后指针2和指针1才开始同步走（步长为1），
     * 直到走到两个指针重合为止。
     *
     * @param head head
     * @return node
     */
    public static ListNode detectCycle3(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode root = head;
        ListNode q = head.next.next;
        while (null != q) {
            // 快慢指针第一次重合
            if (head == q) {
                while (head != root) {
                    head = head.next;
                    root = root.next;
                }
                return root;
            }
            if (null == q.next) {
                return null;
            }
            q = q.next.next;
            head = head.next;
        }
        return null;
    }
}
