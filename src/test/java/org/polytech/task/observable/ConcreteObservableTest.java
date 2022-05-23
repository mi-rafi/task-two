package org.polytech.task.observable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.polytech.task.observer.Observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConcreteObservableTest {

    private ConcreteObservable<String> observable;

    Observer<String> mockObserver;

    @BeforeEach
    public void setup(){
        observable = new ConcreteObservable<>();
        mockObserver = mock(Observer.class);
    }

    @Test
    void setMessage() {
        //given
        observable.addObserver(mockObserver);
        doNothing().when(mockObserver).update(any(String.class));

        //when
        observable.setMessage("message");

        //then
        verify(mockObserver, times(1)).update("message");
    }

    @Test
    void addObserver() {
        //when
        observable.setMessage("message");

        //then
        verify(mockObserver, times(0)).update(any(String.class));

        //given
        observable.addObserver(mockObserver);
        doNothing().when(mockObserver).update(any(String.class));

        //when
        observable.setMessage("message");

        //then
        verify(mockObserver, times(1)).update("message");
    }

    @Test
    void removeObserver() {
        //given
        observable.addObserver(mockObserver);
        doNothing().when(mockObserver).update(any(String.class));

        //when
        observable.setMessage("message");

        //then
        verify(mockObserver, times(1)).update("message");

        //remove
        observable.removeObserver(mockObserver);

        //when
        observable.setMessage("message");

        //then
        verify(mockObserver, times(1)).update(any(String.class));

    }
}