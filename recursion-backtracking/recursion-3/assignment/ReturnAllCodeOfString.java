/*############################################################################
						  Return all codes - String

	Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a 
	numeric string S. Write a program to return the list of all possible codes 
	that can be generated from the given string.
	Note : The order of codes are not important. And input string does not contain 0s.
		
	Input format :
		A numeric string

	Constraints :
		1 <= Length of String S <= 10
	
	Sample Input:
		1123

	Sample Output:
		aabc
		kbc
		alc
		aaw
		kw



				completed true
#############################################################################*/
import java.util.Scanner;
public class ReturnAllCodeOfString{


	public static String intoAlphabet(String var){
		return Character.toString((char)(Integer.parseInt(var)+'a'-1));
	}
	
	public static  String[] getCode(String input){
		String[] codesArr;
		if(input.length()<=0) return new String[0];
		if(input.length()==1){
			codesArr = new String[1];
			codesArr[0] = intoAlphabet(input);
			return codesArr;
		}
		String pre = input.substring(0,1);
		String[] codesSoFar = getCode(input.substring(1));


		int addedSize = 0;
		int twoDigits = Integer.parseInt(input.substring(0,2));
		char check = (char)((twoDigits%10)-1+'a');
		String[] newCodes = new String[codesSoFar.length];
		if(twoDigits<27){
			for(String str:codesSoFar){
				if(str.charAt(0) == check){
					newCodes[addedSize++] = intoAlphabet(input.substring(0,2))+str.substring(1);
				}
			}
		}
		// creating array of all possible codes.
		codesArr = new String[codesSoFar.length+addedSize];
		int i = 0;
		for(String a:codesSoFar){
			codesArr[i++] = intoAlphabet(pre)+a;
		}
		for(int j = 0; j<addedSize;j++){
			codesArr[i++] = newCodes[j];
		}
		return codesArr;
	}
	public static void main(String[] args) {
		// System.out.println("my stha "+ intoAlphabet("1"));
		String[] result = getCode("1123");
		// System.out.println(Integer.parseInt("12")+1);
		for(int i =0; i<result.length;i++){
			System.out.print((i+1)+" ");
			System.out.println(result[i]);
		}
	}
}