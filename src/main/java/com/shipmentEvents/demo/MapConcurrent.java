package com.company;

import java.util.ArrayList;
import java.util.List;

public class MapConcurrent {
    List<IHat> hats = new ArrayList<>();

    public void manageHats() {
        hats.add(new Ushanka()); // that one has ear flaps
        hats.add(new Fedora());
        hats.add(new Sombrero());
        for (IHat hat : hats) {
            if (hat.hasEarFlaps()) {
                hats.remove(hat);
            }
        }
    }
}

interface IHat{
    boolean hasEarFlaps();
}

class Ushanka implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return true;
    }
}

class Fedora implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return false;
    }
}

class Sombrero implements IHat {
    @Override
    public boolean hasEarFlaps() {
        return false;
    }
}

