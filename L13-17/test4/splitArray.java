import java.util.Arrays;
import java.util.Scanner;


public class splitArray {
//****wrong solution. *********************************************************************

	public static void swap(int[] arr, int i, int j){
		int s = arr[i];
		arr[i] = arr[j];
		arr[j] = s; 
	}
		
	public static boolean splitArray(int input[]) {
		int len = input.length, track5 = 0, track3 = len-1;
	// partitioning the aray to seprate 5 divisible and 3 divisibles
		// there is some issue with this i have to fix this 
		for(int i=0;i<=track3;i++){
			if(input[i]%5==0) {
				swap(input,i,track5);
				track5++;
			}
			else if(input[i]%3==0) {
				swap(input,i,track3);
				track3--;
				i--;
			} 
		}
		System.out.println(Arrays.toString(input)+" "+ track5+" "+ track3);

	// check sum is posible or not
		int sum5group = 0, sum3group = 0;
		for(int i=0;i<len;i++){
			if(i<track5){
				sum5group+=input[i];
			}else {
				sum3group +=input[i];
			}
		}
		// System.out.println(Arrays.toString(input));
		// following for loops are not considering all the posible cases.
		for(int i =track5; i<=track3;i++){
			if(sum3group==sum5group) return true;
			else{
				for(int j = i;j<=track3;j++){
					int temp5group = sum5group, temp3group = sum3group;
					temp5group += input[j];
					temp3group-=input[j];
					if(temp3group==temp5group) return true;
					if(temp5group>temp3group) break;
					System.out.print(temp5group+" "+ temp3group+" "+track5+" "+track3);
				
				}
			}
			System.out.println();
			sum5group += input[i];
			sum3group-=input[i];

			// System.out.println(sum5group+" "+ sum3group+" "+track5+" "+track3);

		}
		// System.out.print(Arrays.toString(input));
		return false;
	}


//**** slution by functions  *********************************************************************
// here i took left sum and right sum do it bruitforce way.

	// public static boolean splitArray1(int[] input){
	// 	return check(input,0,0,0);

	// }

	// public static boolean check(int[] arr, int startIndex, int leftSum, int rightSum ){
	// 	if(startIndex==arr.length) return leftSum==rightSum;
	// 	if(arr[startIndex]%5==0){
	// 		return check(arr,startIndex+1, leftSum+arr[startIndex], rightSum);
	// 	}else if(arr[startIndex]%3==0){
	// 		return check(arr,startIndex+1, leftSum, arr[startIndex]+rightSum);
	// 	}else{
	// 		boolean left = check(arr,startIndex+1, leftSum+arr[startIndex], rightSum);
	// 		boolean right = check(arr,startIndex+1, leftSum, arr[startIndex]+rightSum);
	// 		if(left||right) return true;
	// 		return false;
	// 	}
		
	// }
		
				

	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		// int[] arr = new int[n];
		// for(int i=0; i<n;i++) arr[i]=scan.nextInt();
		// int[] arr = {3,4,5,6,7,8,10,15,9};
		// int[] arr = {15,3,6,1,2,1};
		// int[] arr = {3, 5, 3, 3, 3, 3, 5, 1, 2};
		int[] arr = {7, 5, 4,8, 91, 4, 2, 75 };
		// swap(arr,0,1);

		System.out.println(Arrays.toString(arr));

		System.out.println(splitArray(arr));
	}
}