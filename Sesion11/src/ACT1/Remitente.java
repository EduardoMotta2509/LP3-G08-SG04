package ACT1;

import java.util.ArrayList;
import java.util.List;

public class Remitente {
    private List<Observer> observers = new ArrayList<>();
    private List<Observer> blocked = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void blockObserver(Observer observer) {
        if (!blocked.contains(observer)) {
            blocked.add(observer);
        }
    }
    public void unblockObserver(Observer observer) {
        blocked.remove(observer);
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            if (!blocked.contains(observer)) {
                observer.update(message);
            }
        }
    }
}