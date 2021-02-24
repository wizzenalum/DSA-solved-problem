/*############################################################################
		Suppose you have a string, S, made up of only 'a's and 'b's. 
		Write a recursive function that checks if the string was generated 
		using the following rules:

			a. The string begins with an 'a'
			b. Each 'a' is followed by nothing or an 'a' or "bb"
			c. Each "bb" is followed by nothing or an 'a'

		If all the rules are followed by the given string, return true otherwise return false.
					Input format :
						String S
					Output format :
						'true' or 'false'
					Sample Input 1 :
						abb
					Sample Output 1 :
						true
					Sample Input 2 :
						abababa
					Sample Output 2 :
						false
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class checkAB{
	public static boolean checkAB(String input) {
		int len =  input.length();
		if(len<3){
			if(len==1&&input.equals("a")) return true;
			else if(len==2&&input.equals("aa")) return true;
			else return false;
		}
		if(input.charAt(len-1)==input.charAt(len-2)){
			return checkAB(input.substring(0,len-2));
		}else if(input.substring(len-3,len).equals("bba")){
			return checkAB(input.substring(0,len-3));
		}else return false;
		
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// String str =  scan.next();
		// String str = "abbabbabba";
		String str = "ab";
		System.out.println(checkAB(str));


	
	}

}