package test;

// another class that inherite this class.
public class MountainBike extends Bicycle{
	// field
	public int seatHeight;
	// one constroctor
	public MountainBike( 	int startHeight, int startCandence,
                            int startSpeed, int startGear){
		super(startCandence, startSpeed, startGear);
		seatHeight = startHeight;
	}
	//one method

	public void seatHeight(int var){
		seatHeight = var;
	}
}