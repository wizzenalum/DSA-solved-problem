import java.util.Arrays;
import java.util.Scanner;
class Student{

	// state or varible of class.
	private String name;
	private int rollNumber;
	// // default contructor 
	// Student(){  // constructor does not need return type void or any thing
	// }
	// // setters 
	// public void setName(String name){
	// 	this.name = name;
	// }
	// public void setRollNumber(int i){
	// 	this.rollNumber = i;
	// }

	// // getters 
	// public String getName(){
	// 	return name;
	// }
	// public int getRollNumber(){
	// 	return rollNumber;
	// }

// folloing is a contructor to set the initial value for objects.
	Student(String name, int roll){
		this.name = name;
		this.rollNumber = roll;
	}
// if we don't want contructor to need always roll number then write two contructors
	Student(String name){
		this.name = name;
	} 
	// fuctionality of class.
	public void detail(){
		System.out.println(name+" "+rollNumber);
	}



}



public class class4Constructor{
	public static void main(String[] args){
		// here in this line we are calling a special function Studnt with new key word
		// it is called contructor and it only called once for one object.
	// // type 1 default constructor
		// Student a = new Student();
		// a.setName("rahul");
		// a.setRollNumber(10001);
	//type 2 conturcotr to carete object only once.
		Student a = new Student("rahul", 45);
		Student b = new Student("ram");
		b.detail();
		a.detail();


	}

}