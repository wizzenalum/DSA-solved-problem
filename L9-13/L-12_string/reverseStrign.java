import java.util.Arrays;
import java.util.Scanner;
public class reverseStrign{

	public static String reverse1(String str){
		String nstr = "";
		for(int i=0;i<str.length();i++){
			nstr = str.charAt(i)+nstr;				
		}
		return nstr;
	}
	public static String reverse2(String str){
		String nstr = "";
		for(int i=str.length()-1; i>=0; i--){
			nstr+=str.charAt(i);
		}
		return nstr;
	}
	
	public static void main(String[] args){
		// Scaner scan = new Scanner(System.in);
		// String str = scan.nextLine();
		String str = "Hey baby";
		System.out.print(reverse2(str));
	}

		
		

}