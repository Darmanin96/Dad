package dad.bindings.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();
    private T value;

    public void subscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    public void setValue(T value) {
        this.value = value;
        notifyAllObservers(); // Notificamos a todos los observadores cuando el valor cambia
    }

    private void notifyAllObservers() {
        this.observers.forEach(observer -> observer.update(value));
    }
}

