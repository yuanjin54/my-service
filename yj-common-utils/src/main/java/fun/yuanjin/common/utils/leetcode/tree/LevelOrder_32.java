package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

import java.util.*;

/**
 * @ClassName LevelOrder_32
 * @Description 剑指 Offer 32 - I. 从上到下打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-04-01 10:59
 * @Version 1.0
 */
public class LevelOrder_32 {

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
     * @param root
     * @return 层次遍历，从左到右，最终返回一个数组
     */
    public int[] levelOrder1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return new int[0];
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     * @param root
     * @return 层次遍历，从左到右，每一层是放在一个list，最后输出所有层的list
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode last = root;
        List<Integer> item = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            item.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node == last){
                last = deque.peekLast();
                list.add(item);
                item = new ArrayList<>();
            }
        }
        return list;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 III
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * @param root
     * @return 层次遍历，走"之"字型，每一层是放在一个list，最后输出所有层的list
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode last = root;
        List<Integer> item = new ArrayList<>();
        boolean flag = false;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            item.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node == last){
                last = deque.peekLast();
                if (flag){
                    Collections.reverse(item);
                }
                list.add(item);
                item = new ArrayList<>();
                flag = !flag;
            }
        }
        return list;
    }
}
