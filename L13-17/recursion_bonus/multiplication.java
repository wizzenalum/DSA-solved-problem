/*############################################################################
		Given two integers M & N, calculate and return their multiplication
		using recursion. You can only use subtraction and addition for your 
		calculation. No other operators are allowed.
		Input format :
			Line 1 : Integer M
			Line 2 : Integer N
			examle 110 12
		Output format :
			M x N
			example 1320
#############################################################################*/	
import java.util.Arrays;
import java.util.Scanner;
public class multiplication{
	public static int multiplyTwoIntegers(int m, int n){
		if(m<=1 || n<=1) {
            if(m==1) return n;
            else if(n==1) return m;
            else if(n==0||m==0) return 0;
        }
		return n+(multiplyTwoIntegers(m-1,n));
	
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// int m=scan.nextInt();
		// int n = scan.nextInt();
		int m = 120;
		int n = 12;
		System.out.println(multiplyTwoIntegers(n,m));

	
	}

}