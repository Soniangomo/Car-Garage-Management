package mechanics;

//Gate at exit of parking lot, made it's own class
public class Gate extends Door {
	private boolean paid;
	
	public Gate(){
		status = "Closed";
		paid = false;
	}
	
	public void setPaid(){
		paid = true;
	}
	public boolean hasPaid(){
		return paid;
	}
	
	public void openGate(){
		if (hasPaid()){
			//Open door
			status = "Open";
		}
		else{
			//Keep door closed
		}

	}
	public void closeGate(){
		status = "Closed";
		paid = false;
	}
}
