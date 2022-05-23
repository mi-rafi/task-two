package org.polytech.task;

import org.polytech.task.observable.ConcreteObservable;
import org.polytech.task.observer.Subscriber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Countdown<String> stringCountdown = new Countdown<>();

        ConcreteObservable<String> concreteObservable = new ConcreteObservable<>();

        concreteObservable.addObserver(new Subscriber("cat", "ytwer45"));

        concreteObservable.setMessage("Hi");

        stringCountdown.notifySubscribersWithDelay(concreteObservable, "Three", 3000);

        System.out.println("Enter you delay in the interval 1..30 sec");
        Scanner scanner = new Scanner(System.in);
        int userDelay = scanner.nextInt();
        userDelay *= 1000;
        stringCountdown.notifySubscribersWithDelay(concreteObservable, "User late", userDelay);
    }
}
