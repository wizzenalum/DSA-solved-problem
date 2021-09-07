import java.util.Scanner;
public class Input{
	public static void main(String[] args) {
		// this is how input taking place in java
		Scanner input = new Scanner(System.in); 
		int a = input.nextInt();   // a = the inetered integer
		String b = input.nextLine(); // b = "" 
		// Scanner only used white space delimeter but in this empty line
		// it has next linne delimeter that cause b to be empty.
		// int c = input.nextDouble(); // not compatibel error
		double d = input.nextInt(); // easily store
		double e = input.nextFloat();  //easily store


		System.out.print(a+" "+b+" "+" "+d+" "+e); 
	}
}