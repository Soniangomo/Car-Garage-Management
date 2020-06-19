package inputDevices;

public class Sensor {
	private boolean status;	//True is empty, false is filled.
	private int sid;
	private long start = 0;
	private float timeElapsed = 0;
	
	//Create a new sensor with an ID number
	//I added this too.
	public Sensor(int i){
		sid = i;
		status = true; //All spots start empty
	}
	
	//I changed these from the class diagram. Needs to be updated
	public void carParks(){
		start = System.currentTimeMillis();
		status = false;
	}
	public void carLeaves(){
		timeElapsed = (System.currentTimeMillis() - start)/(1F);
		status = true;
	}
	public int getID(){
		return sid;
	}
	public float getElapsedTime(){
		float temp = timeElapsed;
		start = 0;
		timeElapsed = 0;
		return temp;
	}
	public boolean isEmpty(){
		return status;
	}	
}
