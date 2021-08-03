/*############################################################################
						 heap Sorting reducing and incrasing order.
	
	Time complexity should be O(n * logk) and space complexity should 
	not be more than O(1).
	

				completed -- true
#############################################################################*/	

import java.util.Arrays;
public class HeapSortOptimize{

	public static void downHipifyMax(int[] arr, int end, int element){
		//here end is the last element  when index from 1 of the arr and element is wherre i should start.
		// this will hipify element upto reach to down.
		// System.out.print(Arrays.toString(arr)+" end "+ end + " "+element);
		if(arr.length<2||end-element<1) return;
		int child =0, child2 = 0, swap = 0;
		while(element<end){
				// System.out.print("/"+element+"/");
				child = element*2+1;
				child2 = element*2+2;
				if(	child>=end || (child2>=end && arr[child]<arr[element]) || 
					(arr[child]<arr[element] && arr[child2]<arr[element])) break;
				if(child2>=end){
					swap = arr[child];
					arr[child] = arr[element];
					arr[element] = swap;
					break;
				}
				child = arr[child2]<arr[child]?child:child2;

				swap = arr[child];
				arr[child] = arr[element];
				arr[element] = swap;
				element = child;
			}
	}
	public static void downHipifyMin(int[] arr, int end, int element){
		//here end is the last element of the arr and element is wherre i should start.
		// this will hipify element upto reach to down.
		if(arr.length<2||end-element<1) return;
		int child =0, child2 = 0, swap = 0;
		while(element<end){
				// System.out.print("/"+element+"/");
				child = element*2+1;
				child2 = element*2+2;
				if(	child>=end || (child2>=end && arr[child]>arr[element]) || 
					(arr[child]>arr[element] && arr[child2]>arr[element])) break;
				if(child2>=end){
					swap = arr[child];
					arr[child] = arr[element];
					arr[element] = swap;
					break;
				}
				child = arr[child]<arr[child2]?child:child2;

				swap = arr[child];
				arr[child] = arr[element];
				arr[element] = swap;
				element = child;
			}
	}
	public static void heapSortReduce(int[] arr){
		if(arr.length<2) return;

		// lets apply heap order property first using  down hipify the arr.
		int i = 1, swap = 0, len = arr.length;
		for(i = arr.length/2 -1 ;i>=0;i--){
			downHipifyMin(arr,len,i);
		}
		// System.out.println("time to sort the things");
		// sorting the arr using hipifing for all n elemets.
		for(i=len-1;i>0;i--){
			swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			downHipifyMin(arr,i,0);
		}
	}

	public static void heapSortIncr(int[] arr){
		if(arr.length<2) return;

		// lets apply heap order property first using  up hipify the arr.
		// lets apply heap order property first using  down hipify the arr.
		int i = 1, swap = 0, len = arr.length;
		for(i = arr.length/2 -1 ;i>=0;i--){
			downHipifyMax(arr, len, i);
		}
		// System.out.println("time to sort the things");
		// sorting the arr using hipifing for all n elemets.
		for(i=arr.length-1;i>0;i--){
			swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			downHipifyMax(arr,i,0);
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,453,4,43,423,32,32,4676,76,8,67,6,5,243,23,5,1,78};
		// int[] arr = {8,7,6,5,4,3,2,1};
		// int[] arr = {453,4,47};
		heapSortReduce(arr);
		System.out.println(Arrays.toString(arr));
		heapSortIncr(arr);
		System.out.println(Arrays.toString(arr));

	}
}