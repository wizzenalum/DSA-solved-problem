import java.util.Arrays;
import java.util.Scanner;
public class minimumLengthWord{
	public static String minLengthWord(String input){
		String[] arr = input.split(" ");
		int min = Integer.MAX_VALUE;
		for(String a:arr){
			if(a.length()<min) min=a.length();
		}
		for(String a:arr){
			if(a.length()==min) return a;
		}
		return "";
	}
	public static void main(String[] args){
		String str = "abc de ghihjk a uvw h j";
		System.out.println(minLengthWord(str));
	}

}