package org.application.Subjects;

import org.application.Observes.Observer;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
