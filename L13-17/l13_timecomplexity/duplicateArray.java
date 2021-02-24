import java.util.Arrays;
import java.util.Scanner;
public class duplicateArray{
//****solution1 bruit force solution O(n*n) *********************************************************************

//****solution 2 by sorting O(nlogn)*********************************************************************

	public static int findDuplicate1(int[] arr) {
		Arrays.sort(arr);
		int start =0,end=0,mid;
		for(int i=1;i<arr.length;i++){
			if(arr[i-1]==arr[i]) return arr[i];
		}return -1;
		
	}
//****solution 3 bu xor O(n) *********************************************************************
	//1. If we XOR a number by itself, even number of times then it will give you 0.
	//2. If we XOR a number with itself, odd number of times, then it will give you the numberitself.
	//3.Also XOR of a number with 0 gives you that number again.
	//here as we know all numbers are 0 to n-2 so xor all them and xor them with
	//arr elements now duplicate one xored thrice and others are twice so resultant
	//will be duplicate value.
	public static int findDuplicate2(int[] arr) {
		int output =0,len = arr.length;
		for(int i=0;i<len;i++){
			if(i<len-1){
				output =output^arr[i]^i;
			}
			else output^=arr[i];
		}return output;
		
	}
//****solution 3 by math calculation O(n) *********************************************************************
	//as we know all the element that are in array once so answer=sum(all elements)-sum(1ton-2)
	public static int findDuplicate3(int[] arr) {
		int sum1 =0, sum2=0,len = arr.length;
		sum1 = (len-1)*(len-2)/2;
		for(int i=0;i<len;i++){
			sum2 += arr[i];
		}return sum2-sum1;
		
	}
	public static void main(String[] args){
		// Scanner scan =  new Scanner(System.in);
		// int t = scan.nextInt();
		// for(int test=0; test<t; test++){
		// 	int n = scan.nextInt();
		// 	int[] arr = new int[n];
		// 	for(int i=0; i<n;i++) arr[i]=scan.nextInt();
		// 	System.out.print(findDuplicate1(arr));
		// }
		int arr[] = {0,3,2,1,4,2};
		System.out.print(findDuplicate3(arr));


	}

}