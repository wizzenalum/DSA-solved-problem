/*############################################################################
	Given a string, compute recursively a new string 
	where all 'x' chars have been removed. recursily.
	Sample Input 1 :
		xaxb
	Sample Output 1:
		ab						

#############################################################################*/		
import java.util.Arrays;
import java.util.Scanner;
public class removex{
// soution 1 sending start index.
	public static String remove(String str, char x, int index){
		// remove any character from string 
		if(index>=str.length()) return str;
		if(str.charAt(index)=='x'){
			str = str.substring(0,index)+str.substring(index+1,str.length());
			return remove(str,x,index);
		}return remove(str,x,index+1);
	}
// solution 2
	public static String removeX(String input){
		//remove character x only
		if(input.length()<=0) return "";
		if(input.charAt(0)=='x') return removeX(input.substring(1,input.length()));
		return input.charAt(0)+removeX(input.substring(1,input.length()));
	}
	public static void main(String[] args){
		String str = "heloox chrixs";
		System.out.println(removeX(str));
		System.out.print(remove(str, 'x', 0));
	}

}