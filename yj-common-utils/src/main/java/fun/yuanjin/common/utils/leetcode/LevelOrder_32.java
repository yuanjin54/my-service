package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName LevelOrder_32
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @Author yuanjin
 * @Date 2021-01-13 22:47
 * @Version 1.0
 */
public class LevelOrder_32 {
    public static void main(String[] args) {

    }

    /**
     * 非递归实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        List<Integer> item = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeNode last = root;
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            item.add(node.val);
            if (node.left != null){
                deque.addLast(node.left);
            }
            if (node.right != null){
                deque.addLast(node.right);
            }
            if (node == last){
                list.add(item);
                item = new ArrayList<>();
                last = deque.peekLast();
            }
        }
        return list;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> item = new ArrayList<>();
    TreeNode last;
    public List<List<Integer>> levelOrder1(TreeNode root) {
        res = new ArrayList<>();
        if (root == null){
            return res;
        }
        last = root;
        recur(root);
        return res;
    }

    private void recur(TreeNode root){
        if (last == root){
            res.add(item);
            item = new ArrayList<>();
            return;
        }
        item.add(root.val);
        if (root.left != null){
            recur(root.left);
        }
        if (root.right != null){
            recur(root.right);
        }
    }
}
