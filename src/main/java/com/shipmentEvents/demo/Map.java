package com.company;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Map {
    private static ConcurrentMap<String,String> map = new ConcurrentHashMap<>();

    public String getValue(String key) {
        if(map.containsKey(key)) {
            return map.get(key);
        }

        return null;
    }
}
