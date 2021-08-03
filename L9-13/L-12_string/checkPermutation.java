import java.util.Arrays;
import java.util.Scanner;
public class checkPermutation{
// method one failed
	public static int countChar(String str, char chr){
		int count = 0;
		for(int i =0,j=1;;){
			if(str.indexOf(chr,i)==-1) return count;
			else{
				i = str.indexOf(chr,i)+1;
				count++;
			}
		}
	}
	
	public static boolean isPermutation(String str1, String str2){
		String str = "";
		if(str1.length()!=str2.length()) return false;
		char current = str1.charAt(0);
		for(int i=0;i<str1.length();i++ ){

			if(str.indexOf(current)==-1&&countChar(str1,current)!=countChar(str2,current)){
				return false;
			}
			str += current;
			current = str1.charAt(i);

		}
		return true;
	}
//method 2 by using frequancy array.
	public static boolean isPermutation2(String str1, String str2){
		int[] frequancy = new int[256];
		for(int i=0;i<str1.length();i++) frequancy[(int)str1.charAt(i)]++;
		for(int i=0;i<str2.length();i++) frequancy[(int)str2.charAt(i)]--;
		for(int a:frequancy) if(a!=0) return false;
		

		System.out.print(Arrays.toString(frequancy));
		return true;
	}
	public static void main(String[] args){
		String str1 = "sinrtgk";
		String str2 = "stringg";
		// System.out.println(countChar(str1,'s'));

		System.out.println(isPermutation2(str1,str2));		
	}

}