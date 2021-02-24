import java.util.Arrays;
import java.util.Scanner;
public class reverseWords{
	public static String reverseWordWise1(String input){
		String[] sarr = input.split(" ");
		String s = "";
		for(String a: sarr){
			s = a+" "+s;
		}
		return s;
	}

	public static String reverseWordWise2(String input){
		String nstr = "";
		int start = 0;
		int i;
		for(i =0; i < input.length(); i++){
			if(input.charAt(i)==' '){
				nstr= input.substring(start,i)+" "+nstr;
				start= i+1;
			}
		}nstr = input.substring(start,i)+" "+nstr;
		return nstr;
	}
		
	public static void main(String[] args){
		String str = new String("abby you are sun shine");
		System.out.print(reverseWordWise2(str));
	}

}