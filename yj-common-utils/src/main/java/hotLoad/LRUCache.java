package hotLoad;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author yuanjin
 * @Date 2021-03-09 15:55
 * @Version 1.0
 */
public class LRUCache<k, v> {

    //lru容量
    private int capacity;
    //缓存节点
    private Map<k, Node<k, v>> nodeMap;
    //头节点
    private Node<k, v> head;
    //尾节点
    private Node<k, v> tail;
    //已经缓存的节点数
    private volatile int count;


    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity设置有误！");
        }
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.pre = head;
    }


    /**
     * 添加节点
     *
     * @param key
     * @param value
     */
    public void put(k key, v value) {
        if (count >= capacity) {
            //删除尾节点
            removeLast();
        }
        //创建新节点，添加到头部
        Node<k, v> node = new Node<>(key, value);
        addToHead(node);
        nodeMap.put(key, node);
        count++;
    }


    /**
     * 获取节点
     *
     * @param key
     * @return
     */
    public Node<k, v> get(k key) {
        Node<k, v> node = nodeMap.get(key);
        if (node != null) {
            moveNodeToHead(node);
        } else {
            node = new Node<>(null, null);
        }
        return node;
    }

    private void moveNodeToHead(Node<k, v> node) {
        removeFromList(node);
        addToHead(node);
    }

    private void addToHead(Node<k, v> node) {
        Node next = head.next;
        node.next = next;
        next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeLast() {
        Node node = tail.pre;
        removeFromList(node);
        nodeMap.remove(node.key);
        count--;
    }

    //null 4<->1<->2<->3
    private void removeFromList(Node<k, v> node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }


    static class Node<k, v> {
        private k key;
        private v value;
        private Node pre;
        private Node next;


        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        LRUCache.Node<Integer, Integer> node = lRUCache.get(1);// 返回 1
        System.out.println(node.toString());
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        node = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(node.toString());
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        node = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(node.toString());
        node = lRUCache.get(3);    // 返回 3
        System.out.println(node.toString());
        node = lRUCache.get(4);    // 返回 4
        System.out.println(node.toString());
    }
}