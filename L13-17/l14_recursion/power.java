import java.util.Arrays;
import java.util.Scanner;
public class power{
	public static int power(int x, int n) {
		// return power recursivly
		if(n==0) return 1;
		return x*power(x,n-1);
	}
	public static void main(String[] args){
		int x = 3;
		int n = 4;
		System.out.println(power(x,n));	
	}
}