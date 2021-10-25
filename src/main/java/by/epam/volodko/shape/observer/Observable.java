package by.epam.volodko.shape.observer;

public interface Observable {

    void attach(Observer observer);

    void detach();

    void notifyObservers();

}
