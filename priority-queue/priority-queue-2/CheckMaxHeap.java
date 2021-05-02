/*############################################################################
						 Check Max-Heap

	Given an array of integers, check whether it represents max-heap or not. 
	Return true if the given array represents max-heap, else return false.

				completed -- true
#############################################################################*/	

import java.util.Arrays;
public class CheckMaxHeap{
	public static boolean checkMaxHeap(int arr[]) {
	// retrun true or false if the given array is following max heap property or not.
		int end=arr.length, element = 0;
		if(end<2) return true;
		int child =0, child2 = 0;
		while(element<end){
				// System.out.print("/"+element+"/");
				child = element*2+1;
				child2 = element*2+2;
				if(	child>=end || (child2>=end && arr[child]<arr[element])) break;
				if(child2>=end && arr[child]>arr[element]) return false;
				if(arr[child]>arr[element] || arr[child2]>arr[element]) return false;
				element++;
		}
		return true;
	}
	public static void main(String[] args) {
		// int[] arr = {2,453,4,43,423,32,32,4676,76,8,67,6,5,243,23,5,1,78};
		int[] arr = {8,7,6,5,4,3,2,1};
		// int[] arr = {453,4,47};
		System.out.println(checkMaxHeap(arr));
		

	}
}