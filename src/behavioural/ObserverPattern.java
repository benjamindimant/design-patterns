package behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * Steps:
 * 1) Create the Subject class with a list of the Observers.
 * 2) Create the abstract Observer class.
 * 3) Create the concrete Observer classes.
 */
public class ObserverPattern {

  public static void main(String[] args) {
    Subject subject = new Subject();
    new ConcreteObserverOne(subject);
    new ConcreteObserverTwo(subject);

    subject.setState(5);

  }

}

class Subject {

  private final List<Observer> observers;
  private int state;

  Subject() {
    this.state = 0;
    observers = new ArrayList<>();
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
    notifyAllObservers();
  }

  public void notifyAllObservers() {
    observers.forEach(Observer::update);
  }

  public void register(Observer observer) {
    observers.add(observer);
  }

}

abstract class Observer {
  protected Subject subject;
  public abstract void update();
}

class ConcreteObserverOne extends Observer {

  public ConcreteObserverOne(Subject subject) {
    this.subject = subject;
    this.subject.register(this);
  }

  @Override
  public void update() {
    System.out.println("ConcreteObserverOne updated: " + this.subject.getState());
  }
}

class ConcreteObserverTwo extends Observer {

  public ConcreteObserverTwo(Subject subject) {
    this.subject = subject;
    this.subject.register(this);
  }

  @Override
  public void update() {
    System.out.println("ConcreteObserverTwo updated: " + this.subject.getState());
  }
}