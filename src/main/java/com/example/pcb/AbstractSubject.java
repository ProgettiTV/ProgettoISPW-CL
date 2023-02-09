package com.example.pcb;

import java.util.List;

public abstract class AbstractSubject {

    protected List<AbstractObserver> observers;
    protected abstract void addObserver(AbstractObserver observer);

    public abstract void notifyObservers(int budget);

}
