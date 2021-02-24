/*############################################################################
		Write a recursive function to convert a given string into the number 
		it represents. That is input will be a numeric string that contains 
		only numbers, you need to convert the string into corresponding integer 
		and return the answer.
		Input format :
			Numeric string S (string, Eg. "1234")
		Output format :
			Corresponding integer N (int, Eg. 1234)
		Sample Input 1 :
			00001231
		Sample Output 1 :
			1231

#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class stringToInteger{
	public static int convertStringToInt(String input){
		int len = input.length();
		if(len==0) return 0;
		int lastSum = convertStringToInt(input.substring(0,len-1));
		return lastSum*10+input.charAt(len-1)-48;
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// String str =  scan.next();
		String str = "10234";
		int a = str.charAt(0);
		// System.out.print(a);
		System.out.println(convertStringToInt(str));


	
	}

}