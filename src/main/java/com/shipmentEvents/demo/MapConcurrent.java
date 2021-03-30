package com.company;

import java.util.HashMap;

public class MapConcurrent {
    HashMap<String, Hat> hats = new HashMap<String, Hat>();

    public void addNewHat(Hat hat) {
        hats.put(hat.getName(), hat);
    }
}

abstract class Hat{
    String name;
    String maker;
    String material;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}


