/*############################################################################
						 Staircase

	A child is running up a staircase with N steps, and can hop either 1 step, 
	2 steps or 3 steps at a time. Implement a method to count how many possible 
	ways the child can run up to the stairs. You need to return number of 
	possible ways W.
				completed true
			
#############################################################################*/
import java.util.Scanner;
public class StaircaseDP{
// step 1  recursion
	public static int staircase(int n){
		if(n<4){
			if(n==1) return 1;
			if(n==2) return 2;
			if(n==3) return 4;
		}
		return staircase(n-1)+staircase(n-2)+staircase(n-3);
	
	}
// step 2 using memoization technique
	public static long staircasememo(int n, long[] arr){
		if(arr[n-1]!=0) return arr[n-1];
		if(n<4){
			if(n==1||n==2) arr[n-1] = n;
			if(n==3) arr[n-1] = 4;
			return arr[n-1];
		}
		arr[n-1] = staircasememo(n-1,arr)+staircasememo(n-2,arr)+staircasememo(n-3,arr);
		return arr[n-1];
	
	}
// step 3 iterative dp
	public static long staircaseIterDP(int n){
		if(n<1) return 0;
		long[] storage = {1,2,4};
		if(n<4) return storage[n-1];
		long i = 3, temp;
		while(i<n){
			temp = storage[0];
			storage[0] = storage[1];
			storage[1] = storage[2];
			storage[2] = storage[0]+storage[1]+temp;
			i++;
		}
		return storage[2];
	
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 40;
	// recursive approach
		// System.out.println(staircase(n));
	// memoization approach.
		long[] arr = new long[n];
		System.out.println(staircasememo(n,arr));
	// iterative dp appraoch
		System.out.println(staircaseIterDP(n));
	
	}


}