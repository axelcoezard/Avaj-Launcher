package com.acoezard.avaj_launcher;

import java.util.ArrayList;
import java.util.List;

import com.acoezard.avaj_launcher.aircrafts.Flyable;

public class Tower {
    private final List<Flyable> observers = new ArrayList<>();
    
    public void register(Flyable flyable) {
        this.observers.add(flyable);
        System.out.println("Tower says: " + flyable.toString() + " registered to tower.");
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