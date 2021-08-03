/*############################################################################
						 pritn subsequances of string
	for given string we have to print subsequances of strings.

				completed true
#############################################################################*/
import java.util.Scanner;
public class printSubsequancesOfString{
	public static void printSubsequances(String str, String outputSoFar){
		// here i am making all possible outputs in outputSoFar variable.
		if(str.length()<=0){
			if(outputSoFar.length()>0) System.out.println(outputSoFar);
			return;
		}
		printSubsequances(str.substring(1),outputSoFar);
		printSubsequances(str.substring(1),str.substring(0,1)+outputSoFar);
	}
	public static void main(String[] args) {
		String input = "abcd";
		printSubsequances(input,"");
	}
}