package view;

public interface IShapeListSubject {

	void registerObserver(IShapeListObserver observer);
	void notifyObservers();
}
