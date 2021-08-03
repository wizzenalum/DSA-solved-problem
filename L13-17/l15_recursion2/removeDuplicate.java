import java.util.Arrays;
import java.util.Scanner;
public class removeDuplicate{
	public static String removeConsecutiveDuplicates(String s) {
		int len = s.length();
		if(len<2) return s;
		if(s.charAt(0)==s.charAt(1)){
			return removeConsecutiveDuplicates(s.substring(1,len));
		}
		return s.charAt(0)+removeConsecutiveDuplicates(s.substring(1,len));

	}
	public static void main(String[] args){
		String str = "xz";
		System.out.print(removeConsecutiveDuplicates(str));
	}

}