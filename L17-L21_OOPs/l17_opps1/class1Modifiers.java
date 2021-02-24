import java.util.Arrays;
import java.util.Scanner;

// access modifier 
//default modifier only acceessible in one package. 
//private modifier only acceessible in one class.
//public madifier  available to every where.
// acceessible means read and write both simultaneously
import test.Bicycle;
class Student{
	String sex="female";
	int age = 24;
	private String agesex = age+sex;
}
public class class1Modifiers{
	public static void main(String[] args){
		Student rahul = new Student();
		rahul.sex = "male";
		System.out.println(rahul.sex+" "+rahul.age);
		// accessing private modifier
		// System.out.println(rahul.agesex); //error: agesex has private access in Student
		// accessing default modifier
		Bicycle a = new Bicycle(1,2,3); 
		// System.out.print(a.car);//error: car is not public in Bicycle; cannot be accessed from outside package
		// accessing public modifier
		System.out.println(a.gear);
	}

}