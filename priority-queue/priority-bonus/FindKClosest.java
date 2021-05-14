/*############################################################################
						       Find k closest

	You are given a N-sized unsorted array and two integers x and k, you have 
	to find k closest values to x and put them in the output array.
	Note: If 2 numbers are at same distance and only one of them have to be 
	printed, print the one which is at a smaller index of the array.
	
	Input Format:
		The first line of input contains the size of the given array(N). The second 
		line of input contains the space separated array elements. The last line of 
		input contains the value of x and k separated by space.

	Output Format:
		The only output line contains k-closest values to x in a sorted manner
		(sorting is handled internally).

	Constraints:
		 1<=N<=10000
		 0<k<=N

	Sample Input:
		5
		10 15 20 25 30
		21 2

	Sample Output:
		20 25


				completed = false


#############################################################################*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class FindKClosest{

	public static int compare(int a, int b){
		return a-b; // for max hipify;
		// return b-a; // for min hipify;
	}
	public static void swap(int[] arr, int index1, int index2){
		int swap = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = swap;
	}
	public static void downHipify(int[] arr, int element, int end){		
		if(end-element<1) return;
		int child = 0, child2 = 0, swap=0;
		while(element<end){
			// swap++;
		// System.out.println("insert" + element);
			child = element*2 +1;
			child2 = element*2 +2;
			if(child>=end || (child2>=end && compare(arr[element], arr[child])>=0)) return;
			if(child2>=end){
				swap(arr,child,element);
				return;
			}
			if((compare(arr[element],arr[child2])>=0 && compare(arr[element], arr[child])>=0)) return;
			if(compare(arr[element],arr[child2])<0 || compare(arr[element], arr[child])<0){
				if(compare(arr[child],arr[child2])>0){
					swap(arr, child, element);
					element = child;
				}
				else{
					swap(arr,child2,element);
					element = child2;
				}
			}

		}
	}
	

	public static void heapSort(int[] arr){
		// create heap first
			// downHipify(arr, 0, arr.length);
		for(int i = arr.length/2 - 1; i>=0;i--){
			downHipify(arr, i, arr.length);
		}

		// now sort the array.
		for(int i = arr.length-1;i>0;i--){
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			downHipify(arr,0,i);
		}
	}
	public static void kClosest(int[] arr,int[] arr2,int k, int x){
		HashMap<Integer,ArrayList> map = new HashMap<>();
		// and index Queue to know the index;
		for(int i =0;i<arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], new ArrayList<Integer>());
			}
			map.get(arr[i]).add(i);
		}
		// lets print the k closest element to the x
		int temp = 0;
		int i = 0, j = 0;
		while(arr2[i]>=x && i<arr.length) i++;
		j = i+1;
		while(true){
			if(x-arr2[i]>arr2[j]-x){

			}
			if(maxHeap.size()==0){
				System.out.println("something wrong with you implementation");
				return -1;
			}
			if(input[indexQueue.peek()]<maxHeap.peek()){
				indexQueue.add(indexQueue.poll());
			}
			else if(input[indexQueue.peek()]==maxHeap.peek()){
				if(indexQueue.peek() == k) return time+1;
				maxHeap.poll();
				indexQueue.poll();
				time++;
			}
		}
	}


	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		// int[] arr = new int[n];
		// int[] arr2 = new int[n];
		// for(int i = 0; i<n;i++){
		// 	arr[i] = scan.nextInt();
			// arr2[i] = arr[i];
		// }
		// heapSort(arr2);
		// int x = scan.nextInt();
		// int k = scan.nextInt();
		// System.out.println("24 20");
		int[] arr = {10,15,20,25,30};
		int[] arr2 = {10,15,20,25,30};
		// int[] arr = {19,25,24,25,19,20,29};
		// int[] arr2 = {19,25,24,25,19,20,29};
		// int[] arr = {1,2,3,4,5,6,7,8};
		heapSort(arr2);

		kClosest(arr,arr2);
		// System.out.println(Arrays.toString(arr));
	}
}