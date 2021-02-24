import java.util.Arrays;
import java.util.Scanner;
  // tell the java that it is the a package to use.
import test.Bicycle;
import test.MountainBike;
class Student{
    int roll_number;
    String name;
}
public class objectFromPackage{
	public static void main(String[] args){
		Bicycle a = new Bicycle(5,4,3);
		MountainBike b = new MountainBike(1,2,3,4);
		System.out.print(Arrays.toString(a.getStatus()));
		System.out.print(Arrays.toString(b.getStatus()));
		Student s=new Student();
        s.roll_number=5;
        s.name="Rohit";
        System.out.println(s.roll_number+" "+s.name);
        System.out.println(a);// will print packagename.classname.@hexadecimalcode
	}

}