/*############################################################################
		Given a string S, compute recursively a new string where identical 
		chars that are adjacent in the original string are separated from 
		each other by a "*".
		Input format :
			String S
		Output format :
			Modified string
		Sample Input 1 :
			hellooo
		Sample Output 1:
			hel*lo*o*o
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class pairStar{
	public static String addStars(String s) {
		int len = s.length();
		if(len<=1) return s;
		if(s.charAt(0)==s.charAt(1)){
			return s.charAt(0)+"*"+addStars(s.substring(1,len));
		}
		return s.charAt(0)+addStars(s.substring(1,len));
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// String str =  scan.next();
		String str = "hellooo";
		System.out.println(addStars(str));

	
	}

}