/*############################################################################
						 subsequances of string
	for given string we have to return array of subsequances of strings;

				completed true
#############################################################################*/
import java.util.Scanner;
public class subsequancesOfString{
	public static String[] subsequances(String str){
		if(str.length()<=0) return new String[0];
		String pre = str.substring(0,1);
		String[] subArray = subsequances(str.substring(1));
		String[] output = new String[subArray.length*2+1];
		output[0] = pre;
		int i = 1;
		for(String a:subArray){
			output[i++] = a;
		}
		for(String a:subArray){
			output[i++] = pre+a;
		}
		return output;
	}
	public static void main(String[] args) {
		String[] result = subsequances("abcbe");
		for(int i =0; i<result.length;i++){
			System.out.print((i+1)+" ");
			System.out.println(result[i]);
		}
	}
}