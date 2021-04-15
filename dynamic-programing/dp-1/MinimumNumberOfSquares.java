/*############################################################################
						   Minimum Number Of Squares

	Given an integer N, find and return the count of minimum numbers required 
	to represent N as a sum of squares.
	That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} 
	and {2^2}. The output will be 1, as 1 is the minimum count of numbers 
	required to represent N as sum of squares. 

				completed true
			
#############################################################################*/
import java.util.Scanner;
public class MinimumNumberOfSquares{
// step 1  recursion
	public static int minCount(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		int i = 1, tempSteps=0,minSteps=Integer.MAX_VALUE;
		while(i*i<=n){
			tempSteps = minCount(n-i*i);
			if(tempSteps<minSteps) minSteps = tempSteps;
			i++;
		}
		return minSteps+1;
	}
// step 2 using memoization technique
	public static int minCountMemo(int n, int[] arr){
		if(n==0) return 0;
		if(arr[n]!=0) return arr[n];
		int i = 1, tempSteps=0,minSteps=Integer.MAX_VALUE;
		while(i*i<=n){
			tempSteps = minCountMemo(n-i*i,arr);
			if(tempSteps<minSteps) minSteps = tempSteps;
			i++;
		}
		arr[n] = minSteps+1;
		return arr[n];
	}
// step 3 iterative dp
	public static int minCountIterDP(int n){
		if(n==1) return 1;
		int[] storage = new int[n+1];
		storage[1] = 1;
		int i = 2, temp = 0, tempSteps = 0, steps=0;
		while(i<=n){
			temp = 1;
			tempSteps = storage[i-1];
			steps = tempSteps;
			while(temp*temp<=i){
				tempSteps = storage[i-temp*temp];
				if(tempSteps<steps) steps = tempSteps;
				temp++;
			}
			storage[i] = steps+1;
			i++;
		}
		return storage[n];	
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 60;
	// recursive approach
		// System.out.println(minCount(n));
	// memoization approach.
		int[] arr = new int[n+1];
		arr[1] = 1;
		System.out.println(minCountMemo(n,arr));
	// // iterative dp appraoch
		System.out.println(minCountIterDP(n));
	
	}


}