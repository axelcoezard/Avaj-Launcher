package com.acoezard.avaj_launcher;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers = new ArrayList<>();
    
    public void register(Flyable flyable) {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}