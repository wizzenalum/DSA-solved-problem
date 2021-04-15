/*############################################################################
						 print Keypad Code

	Given an integer n, using phone keypad find out all the possible strings 
	that can be made using digits of input n.
	Return empty string for numbers 0 and 1.
	Note : 1. The order of strings are not important.
	2. Input and output has already been managed for you. You just have to 
	populate the output array and return the count of elements populated in the output array.
	Input Format :
		Integer n

	Output Format :
		All possible strings in different lines

	Constraints :
		1 <= n <= 10^6

	Sample Input:
		23

	Sample Output:
		ad
		ae
		af
		bd
		be
		bf
		cd
		ce
		cf

				completed true
#############################################################################*/
import java.util.Scanner;
public class PrintKeypadCode{
	public static String[] letterOnKey(int n){
		String[] letter = null;
		if(n==2) letter = "a b c".split(" ");
		else if(n==3) letter = "d e f".split(" ");
		else if(n==4) letter = "g h i".split(" ");
		else if(n==5) letter = "j k l".split(" ");
		else if(n==6) letter = "m n o".split(" ");
		else if(n==7) letter = "p q r s".split(" ");
		else if(n==8) letter = "t u v".split(" ");
		else if(n==9) letter = "w x y z".split(" ");
		return letter;
	}
	// i will only now pass the parameters instead returning that i used in retuunring code combinations. 
	public static void printKeypadHelper(String code, int n){
		if(n<=1) {
			System.out.println(code);
			return;
		}
		String[] letters = letterOnKey(n%10);
		for(String a:letters){
			printKeypadHelper(a+code,n/10);
		}
	}
	public static void printKeypad(int input){
		printKeypadHelper("",input);
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 235;
		printKeypad(n);
	}
}