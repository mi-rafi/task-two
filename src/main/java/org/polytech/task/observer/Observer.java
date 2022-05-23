package org.polytech.task.observer;

public interface Observer<T> {

    void update(T message);
}
