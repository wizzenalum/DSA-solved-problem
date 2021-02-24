import java.util.Arrays;
import java.util.Scanner;

class Bottle{
	// state schema of object
	// final always make things unchangable and it have two ways to intialization
	final String companyName = "abac.company";  // initialize with declation.
	final int volume; // initialize with constructor.
	private String shape;
	private int idNumber;
// need of final keyword because private modifier varalbles can be changed inside the class but final keyword variable enver change
	// so it is also called 
	
	// constructor
	public Bottle(int volume,String shape, int idNumber){
		this.volume = volume;
		this.shape = shape;
		this.idNumber = idNumber;
	}

	public void detail(){
		System.out.println("volume in litre is "+volume+" shape is "+shape+" idNumber is "+idNumber+" company name"+companyName);
	}



}

public class class5Final{
	public static void main(String[] args){
		Bottle a= new Bottle(1, "cubic",200);
		Bottle b= new Bottle(5, "cubic",206);
		Bottle c= new Bottle(1, "cylinder",1200);
		Bottle d= new Bottle(1, "cuboid",987);
		a.detail();
		b.detail();
		c.detail();
		d.detail();
		
		
	}

}