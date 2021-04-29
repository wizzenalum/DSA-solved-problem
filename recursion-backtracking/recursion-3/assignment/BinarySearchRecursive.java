/*############################################################################
						binary search recursive
	Given an integer sorted array (sorted in increasing order) and an element x, 
	find the x in given array using binary search. Return the index of x.
	Return -1 if x is not present in the given array.
	Note : If given array size is even, take first mid.
				completed true
#############################################################################*/
import java.util.Scanner;
public class BinarySearchRecursive{

	public static int binaryHelper(int[] arr, int element, int start, int end){
		if(start>end) return -1;
		// if(start==end){
		// 	if(arr[start]==element) return start;
		// 	else return -1;
		// }
		int mid = (end+start)/2;
		if(arr[mid]== element) return mid;
		if(arr[mid]>element) return binaryHelper(arr,element,start,mid-1);
		return binaryHelper(arr,element,mid+1,end);
	}
	
	public static int binarySearch(int input[], int element) {
		return binaryHelper(input,element,0,input.length-1);
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		// int[] arr = {1,2};
		System.out.println(binarySearch(arr,));
	}
}