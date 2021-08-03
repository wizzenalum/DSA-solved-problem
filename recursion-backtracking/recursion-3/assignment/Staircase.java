/*############################################################################
						 Staircase

	A child is running up a staircase with N steps, and can hop either 1 step, 
	2 steps or 3 steps at a time. Implement a method to count how many possible 
	ways the child can run up to the stairs. You need to return number of 
	possible ways W.
				completed false
#############################################################################*/
import java.util.Scanner;
public class Staircase{
	public static int staircase(int n){
		if(n<4){
			if(n==1) return 1;
			if(n==2) return 2;
			if(n==3) return 4;
		}
		return staircase(n-1)+staircase(n-2)+staircase(n-3);
	
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 5;
		System.out.println(staircase(n));

	
	}


}