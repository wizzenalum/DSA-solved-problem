import java.util.Arrays;
import java.util.Scanner;
public class VarArgs{
	
	public static void checkArgs(char a, String b, int sum, int... var){
		System.out.println(var.length);
		System.out.println("parameters"+a+" "+b+" "+sum);
		for(int i: var) System.out.println(i);
	}
	public static void main(String[] args) {
		char c1 = 'c';
		String str = "heloo";
		checkArgs(c1, str, 5,6,7,8,9,5);

	}
}