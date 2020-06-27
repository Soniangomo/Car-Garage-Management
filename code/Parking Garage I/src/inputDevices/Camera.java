//written by: James Jacob
//assisted by: Richard Romanowksi
//debugged by: James Jacob and Richard Romanowski

package inputDevices;

public class Camera {
	private String lp;
	
	public Camera(){
		lp = null;
	}
	
	//Update names
	public String getLP(){
		String s = lp;
		//lp = null;	//Erase old plate once read.
		return s;
	}
	public void setLP(String s){
		lp = s;
	}
}
