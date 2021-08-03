/*############################################################################
			Given an integer N, count and return the number of zeros that are 
			present in the given integer using recursion.
			Input Format :
				Integer N
			Output Format :
				Number of zeros in N
			Sample Input :
				00010204
			Sample Output :
				2

#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class countZero{
	public static int countZerosRec(int input){			
		if(input/10<=0) return input==0?1:0;
		if(input%10==0){
			return 1+countZerosRec(input/10);
		}
		return countZerosRec(input/10);
	
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 0;
		System.out.println(n);
		System.out.println(countZerosRec(n));	
	}

}