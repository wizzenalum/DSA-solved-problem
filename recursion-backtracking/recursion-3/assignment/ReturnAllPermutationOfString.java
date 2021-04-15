/*############################################################################
						   Return Permutations - String

	Given a string S, find and return all the possible permutations of the input 
	string.
	Note 1 : The order of permutations is not important.
	Note 2 : If original string contains duplicate characters, permutations will 
	also be duplicates.
	Input Format :
		String S

	Output Format :
		All permutations (in different lines)

	Sample Input :
		abc

	Sample Output :
		abc
		acb
		bac
		bca
		cab
		cba
				completed false
#############################################################################*/
import java.util.Scanner;
public class ReturnAllPermutationOfString{
	public static String[] permutationOfString(String input){
		String[] permutationArr;
		if(input.length()<=0) return new String[0];
		if(input.length()==1) {
			permutationArr = new String[1];
			permutationArr[0] = input;
			return permutationArr;
		}
		String nextInput = input.substring(1);
		String[] permutationSoFar = permutationOfString(nextInput);
		int size = input.length()*permutationSoFar.length, i = 0; 
		permutationArr = new String[size];
		for(String element:permutationSoFar){
			permutationArr[i++] = input.charAt(0)+element;
		}
		for(int charIndex =1; charIndex<input.length();charIndex++){
			nextInput = input.substring(0,charIndex)+input.substring(charIndex+1);
			permutationSoFar = permutationOfString(nextInput);
			for(String element:permutationSoFar){
				permutationArr[i++] = input.charAt(charIndex)+element;
			}
		}return permutationArr;		
	}
	public static void main(String[] args) {
		// System.out.println("my stha "+ intoAlphabet("1"));
		String[] result = permutationOfString("abcd");
		// System.out.println(Integer.parseInt("12")+1);
		for(int i =0; i<result.length;i++){
			System.out.print((i+1)+" ");
			System.out.println(result[i]);
		}
	}
}