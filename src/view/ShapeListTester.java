package view;

import java.util.ArrayList;
import java.util.Iterator;

import view.gui.PaintCanvas;

public class ShapeListTester implements Iterable<JShape>, IShapeListSubject {
	
	private ArrayList<IShapeListObserver> observers;
	private final ArrayList<JShape> myList;
	//private final ArrayList<Object> groupList;
	PaintCanvas paintCanvas;
	
	
	
	public ShapeListTester() {
		myList = new ArrayList<JShape>();
		observers = new ArrayList<IShapeListObserver>();
		//groupList = new ArrayList<Object>();
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

	public void removeShape(ITestGroupShape shape) {
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
			//observer.update(this);
		}
	}
	
	public void clearList() {
		myList.clear();
	}
	
	
		

}
