import java.util.Arrays;
import java.util.Scanner;
public class reverseEachWord{
	public static String reverseEachWord(String input){
		String[] arr = input.split(" ");
		String word = "", nstr="";
		for(int ele=0;ele<arr.length;ele++){
			word = "";
			for(int i=0;i<arr[ele].length();i++) word = arr[ele].charAt(i)+word;
				nstr += word+" ";
		}return nstr;
	}

	public static String reverseEachWord2(String str){
		String nstr = "",word="";
		int start = 0;
		int i;
		for(i =0; i < str.length(); i++){
			if(str.charAt(i)==' '){
				nstr= nstr+word+" ";
				word = "";
				start= i+1;
			}else{
				word = str.charAt(i)+word;
			}
		}nstr= nstr+word;
		return nstr;
	}
	
	public static void main(String[] args){
		String str = "i evol uoy ybba";
		System.out.println(reverseEachWord2(str));

	}

}