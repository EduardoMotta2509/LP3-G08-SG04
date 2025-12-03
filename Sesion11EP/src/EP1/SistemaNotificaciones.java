package EP1;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(Notificacion notificacion) {
        for (Observer observer : observers) {
            observer.update(notificacion);
        }
    }
}