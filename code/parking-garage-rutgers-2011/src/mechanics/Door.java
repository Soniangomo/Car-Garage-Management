//written by: James Jacob
//assisted by: Richard Romanowksi
//debugged by: James Jacob and Richard Romanowski

package mechanics;

public class Door {
	protected String status;
	
	Door(){
		status = "Closed"; //Start with all doors closed
	}
	
	public void closeDoor(){
		status = "Closed";
	}
	public void openDoor(){
		status = "Open";
	}
	public boolean isOpen(){
		if( status.equals("Open") )
			return true;
		else
			return false;
	}
	public boolean isClosed(){
		if( status.equals("Closed") )
			return true;
		else
			return false;
	}
}
