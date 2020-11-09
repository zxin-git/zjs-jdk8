package com.zxin.java.design.action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxin
 */
public abstract class Subject {

    List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void update(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
