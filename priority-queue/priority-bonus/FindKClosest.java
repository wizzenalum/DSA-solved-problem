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


				completed = true


#############################################################################*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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
// method 1
	public static void kClosest(int[] arr,int k, int x){
		// time O(nlogn) space O(n);
		// System.out.println(Arrays.toString(arr)+" "+k+" "+x);
		int n = arr.length;
		// creating sorted array first
		int[] arr2 = new int[n];

		for(int i = 0; i<n;i++){
			arr2[i] = arr[i];
		}
		heapSort(arr2);
		// System.out.println(Arrays.toString(arr2));
		
		// Hashmap of queues for storing the indecies of different valsue;
		HashMap<Integer,Queue<Integer>> map = new HashMap<>();
		for(int i =0;i<arr.length;i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], new LinkedList<Integer>());
			}
			map.get(arr[i]).add(i);
		}

		for (int i : map.keySet()) {
			Queue<Integer> list = map.get(i);
			// System.out.print(i+" (");
			for (int j = 0; j < list.size(); j++) {
				int inde = list.poll();
				// System.out.print(inde+", ");
				list.add(inde);
			}
			// System.out.println(")");
		}

		// lets make array of k elements.
		int i = 0, j = 0, indexK = 0;
		int[] kElements = new int[k];
		while(arr2[j]<=x && j<n) j++;
		// System.out.println(i+" i and j "+j);
		i=j-1;
		// System.out.println(i+" i and j "+j);
		while(indexK<k){
			if(i<0 || j>=n) break;
			else if(x-arr2[i]>arr2[j]-x){
				kElements[indexK] = arr2[j];
				j++;
			}
			else if(x-arr2[i]<arr2[j]-x){
				kElements[indexK] = arr2[i];
				i--;
			}
			else if(x-arr2[i]==arr2[j]-x){
				if(arr2[i] == arr2[j]){
					kElements[indexK] = arr2[i];
					i--;
				}else{
					if(map.get(arr2[i]).peek()<map.get(arr2[j]).peek()){
						map.get(arr2[i]).poll();
						kElements[indexK] = arr2[i];
						i--;
					}else{
						map.get(arr2[j]).poll();
						kElements[indexK] = arr2[j];
						j++;
					}
				}
			}
			indexK++;
		}
		while(indexK<k && i<0 && j<n){
			kElements[indexK] = arr2[j];
			j++;
			indexK++;
		}
		while(indexK<k && j>=n && i>=0){
			kElements[indexK] = arr2[i];
			i--;
			indexK++;
		}

		// sorting the ouput array;
		heapSort(kElements);
		for (int l : kElements) {
			System.out.print(l+" ");
		}
	}


// method 2 by finding difference
	public static void swap(Pair[] arr, int a, int b) {
		Pair swap = arr[a];
		arr[a] = arr[b];
		arr[b] = swap;
	}
	public static void upHippify(Pair[] arr, int index) {
		int parent = 0;
		while(index>0){
			parent = (index-1)/2;
			if(arr[parent].diff<arr[index].diff) swap(arr, index, parent);
			index = parent;
		}
	}
	public static void downHipify(Pair[] arr, int end) {
		int child1 = 0, child2 = 0, temp = 0;
		for (int i = 0; i < end;) {
			child1 = i*2+1;
			child2 = child1+1;
			if(child1>=end||(child2>=end && arr[child1].diff<=arr[i].diff) || 
				(arr[child1].diff<=arr[i].diff && arr[child2].diff<=arr[i].diff)) return;
			if(child2>=end){
				swap(arr,i,child1);
				return;
			}
			temp = child2;
			if(arr[child2].diff>arr[child1].diff){
				child2= child1;
				child1 = temp; 
			}
			swap(arr, child1,i);
			i = child1;
		}
	}
	static class Pair{
		int index;
		int diff;
		Pair(int index, int diff){
			this.index = index;
			this.diff = diff;
		}
	}
	public static void kClosest1(int[] arr,int k, int x){
		int n = arr.length;
		Pair[] arr2 = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = new Pair(i,Math.abs(arr[i]-x));
		}
		// now make a heap of k starting elements from the difference.
		for (int i = 1; i < k; i++) {
			upHippify(arr2, i);
		}
		// for (Pair pair : arr2) System.out.print("("+pair.index+","+pair.diff+")  ");
		// System.out.println();
		// now making that heap of k elements of minimum difference.
		for (int i = k; i < arr2.length; i++) {
			if(arr2[i].diff<arr2[0].diff){
				swap(arr2,0,i);
				for (int j = 0; j <k; j++) System.out.print("("+arr2[j].index+","+arr2[j].diff+")");
				System.out.println();
				downHipify(arr2, k);
				for (int j = 0; j <k; j++) System.out.print("("+arr2[j].index+","+arr2[j].diff+")");
				System.out.println();
			}
		}
		// now sort the heap and print it.
		int[] kElements = new int[k];
		for(int i = k-1;i>=0;i-- ){
			kElements[k-1-i] = arr[arr2[i].index]; 
		}
		heapSort(kElements);
		for (int i = 0; i < kElements.length; i++) {
			System.out.print(kElements[i]+" ");
		}
		
	}


	public static void main(String[] args) throws NumberFormatException,IOException {
		FileReader is = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/priority-queue/priority-bonus/sampleTest.txt");
		// InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		int n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n];

		String[] str = br.readLine().trim().split(" ");
		String[] str2 = br.readLine().trim().split(" ");
		br.close();
		is.close();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		} 
		int x = Integer.parseInt(str2[0]);
		int k = Integer.parseInt(str2[1]);
		// System.out.println(n+" "+Arrays.toString(arr)+" "+k+" "+x);
		// kClosest(arr, k, x);
		kClosest1(arr, k, x);
	}
}