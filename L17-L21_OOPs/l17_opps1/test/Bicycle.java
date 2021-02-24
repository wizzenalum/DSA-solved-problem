package test;
public class Bicycle{
	// three fields to store state.
	public int candence;
	public int gear;
	public int speed;

	int car =10; // to testing the deffault modifier accesibility.

	// constroctor 
	public Bicycle(int startCandence, int startSpeed, int startGear){
		gear 		= startGear;
		candence 	= startCandence;
		speed 		= startSpeed;
	}

	// methods
	public void setCandence(int newValue){
		candence = newValue;
	}
	public void setGear(int var){
		gear = var;
	}
	public void applyBrake(int var){
		speed -= var;
	}
	public void speedUp(int var){
		speed+=var;
	}	
	public int[] getStatus(){
		int[] arr= {candence, gear, speed};
		return arr;
	}
}

