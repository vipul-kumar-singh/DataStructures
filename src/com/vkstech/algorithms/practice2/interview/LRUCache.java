package com.vkstech.algorithms.practice2.interview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

    static class Cache<K, V> {
        K key;
        V value;

        public Cache(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Deque<K> deque = new LinkedList<>();
    private final Map<K, Cache<K, V>> map = new HashMap<>();

    final int CACHE_CAPACITY = 4;

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            deque.remove(key);
        } else {
            if (deque.size() == CACHE_CAPACITY) {
                K temp = deque.removeLast();
                map.remove(temp);
            }
        }

        Cache<K, V> cache = new Cache<>(key, value);
        deque.addFirst(key);
        map.put(key, cache);
    }

    public V get(K key) {
        if (!map.containsKey(key))
            return null;

        Cache<K, V> cache = map.get(key);
        deque.remove(key);
        deque.addFirst(key);
        return cache.value;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>();
        cache.put("Vipul", 27);
        cache.put("Max", 28);
        cache.put("Tom", 29);
        cache.put("Harry", 30);

        cache.put("Asta", 29);
        cache.put("Max", 28);

        System.out.println(cache.get("Tom"));
        System.out.println(cache.get("Harry"));
    }
}
