/*############################################################################
						    Print Permutations 

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
				completed true
#############################################################################*/
import java.util.ArrayList;
public class PrintAllPermutationOfString{


	public static int FindPermutationsHelper(String input, ArrayList<String> list){
		if(input.length()<=0) return 0;
		if(input.length()==1) {
			list.add(input);
			return 1;
		}
		String nextInput;
		int size=0;
		for(int charIndex =0; charIndex<input.length();charIndex++){
			nextInput = input.substring(0,charIndex)+input.substring(charIndex+1);
			size = FindPermutationsHelper(nextInput,list);
			for(int i = list.size()-1;i>=list.size()-size;i--){
				if(list.get(i).length()==input.length()) break;

				list.set(i,input.charAt(charIndex)+list.get(i));
			}
		}return size*input.length();	
	}
	
	public static ArrayList<String> FindPermutations(String STR) {
		ArrayList<String> permutationArr = new ArrayList<>();
		FindPermutationsHelper(STR,permutationArr);
		return permutationArr;		
	}
	public static void main(String[] args) {
		// System.out.println("my stha "+ intoAlphabet("1"));
		ArrayList<String> result = FindPermutations("abc");
		// System.out.println(Integer.parseInt("12")+1);
		for(int i =0; i<result.size();i++){
			System.out.print((i+1)+" ");
			System.out.println(result.get(i));
		}
	}
}