package view;

public class CopiedShape   {
	
	SelectedShapeList selectedShapeList;
	CopiedShapeList copiedShapeList;
	
	
		public CopiedShape(SelectedShapeList selectedShapeList, CopiedShapeList copiedShapeList) {
			this.selectedShapeList = selectedShapeList;
			this.copiedShapeList = copiedShapeList;
		}
	
	
	
	public void run() {
		for (IShape shape: selectedShapeList) {
			copiedShapeList.addShape(shape);
		}
}
}

