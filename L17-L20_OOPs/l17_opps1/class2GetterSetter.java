import java.util.Arrays;
import java.util.Scanner;
class Student{
	private int rollNumber = 0;
	private String schoolName = "vpst";
	// as we know we cant access these so we use getter and setter.
	void setRollNumber(int i) {  // default method
		if(i<0) i = 0;
		rollNumber = i;
				
	}
	public int getRollNumber() {  // public method 
		return rollNumber;
	}
}
public class class2GetterSetter{
	public static void main(String[] args){
		Student s = new Student();
		// System.out.print(s.rollNumber); // cant access
		s.setRollNumber(-5);
		System.out.print(s.getRollNumber());
// note these are used so that propertise cant be modiafied directly.
		// it can use validation as here all below 0 are become 0.
	}

}