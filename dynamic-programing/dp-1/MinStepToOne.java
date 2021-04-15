/*############################################################################
						  Min Steps To One

		Given a positive integer 'n', find and return the minimum number of 
		steps that 'n' has to take to get reduced to 1. You can perform any 
		one of the following 3 steps:

		1.) Subtract 1 from it. (n = n - ­1) ,
		2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
		3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

				completed true
			
#############################################################################*/
import java.util.Scanner;
public class MinStepToOne{
// step 1  recursion
	public static int countMinStepsToOne(int n) {
		if(n==1) return 0;
		int tempCount = 0;
		int minCount = countMinStepsToOne(n-1);
		if(n%2==0){
			tempCount = countMinStepsToOne(n/2);
			minCount = tempCount<minCount?tempCount:minCount;
		}
		if(n%3==0){
			tempCount = countMinStepsToOne(n/3);
			minCount = tempCount<minCount?tempCount:minCount;
		} 
		return minCount+1;
	}
// step 2 using memoization technique
	public static int countMinStepsToOneMemo(int n, int[] arr){
		// stack over flow can be problem.
		if(n==1||arr[n-1]!=0) return arr[n-1];
		int minCount = countMinStepsToOneMemo(n-1,arr),tempCount = 0;
		if(n%2==0){
			tempCount = countMinStepsToOneMemo(n/2,arr);
			minCount = tempCount<minCount?tempCount:minCount;
		}
		if(n%3==0){
			tempCount = countMinStepsToOneMemo(n/3,arr);
			minCount = tempCount<minCount?tempCount:minCount;
		}
		arr[n-1] = minCount+1; 
		return minCount+1;
	}
// step 3 iterative dp
	public static int countMinStepsToOneIterDP(int n){
		if(n==1) return 0;
		int[] arr = new int[n];

		int i = 1, temp;
		while(i<n){
			temp = arr[i-1];
			if((i+1)%2==0) temp = temp<arr[i/2]?temp:arr[i/2];
			if((i+1)%3==0) temp = temp<arr[i/3]?temp:arr[i/3];
			arr[i]=temp+1;
			i++;
		}
		return arr[n-1];
	
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 3;
	// recursive approach
		// System.out.println(countMinStepsToOne(n));
	// memoization approach.
		int[] arr = new int[n];
		System.out.println(countMinStepsToOneMemo(n,arr));
	// iterative dp appraoch
		System.out.println(countMinStepsToOneIterDP(n));
	
	}


}