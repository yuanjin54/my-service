package fun.yuanjin.common.utils.leetcode.tree;

import fun.yuanjin.common.utils.leetcode.TreeNode;
import org.apache.kafka.common.protocol.types.Field;

import java.util.*;

/**
 * @ClassName Codec
 * @Description 剑指 Offer 37. 序列化二叉树
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @Author yuanjin
 * @Date 2021-04-02 11:10
 * @Version 1.0
 */
public class Codec {
    public static void main(String[] args) {
        Codec obj = new Codec();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        String data = "[1,2,3,null,null,4,5]";
        String[] substring = data.substring(1, data.length() - 1).split(",");
        System.out.println(substring);
//        System.out.println(obj.serialize(root));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                list.add(node.val + "");
            } else {
                list.add(null);
            }
        }
        while (list.size()>0 && list.get(list.size()-1)==null){
            list.remove(list.size()-1);
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().length() == 0){
            return null;
        }
        String[] arr = data.substring(1, data.length() - 1).split(",");
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!"null".equals(arr[i])) {
                nodes[i] = new TreeNode(Integer.parseInt(arr[i].trim()));
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

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
