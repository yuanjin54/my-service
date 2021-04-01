package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName TreeUtils
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-30 17:33
 * @Version 1.0
 */
public class TreeUtils {
    public static void main(String[] args) {
        TreeNode root = createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        printTree(root);
    }

    public static TreeNode createTree(Integer[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (null != arr[i]) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if ((2 * i + 1) < arr.length && nodes[2 * i + 1] != null) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if ((2 * i + 2) < arr.length && nodes[2 * i + 2] != null) {
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        return nodes[0];
    }

    public static void printTree(TreeNode root) {
        TreeNode pointer = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        deque.addLast(root);
        while (deque.size() > 0) {
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node == pointer) {
                pointer = deque.peekLast();
                System.out.println(list);
                list.clear();
            }
        }
    }
}
