package com.sheliming.ali;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap();

    public long nextId(String name) {
        if (map.containsKey(name)) {
            return map.get(name).getAndIncrement();
        } else {
            map.put(name, new AtomicLong(1));
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IdGenerator().nextId("A"));
        System.out.println(new IdGenerator().nextId("A"));
        System.out.println(new IdGenerator().nextId("B"));
        System.out.println(new IdGenerator().nextId("A"));
    }
}
