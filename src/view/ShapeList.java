package view;

import java.util.ArrayList;
import java.util.Iterator;

import view.gui.PaintCanvas;

public class ShapeList  implements Iterable<JShape>, IShapeListSubject   {
	
	
	private ArrayList<IShapeListObserver> observers;
	private final ArrayList<JShape> myList;
	PaintCanvas paintCanvas;
	
	
	
	public ShapeList() {
		myList = new ArrayList<JShape>();
		observers = new ArrayList<IShapeListObserver>();
		}
	
	public void addShape(JShape shape) {
		myList.add(shape);
		notifyObservers();
		//System.out.println("Notify for add ran");
		///paintCanvas.repaint();
		}
	
	public boolean isEmpty() {
		return myList.isEmpty();
	}

	public int size() {
		return myList.size();
		
	}

	public void removeShape(JShape shape) {
		myList.remove(shape);
		notifyObservers();
		//System.out.println("Notfiy for remove ran");
		//paintCanvas.repaint();
		}


	@Override
	public Iterator<JShape> iterator() {
		return myList.iterator();
	}
	

	
	public void addAll(ArrayList<JShape> temp) {
		this.myList.addAll(temp);
	}

	@Override
	public void registerObserver(IShapeListObserver observer) {
		observers.add(observer);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		for(IShapeListObserver observer: observers) {
			observer.update(this);
		}
	}
	
	public void clearList() {
		myList.clear();
	}
		
		
	
}
