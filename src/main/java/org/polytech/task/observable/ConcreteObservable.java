package org.polytech.task.observable;

import org.polytech.task.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable<T> implements Observable<T> {


    private List<Observer<T>> subscribers;
    private T message;

    public ConcreteObservable() {
        subscribers = new ArrayList<>();
    }

    public void setMessage(T news) {
        this.message = news;
        notifyObservers();
    }

    public T getLatestMessage() {
        return this.message;
    }

    @Override
    public void addObserver(Observer<T> o) {
        subscribers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<T> o : subscribers)
            o.update(message);
    }
}


