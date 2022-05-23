package org.polytech.task.observer;

public class Subscriber implements Observer<String> {

    private String username;
    private String password;

    public Subscriber(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public void update(String news) {
        System.out.println(username + " get message: " + news);
    }


}
