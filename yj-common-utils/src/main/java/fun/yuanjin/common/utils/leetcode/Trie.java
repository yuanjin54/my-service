package fun.yuanjin.common.utils.leetcode;


/**
 * @ClassName Trie
 * @Description https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 前缀搜索树
 * @Author yuanjin
 * @Date 2021-03-15 10:41
 * @Version 1.0
 */
public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // 这里注意node可能为null
            if (node == null || !node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node == null || !node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] nodes;
    boolean isEnd = false;

    public TrieNode() {
        this.nodes = new TrieNode[26];
    }

    public boolean containsKey(char c) {
        return nodes[c - 'a'] != null;
    }

    public void put(char c) {
        nodes[c - 'a'] = new TrieNode();
    }

    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }
}
