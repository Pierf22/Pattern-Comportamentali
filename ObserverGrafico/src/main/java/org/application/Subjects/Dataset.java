package org.application.Subjects;

import org.application.Observes.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dataset implements Subject {
    List<Observer> observers=new ArrayList<>();
    HashMap<String, Double> data=new HashMap<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers){
            o.update();
        }

    }

    public HashMap<String, Double> getData() {
        return data;
    }

    public void addData(String var, double i) {
        data.put(var,i);
        notifyObservers();

    }
}
