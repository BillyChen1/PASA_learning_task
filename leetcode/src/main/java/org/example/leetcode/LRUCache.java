package org.example.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author cqm
 * @date 2022/3/13
 **/
public class LRUCache {
    private Map<Integer, LRUNode> cache;
    private LinkedHashSet<LRUNode> set;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        set = new LinkedHashSet<>();
    }

    public int get(int key) {
        LRUNode node = cache.get(key);
        if (node != null) {
            update(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        LRUNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            if (size == capacity) {
                LRUNode deadNode = set.iterator().next();
                set.remove(deadNode);
                cache.remove(deadNode.key);
                size--;
            }
            LRUNode newNode = new LRUNode(key, value);
            cache.put(key, newNode);
            set.add(newNode);
            size++;
        }
    }

    public void update(LRUNode node) {
        set.remove(node);
        set.add(node);
    }
}

class LRUNode {
    int key;
    int value;

    LRUNode(){}
    LRUNode (int key, int value) {
        this.key = key;
        this.value = value;
    }
}
