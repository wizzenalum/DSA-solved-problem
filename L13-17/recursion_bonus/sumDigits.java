/*############################################################################
		Write a recursive function that returns the sum of the digits of a given integer.
		Input format :
			Integer N   example 123885
		Output format :
			Sum of digits of example 27
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class sumDigits{
	public static int sumOfDigits(int input){
		if(input/10<=0) return input;
		return input%10+sumOfDigits(input/10);	
	}
	public static void main(String[] args){
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 2045;	
		System.out.println(sumOfDigits(n));
	}

}