package by.javacourse.task2.observer;

public interface Observable {

	void attach(EllipseObserver observer);

	void detach();

	void notifyObserver();

}
