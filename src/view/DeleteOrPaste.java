package view;

public class DeleteOrPaste {
	
	DeleteOrPaste deleteOrPaste;
	private int delete;
	private int paste;
	public DeleteOrPaste() {
		delete = 0;
		paste = 0;
	}
	public void setDelete() {
		delete = 1;
		paste = 0;
	}
	public void setPaste() {
		delete = 0;
		paste = 1;
	}
	public int checkDelete(){
		return delete;
	}
	public int checkPaste() {
		return paste;
	}

}
