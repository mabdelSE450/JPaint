package view;

public class CopiedShape   {
	
	SelectedShapeList selectedShapeList;
	//SelectedShapeList selectedShapeList = new SelectedShapeList();
	CopiedShapeList copiedShapeList;
	
	
		public CopiedShape(SelectedShapeList selectedShapeList, CopiedShapeList copiedShapeList) {
			this.selectedShapeList = selectedShapeList;
			this.copiedShapeList = copiedShapeList;
		}
	
	
	
	public void run() {
		
		//System.out.println("THis is the run method for the copiedShape class");
		//System.out.println("This is the selectedShapeList: " + selectedShapeList.getSize());
		for (JShape shape: selectedShapeList) {
			copiedShapeList.addShape(shape);
		}
		System.out.println("This is the copiedShapeList size in the run method of\n "
				+ "my CopiedShape class: " + copiedShapeList.getSize());
		//System.out.println(copiedShapeList.hashCode());
	}



}

