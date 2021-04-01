package fun.yuanjin.common.utils.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName WordDictionary_211
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-14 21:52
 * @Version 1.0
 */
public class WordDictionary_211 {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (null == node.get(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        List<TrieNode> list = new ArrayList<>();
        list.add(root);
        return find(0, word, list);
    }

    public boolean find(int i, String word, List<TrieNode> nodes) {
        if (i == word.length()) {
            for (TrieNode node : nodes) {
                if (null != node && node.isEnd()) {
                    return true;
                }
            }
            return false;
        }
        List<TrieNode> list = new ArrayList<>();
        for (TrieNode node : nodes) {
            if (word.charAt(i) == '.' && node != null) {
                list.addAll(Arrays.asList(node.getNodes()));
                continue;
            }
            if (node == null){
                continue;
            }
            if (node.containsKey(word.charAt(i))) {
                list.add(node.get(word.charAt(i)));
                break;
            }
        }
        return find(i + 1, word, list);
    }
}

class TrieNode {
    TrieNode[] nodes;
    boolean isEnd = false;

    public TrieNode() {
        nodes = new TrieNode[26];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean containsKey(char c) {
        return nodes[c - 'a'] != null;
    }

    public void put(char c) {
        nodes[c - 'a'] = new TrieNode();
    }

    public boolean isEnd() {
        return isEnd;
    }

    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }

    public TrieNode[] getNodes() {
        return nodes;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Test{
    public static void main(String[] args) {
        WordDictionary_211 obj = new WordDictionary_211();
        obj.addWord("a");
        obj.addWord("ab");
        System.out.println(obj.search("."));
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search("b.."));
    }
}