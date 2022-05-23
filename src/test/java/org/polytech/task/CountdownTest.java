package org.polytech.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.polytech.task.observable.ConcreteObservable;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.core.IsEqual.equalTo;

class CountdownTest {

    ConcreteObservable<String> observable;
    Countdown<String> countdown;


    @BeforeEach
    public void setup() {
        observable = new ConcreteObservable<>();
        countdown = new Countdown<>();
    }

    @Test
    void notifySubscribersWithDelay() throws InterruptedException {
        //when
        Thread t = new Thread(() -> {
            try {
                countdown.notifySubscribersWithDelay(observable, "message", 100);
            } catch (InterruptedException ignored) {
            }
        });
        t.start();

        //then
        await()
                .atLeast(Duration.of(90, ChronoUnit.MILLIS))
                .atMost(Duration.of(110, ChronoUnit.MILLIS))
                .with()
                .pollInterval(Duration.of(10, ChronoUnit.MILLIS))
                .until(observable::getLatestMessage, equalTo("message"));
    }
}