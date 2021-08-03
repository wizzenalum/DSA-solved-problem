/*############################################################################
						 Return subsets sum to k.
	Given an integer array (of length n), find and return all the subsets of 
	Given an array A of size n and an integer K, return all subsets of A which sum to K.

	solution:
		base case:
		smaller problems: whithout one element subsets to k. and without element subsets to k-element.

				completed true
#############################################################################*/
import java.util.Scanner;
public class ReturnSubsetOfArraySumZero{

	public static int[][] subsetsSumKHelper(int input[], int k, int index) {
		if(input.length<=index) return new int[0][0];
		int[][] output;
		// if(input.length==1){
		// 	output = new int[1][];
		// 	output[0] = input;
		// 	return output;
		// }
		int[][] subsets1 = subsetsSumKHelper(input, k, index+1);
		int[][] subsets2 = subsetsSumKHelper(input,k-input[index],index+1);
		int size = subsets2.length+subsets1.length, outputIndex=0; 
		if(input[index] == k){
			output = new int[size+1][];
			int[] pre = {input[index]};
			output[outputIndex++] = pre;
		}else output = new int[size][];

		for(int[] subset: subsets1){
			output[outputIndex++] = subset;

		}
		for(int[] subset: subsets2){
			int[] temp = new int[subset.length+1];
			temp[0] = input[index];
			for(int i = 1;i<subset.length+1;i++){
				temp[i] = subset[i-1];
			}
			output[outputIndex++] = temp;
		}	
		return output;

	}
	public static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumKHelper(input,k,0);

	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int[][] arrr = subsetsSumK(arr,8);
		// for(int[] a: arrr)System.out.println(a);
		for(int[] a:arrr){
			if(a!=null){
				for(int b:a) System.out.print(b+" ");
				System.out.println();

			}
		}
	}
}