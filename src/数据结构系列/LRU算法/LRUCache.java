package 数据结构系列.LRU算法;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * HashMap+LinkedList(双链表)
 */
public class LRUCache {

    Map<Integer, Integer> map;
    LinkedList<Integer> lists;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        lists = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
            lists.remove(Integer.valueOf(key));
            lists.addFirst(key);
        } else if (map.size() == capacity) {
            Integer lastKey = lists.getLast();
            lists.removeLast();
            map.remove(lastKey);
            map.put(key, value);
            lists.addFirst(key);
        } else {
            map.put(key, value);
            lists.addFirst(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
