/*############################################################################
						  Print all codes - String

	Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a 
	numeric string S. Write a program to Print the list of all possible codes 
	that can be generated from the given string.
	Note : The order of codes are not important. And input string does not contain 0s.
		
	Input format :
		A numeric string

	Constraints :
		1 <= Length of String S <= 10
	
	Sample Input:
		1123

	Sample Output:
		aabc
		kbc
		alc
		aaw
		kw



				completed true
				
#############################################################################*/
import java.util.Scanner;
public class PrintAllCodeOfString{

	public static String intoAlphabet(String var){
		
		return Character.toString((char)('a'-1+Integer.parseInt(var)));
	}
	

	public static void printAllPossibleCodesHelper(String input, String code){
		if(input.length()<=0){
			if(code.length()>0) System.out.println(code);
			return;
		}
		String nextCode="";	
		if(input.length()==1){
			code = code+intoAlphabet(input);
			printAllPossibleCodesHelper("",code);
		}else{
			nextCode = code+intoAlphabet(input.substring(0,1));
			printAllPossibleCodesHelper(input.substring(1),nextCode);
			if(Integer.parseInt(input.substring(0,2))<27){
				code = code+intoAlphabet(input.substring(0,2));
				printAllPossibleCodesHelper(input.substring(2),code);
			}
		}

	}
	

	public static void printAllPossibleCodes(String input) {
		printAllPossibleCodesHelper(input, "");
	}
	public static void main(String[] args) {
		String input = "1123";
		// System.out.println(intoAlphabet(input));
		printAllPossibleCodes(input);
	}
}