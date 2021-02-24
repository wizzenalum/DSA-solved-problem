import java.util.Arrays;
import java.util.Scanner;
public class fibonacciSeries{
	public static int fibonacciNumber(int n,int a,int b){
		// return fibonacciNumber nth number where series start with a ans b.
		//                     	f(n-1)+f(n-2)  if n>2;
		//				f(n)=  	a 			  if n=1;
		//	
		if(n>2) return fibonacciNumber(n-1,a,b)+fibonacciNumber(n-2,a,b);
		if(n==2) return b;
		if(n==1) return a;
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args){
		for(int i=0;i=n;)
		System.out.print(fibonacciNumber(5,2,5));
	}

}