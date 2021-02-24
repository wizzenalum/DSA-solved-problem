/*############################################################################
	Check whether a given String S is a palindrome using recursion.
	Return true or false.
		Input Format :
			String S like racecar

		Output Format :
			boolean like true

#############################################################################*/		
import java.util.Arrays;
import java.util.Scanner;
public class checkPalindrome{
	public static boolean isStringPalindrome(String input) {
		int len = input.length();
		if(len<2) return true;
		if(input.charAt(0)==input.charAt(len-1)){
			return isStringPalindrome(input.substring(1,len-1));
		}
		return false;
	
		}
	public static void main(String[] args){
		String str = "abbybb";
		System.out.println(isStringPalindrome(str));
	}

}