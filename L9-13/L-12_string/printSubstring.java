import java.util.Arrays;
import java.util.Scanner;
public class printSubstring{
	public static void printSubstring(String str){
		
			for (int j = i; j<str.length(); j++) {
				System.out.println(str.substring(i,j+1));
			}
		}			
	}
	public static void main(String[] args){
		// Scaner scan = new Scanner(System.in);
		// String str = scan.nextLine();
		String str = "hey baby";
		printSubstring(str);
		
		
	}

}