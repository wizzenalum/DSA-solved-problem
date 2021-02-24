import java.util.Scanner;

public class Lecture4{
	public static void main(String[] args) {
		int a, b;
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();

		// here we will test numberis even or not
		// if (a%2==0){
		// 	System.out.printf("%s is even",a);
		// }else{
		// 	System.out.print("number is odd");
		// }

	// test both enterd nubers are positive or not
		b = scan.nextInt();
		if(a>0 && b>0){
			System.out.println("both are positive");
		}else if(a>0 || b>0){
			System.out.println("one is positive");
		}else {
			println("both are negative");
		}

	}
}