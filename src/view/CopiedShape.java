package view;

public class CopiedShape   {
	
	SelectedShapeList selectedShapeList;
	CopiedShapeList copiedShapeList;
	
	
		public CopiedShape(SelectedShapeList selectedShapeList, CopiedShapeList copiedShapeList) {
			this.selectedShapeList = selectedShapeList;
			this.copiedShapeList = copiedShapeList;
		}
	
	
	
	public void run() {
		System.out.println("SelectedShapeList size in CopiedShape " + selectedShapeList.getSize());
		for (IShape shape: selectedShapeList) {
			copiedShapeList.addShape(shape);
		}
}
}

