package fun.yuanjin.common.utils.interview;

/**
 * @ClassName Trie
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-12 10:16
 * @Version 1.0
 */
public class Trie_208 {

    private final TireNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.trim().length() == 0) {
            return;
        }
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node.putNode(word.charAt(i));
            }
            node = node.getNode(word.charAt(i));
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getNode(word.charAt(i));
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.getNode(prefix.charAt(i));
        }
        return true;
    }
}

class TireNode {
    private final TireNode[] nodes;
    private boolean isEnd = false;

    public TireNode[] getNodes() {
        return nodes;
    }

    public TireNode() {
        this.nodes = new TireNode[26];
    }

    public TireNode getNode(char c) {
        return nodes[c - 'a'];
    }

    public void putNode(char c) {
        nodes[c - 'a'] = new TireNode();
    }

    public boolean containsKey(char c) {
        return nodes[c - 'a'] == null;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}