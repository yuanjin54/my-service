package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeToDoublyList_36
 * @Description 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @Author yuanjin
 * @Date 2021-03-22 19:26
 * @Version 1.0
 */
public class TreeToDoublyList_36 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(0);
        list.add(0,2);
        System.out.println(list);


    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = treeToDoublyList(root.left);
        TreeNode right = treeToDoublyList(root.right);
        left.left = root;
        root.left = right;
        right.right = root;
        root.right = left;
        return right;
    }
}
