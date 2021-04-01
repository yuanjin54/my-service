package fun.yuanjin.common.utils.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName BSTIterator
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-28 22:29
 * @Version 1.0
 */
public class BSTIterator {
    Deque<Integer> deque = new ArrayDeque<>();
    int size;

    public BSTIterator(TreeNode root) {
        mid(root);
    }

    /**
     * 中序：左根右
     */
    public void mid(TreeNode root) {
        if (null == root) return;
        mid(root.left);
        deque.add(root.val);
        size++;
        mid(root.right);
    }

    public int next() {
        if (hasNext()) {
            size--;
            return deque.pollFirst();
        }
        return -1;
    }

    public boolean hasNext() {
        return size > 0;
    }
}
