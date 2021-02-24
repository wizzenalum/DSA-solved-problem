import java.util.Arrays;
class Student{
	private int age;
	private String sex = "male";
// // analyse following that this is showing that when we call a object it wont run complete template class. 
// 	public void setAge(int age){
// 		System.out.println (age);
// 		int cases = age;
// 		System.out.println(cases);
// 		age = cases;
// 		System.out.println(age);
// 	}
	void setAge(int age , int k){
		age = k;
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}
class Test 
    { 
        int a; 
        int b; 

    public void set(int a, int b) 
    {  
        b = a; 
        this.b = b; 
    } 

    void display() 
    { 
        System.out.println("a=" + a + " b=" + b); 
    } 
}
public class class3This{
	public static void main(String[] args){
		Student a = new Student();
		a.setAge(20,5);
		System.out.println(a.getAge());
		Test object = new Test();
        object.set(10,20);
        object.display(); 
	}
}
