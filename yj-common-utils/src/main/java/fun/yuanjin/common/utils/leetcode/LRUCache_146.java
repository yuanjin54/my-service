package fun.yuanjin.common.utils.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-02-08 18:05
 * @Version 1.0
 */
public class LRUCache_146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int v = lRUCache.get(1);// 返回 1
        System.out.println(v);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        v = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(v);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        v = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(v);
        v = lRUCache.get(3);    // 返回 3
        System.out.println(v);
        v = lRUCache.get(4);    // 返回 4
        System.out.println(v);
    }
}

class LRUCache {

    int _capacity;
    // 存放key和对应的node
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this._capacity = capacity;
        this.map = new HashMap<>();
        // 新建两个节点 head 和 tail
        this.head = new Node();
        this.tail = new Node();
        // 初始化链表为 head <-> tail
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void insertNodeToTail(Node node){
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveNodeToTail(int key) {
        Node node = this.map.get(key);
        // 相当于先从链表删除node
        removeNode(node);
        // 最后插入node到tail
        insertNodeToTail(node);
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            moveNodeToTail(key);
            return this.map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.value = value;
            moveNodeToTail(key);
            this.map.put(key, node);
        } else {
            Node node = new Node(key, value);
            insertNodeToTail(node);
            this.map.put(key, node);
            if (map.size() > this._capacity) {
                removeNode(this.head.next);
                this.map.remove(this.head.next.key);
            }
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}