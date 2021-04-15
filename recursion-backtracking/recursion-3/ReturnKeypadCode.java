/*############################################################################
						 Return Keypad Code

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
public class ReturnKeypadCode{
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
	public static String[] keypad(int n){
		if(n<=1) return null;
		String[] arr1 = letterOnKey(n%10);
		String[] arr2 = keypad(n/10);
		if(arr1 == null) return arr2;
		if(arr2 == null) return arr1;
		String[] send = new String[arr1.length*arr2.length];
		int i = 0;
		for(String a:arr1){
			for(String b:arr2){
				send[i] = b+a;
				i++;
			}
		}
		return send;
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 23;
		String[] result = keypad(235);
		for(int i =0; i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}