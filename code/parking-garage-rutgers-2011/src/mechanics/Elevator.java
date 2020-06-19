//written by: James Jacob
//assisted by: Richard Romanowksi
//debugged by: James Jacob and Richard Romanowski

package mechanics;

public class Elevator{
	private int floor;
	public boolean occupied;
	public Door entryDoor = new Door();
	public Door exitDoor = new Door();
	
	public Elevator(){
		floor = 1; //When elevator is created it starts at ground level.
		occupied = false;
		entryDoor.status = "Open";
		exitDoor.status = "Closed";
	}

	public void setOccupancy( boolean state ) {
		occupied = state;
	}
	
	//Added these
	public boolean atBottom(){
		if( floor == 1){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean atFloor(int i){
		if ( floor == i){
			return true;
		}
		else{
			return false;
		}
	}
	public class Reservation {
		public void makeRes(){
			
		}
		public void delRes(){
			
		}
		public void editRes(){
			
		}
	}	
	public int getFloor(){
		return floor;
	}
	//Changed name of this
	public void goToFloor(int i){
		floor = i;
	}
	public boolean isOccupied(){
		return occupied;
	}
	public boolean isReady(){
		if( atBottom() && (!isOccupied()) && (entryDoor.isOpen()) && (exitDoor.isClosed()) ){
			return true;
		}
		else{
			return false;
		}
	}
}
