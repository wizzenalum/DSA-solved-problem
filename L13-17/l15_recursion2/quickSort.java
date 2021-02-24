import java.util.Arrays;
import java.util.Scanner;
public class quickSort{

	public static void swap(int[] arr, int i, int j){
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	public static int partitioning(int[] arr,int start, int end){
		// return index of partitioned value.
		System.out.println(start+" "+end);
		int partitionIndex = start+1;
		for(int i=start+1;i<=end;i++){
			if(arr[i]<=arr[start]){
				swap(arr,i,partitionIndex);
				partitionIndex++;
			}
		}swap(arr,start,partitionIndex-1);
		return partitionIndex-1;
	}
	
	public static void quick(int [] arr,int start, int end){
// this will return a sorted array where i assume pivot as first element of array. 
	// partisioning phase
		// take any number to its correct position.
		// all left elements are smaller and right elements are bigger.
		if(end-start<1) return;
		int partitionIndex = partitioning(arr,start,end);
		quick(arr,start,partitionIndex-1);
		quick(arr,partitionIndex+1,end);			
	}
	public static void main(String[] args){
		// Scanner s = new Scanner(System.in);
		// int size = s.nextInt();
		// int[] arr = new int[size];
		// for(int i = 0; i < size; i++){
		// 	arr[i] = s.nextInt();
		// }

		int[] arr = {8, 33, 2, 37, 9};
		// int[] arr = {2, 8, 33, 37, 9};
		quick(arr,0,arr.length-1);
		// System.out.print(partitioning(arr,2,4));
		System.out.print(Arrays.toString(arr));	
	}

}