import java.util.Arrays;
import java.util.Scanner;
public class largestNonPlindrom{
	public static boolean checkpalindrome(String str){
		int end = str.length();
		for(int i =0, j=end-1; i<end/2; i++,j--){
			if(str.charAt(i)!=str.charAt(j)) return false;
		}
		return true;
	}
	public static boolean checksame(String str){
		int previous = 0;
		for(int i=1; i<str.length();i++){
			if(str.charAt(i)!=str.charAt(previous)) return false;
			previous = i;
		}return true;		
	}
	public static void main(String[] args){
		// Scanner scan = new Scanner(System.in);
		// String str = scan.nextLine();
		String str = "";
		if(checkpalindrome(str)){
			if(checksame(str)) System.out.println(0);
			else System.out.println(str.length()-1);
		}
		else System.out.println(str.length());
	}

}