package com.zero;

public class Car {
    String id;
    long enterTime;
    long leaveTime;

    public Car(String id) {
        this.id = id;
    }
    public void enter(){
        enterTime = System.currentTimeMillis();
    }
    public void left(){
        leaveTime = System.currentTimeMillis();
    }
}
