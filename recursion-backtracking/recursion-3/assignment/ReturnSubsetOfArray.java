/*############################################################################
						 Return subset of an array
	Given an integer array (of length n), find and return all the subsets of 
	input array.
	Subsets are of length varying from 0 to n, that contain elements of the array. 
	But the order of elements should remain same as in the input array.
	Note : The order of subsets are not important.
			array 
				15 20 12

			Sample Output:
				12 
				20 
				20 12 
				15 
				15 12 
				15 20 
				15 20 12 
				completed true
#############################################################################*/
import java.util.Scanner;
public class ReturnSubsetOfArray{
	public static int[][] subsetsHelper(int input[], int index) {
		if(input.length<=index) return new int[0][0];
		
		int[] pre = {input[index]};
		int[][] output = null;
		int[][] subArray = subsetsHelper(input,index+1);
		output = new int[subArray.length*2+1][];
		output[0] = pre;
		int i = 1;
		for(int[] a:subArray){
			output[i++] = a;
		}
		for(int[] a:subArray){
			int[] temp = new int[a.length+1];
			temp[0] = pre[0];
			for(int j= 0;j<a.length;j++){
				temp[j+1] = a[j];
			}
			output[i++] = temp;
		}
		return output;
	}
	public static int[][] subsets(int input[]) {
		return (subsetsHelper(input,0));
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[][] arrr = subsets(arr);
		// for(int[] a: arrr)System.out.println(a);
		for(int[] a:arrr){
			if(a!=null){
				for(int b:a) System.out.print(b+" ");
				System.out.println();

			}
		}
	}
}