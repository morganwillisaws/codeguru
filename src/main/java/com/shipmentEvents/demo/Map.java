package com.company;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Map {
    private static ConcurrentMap<String,String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

    }
    public static String checkExists(String key) {
        if(map.containsKey(key)) {
            return map.get(key);
        }

        return null;
    }

    public static void removeItem(String key) {
        map.remove(key);
    }
}
