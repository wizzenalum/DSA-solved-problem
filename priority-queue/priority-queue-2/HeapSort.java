import java.util.Arrays;
public class HeapSort{


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

	public static void upHipifyMin(int[] arr, int child){
		// this will hipify child upto reach to down.
			// System.out.println(Arrays.toString(arr));
		if(child<1||arr.length<2) return;
		int parent = 0, swap;
		while(child>0){
			parent = (child-1)/2;
			if(arr[child]<arr[parent]){
				swap = arr[child];
				arr[child] = arr[parent];
				arr[parent] = swap;
			}else break;
			child = parent;
		}
	}
	public static void upHipifyMax(int[] arr, int child){
		// this will hipify child upto reach to down.
		if(child<1||arr.length<2) return;
		int parent = 0, swap;
		while(child>0){
			parent = (child-1)/2;
			if(arr[child]>arr[parent]){
				swap = arr[child];
				arr[child] = arr[parent];
				arr[parent] = swap;
			}else break;
			child = parent;
		}
	}

	public static void downHipifyMax(int[] arr, int end, int element){
		//here end is the last element of the arr and element is wherre i should start.
		// this will hipify element upto reach to down.
		// System.out.print(Arrays.toString(arr)+" end "+ end + " "+element);
		if(arr.length<2||end-element<1){
		// System.out.println(Arrays.toString(arr));

			return;
		}
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
		// System.out.println(Arrays.toString(arr));

	}

	public static void heapSortReduce(int[] arr){
		if(arr.length<2) return;

		// lets apply heap order property first using  up hipify the arr.
		int i = 1, parent =0, child = 0, swap = 0, child2 = 0;
		for(;i<arr.length;i++){
			upHipifyMin(arr,i);
		}


		// sorting the arr using hipifing for all n elemets.
		for(i=arr.length-1;i>0;i--){
			// System.out.print(i);
			swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			downHipifyMin(arr, i, 0);

		}
	}

	public static void heapSortIncr(int[] arr){
		if(arr.length<2) return;

		// lets apply heap order property first using  up hipify the arr.
		int i = 1,swap = 0;
		for(;i<arr.length;i++){
			upHipifyMax(arr,i);
		}
		// System.out.println("time to sort the things");
		// sorting the arr using hipifing for all n elemets.
		for(i=arr.length-1;i>0;i--){
			// System.out.print(i);
			swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			downHipifyMax(arr, i, 0);
			// System.out.println(Arrays.toString(arr));

		}
	}
/************************* smallest code for both sorting **************/
// to change the order i only need to chang the onle line of code.
	public static int compare(int a, int b){
		// return a-b; // for max hipify;
		return b-a; // for min hipify;
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
	public static void main(String[] args) {
		int[] arr = {2,453,4,43,423,32,32,4676,76,8,67,6,5,243,23,5,1,78};
		// int[] arr = {8,7,6,5,4,3,2,1};
		// int[] arr = {1,2,3,4,5,6,7,8};
		// int[] arr = {453,4,47};
		// heapSortReduce(arr);
		// System.out.println(Arrays.toString(arr));
		// heapSortIncr(arr);
		// System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));


	}
}