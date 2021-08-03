/*############################################################################
						Check AB 
	Suppose you have a string, S, made up of only 'a's and 'b's. Write a 
	recursive function that checks if the string was generated using the following rules:

	a. The string begins with an 'a'
	b. Each 'a' is followed by nothing or an 'a' or "bb"
	c. Each "bb" is followed by nothing or an 'a'

	If all the rules are followed by the given string, return true otherwise return false.
				completed true
#############################################################################*/
import java.util.Scanner;
public class CheckAB{
	public static boolean checkAB(String input) {
		if(input.length()==0) return false;
		if(input.length()==1 && input.equals("a")) return true;
		if(input.length()==2 && input.equals("aa")) return true;
		if(input.length()==3 && (input.equals("abb")|| input.equals("aaa"))) return true;
		
		boolean answer = false;
		if(input.length()>3){
			if(input.substring(0,2).equals("aa")){
				answer = checkAB(input.substring(1));
			}
			else if (input.substring(0,3).equals("abb")){
				answer = checkAB(input.substring(3));
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		String input = "bb";
		System.out.println(checkAB(input));
	}
}