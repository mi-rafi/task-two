package org.polytech.task;

import org.polytech.task.observable.ConcreteObservable;

import java.util.concurrent.atomic.AtomicBoolean;

public class Countdown<T> {

    private final AtomicBoolean isMessageSent = new AtomicBoolean(true);

    public void notifySubscribersWithDelay(ConcreteObservable<T> concreteObservable, T message, int delay) throws InterruptedException {
        Thread.sleep(delay);
        concreteObservable.setMessage(message);
    }

}
