import java.util.Arrays;
import java.util.Scanner;
public class palindrom {
	public static boolean checkpalindrome(String str){
		int end = str.length();
		for(int i =0, j=end-1; i<end/2; i++,j--){
			if(str.charAt(i)!=str.charAt(j)) return false;
		}
		return true;
	}
	public static void main(String[] args){
		Scaner scan = new Scanner(System.in);
		String str = scan.nextLine();
		// String str = "isgsi";
		System.out.println(checkpalindrome(str));
   
	}
		
										

}