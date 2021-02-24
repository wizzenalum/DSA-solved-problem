import java.util.Arrays;
import java.util.Scanner;
public class removeDuplicate{
	public static String removeDuplicates(String str){
		String output = "";
		for(int i =0; i < str.length(); i++){
			if(output.indexOf(str.charAt(i))==-1) output+=str.charAt(i);
		}return output;
	}

	public static String removeConsecutiveDuplicates(String str){
		if(str.isBlank()) return "";
		String output = str.substring(0,1);
		int first = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(first)!=str.charAt(i)){
				first = i;
				output += str.charAt(i);
			}
		}
		return output;
	}
	
	public static void main(String[] args){
		String str = "hhheythisiswhat";
		System.out.print(removeConsecutiveDuplicates(str));
		
	}

}