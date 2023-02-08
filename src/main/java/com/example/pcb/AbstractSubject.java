package com.example.pcb;

import java.util.List;

public abstract class AbstractSubject {

    protected List<AbstractObserver> observers;
    abstract void addObserver(AbstractObserver observer);

    abstract void notifyObservers(int budget);

}
