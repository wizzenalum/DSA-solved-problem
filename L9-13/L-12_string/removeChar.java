import java.util.Arrays;
import java.util.Scanner;
public class removeChar{
	public static String removeAllOccurrencesOfChar(String str, char ch){
		String output = "";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=ch) output += str.charAt(i);
		}return output;
	}
	public static void main(String[] args){
		String str  = "abby is my friend";
		System.out.print(removeAllOccurrencesOfChar(str,'b'));
	}

}