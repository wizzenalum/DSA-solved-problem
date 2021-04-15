/*############################################################################
						 print subsets sum to k.
	Given an integer array (of length n), find and print all the subsets of 
	Given an array A of size n and an integer K, return all subsets of A which sum to K.

	

				completed true
#############################################################################*/
import java.util.Scanner;
public class PrintSubsetOfArraySumZero{


	public static void printSubsetsSumTokHelper(int[] input, int k, int index, int[] outputSoFar, int sumSoFar){
		if(input.length<= index){
			if(sumSoFar==k){
				for(int ele:outputSoFar) System.out.print(ele+" ");
				System.out.println();
			}return;
		}
		printSubsetsSumTokHelper(input,k,index+1,outputSoFar,sumSoFar);
		int[] cloneOutputSoFar = new int[outputSoFar.length+1];
		cloneOutputSoFar[cloneOutputSoFar.length-1] = input[index];
		for(int i = 0;i<outputSoFar.length;i++){
			cloneOutputSoFar[i] = outputSoFar[i];
		}
		sumSoFar +=input[index];
		printSubsetsSumTokHelper(input,k,index+1,cloneOutputSoFar,sumSoFar);
	}
	

	public static void printSubsetsSumTok(int input[], int k) {
		printSubsetsSumTokHelper(input, k, 0, new int[0],0);
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		printSubsetsSumTok(arr,8);
		
	}
}