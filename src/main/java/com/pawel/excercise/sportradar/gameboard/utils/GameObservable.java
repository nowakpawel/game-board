package com.pawel.excercise.sportradar.gameboard.utils;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameObservable {

    public List<GameObserver> observers = new ArrayList<>();

    public void addNewGameObserver(GameObserver newObserver) {
        observers.add(newObserver);
    }

    public void removeGameObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(o -> o.update());
    }



}
