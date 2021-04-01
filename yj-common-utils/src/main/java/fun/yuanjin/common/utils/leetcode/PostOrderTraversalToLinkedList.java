package fun.yuanjin.common.utils.leetcode;

/**
 * @ClassName PostOrderTraversalToLinkedList
 * @Description 二叉树后续遍历转链表
 * @Author yuanjin
 * @Date 2021-01-09 21:49
 * @Version 1.0
 */
public class PostOrderTraversalToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ListNode head = postOrderTraversal2(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public static ListNode postOrderTraversal(TreeNode root) {
        ListNode head = new ListNode(-1);
        postOrderHelper(root, head);

        return head.next;
    }


    public static ListNode postOrderHelper(TreeNode root, ListNode node) {
        //递归终止条件
        if (root == null) {
            return node;
        }

        //处理本层
        //下探到下一层
        node = postOrderHelper(root.left, node);
        node = postOrderHelper(root.right, node);
        node.next = new ListNode(root.val);
        node = node.next;

        return node;
    }


    /**
     * 方法二：迭代法
     *
     * @param root
     * @return
     */
    public static ListNode postOrderTraversal2(TreeNode root) {
        return null;
    }

    static class TreeNodeColor {
        TreeNode node;
        int color;

        public TreeNodeColor(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }


}
