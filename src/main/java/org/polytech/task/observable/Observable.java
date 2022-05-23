package org.polytech.task.observable;

import org.polytech.task.observer.Observer;

public interface Observable<T> {

    void addObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers();
}
