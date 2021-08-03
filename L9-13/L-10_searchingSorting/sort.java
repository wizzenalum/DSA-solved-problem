import java.util.Arrays;

public class sort{
//****selection sort *********************************************************************
//start sorting from start of the array by comparing first eleement and moving forward.		
	public static void selection(int[] arr){
		for(int i=0; i<arr.length-1;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i]>arr[j]){
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;	
				} 
			}
		}
	}
//****bubble sort *********************************************************************
//sort from the back of the string. by swaping largest untill reaches the end.
	public static void bubble(int[] arr){
		for(int i=arr.length-1; i>0;i--){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int swap = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		}
	}
//****insertion sort *********************************************************************
//sort by inserting elements from the unsorted part of the array.
	// public static void insertion(int[] arr){
	// 	for(int i=1;i<arr.length;i++){
	// 		System.out.print("\n"+i+" = i --");
	// 		int replace = i;
	// 		for(int j=i-1;j>=0;j--){
	// 			if(arr[replace]<arr[j]){
	// 				int swap = arr[j];
	// 				arr[j] = arr[replace];
	// 				arr[replace] = swap;
	// 				replace--;
	// 				System.out.print("swap "+arr[j]+"wiht "+replace);
	// 			}if(arr[replace]>arr[j]){
	// 				System.out.print("break when j ="+j+" replace =" +replace);
	// 				break;

	// 			}
	// 		}
	// 	}
	// }
	// *****888compact version*********
	public static void insertion(int[] arr){
		for(int i=1;i<arr.length;i++){
			int replace = i;
			for(int j=i-1;j>=0;j--){
				if(arr[replace]<arr[j]){
					int swap = arr[j];
					arr[j] = arr[replace];
					arr[replace] = swap;
					replace--;
					continue;
				}break;
			}
		}
	}

    public static int[] merge(int arr1[], int arr2[]) {
    //create a sorted array by adding from two sorted arrays.
    	int indexArr1 = 0,len1 = arr1.length;
    	int indexArr2 = 0,len2 =  arr2.length;
    	int len = len1 + len2;	
    	int[] arr = new int[len];
    	for(int i=0;i<len;i++){
    		if(indexArr1<len1 && indexArr2<len2){
    			if(arr1[indexArr1]<arr2[indexArr2]){
    				arr[i] =  arr1[indexArr1];
    				indexArr1++;
    			}else{
    				arr[i] = arr2[indexArr2];
    				indexArr2++;
    			}
    		}else{
    			if(indexArr1<len1){
    				arr[i] =  arr1[indexArr1];
    				indexArr1++;
    			}else{
    				arr[i] = arr2[indexArr2];
    				indexArr2++;
    			}
    		}
    	}return arr;
    }
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int[] arr2 = {2,3,4,5,6,7,1,5,3,4,6,7,2};
		sort.selection(arr2);
		System.out.println(Arrays.toString(arr2)); //passed by value but value is reference of arry
		sort.bubble(arr2);
		System.out.println(Arrays.toString(arr2)); //passed by value but value is reference of arry
		sort.insertion(arr2);
		System.out.println(Arrays.toString(arr2)); //passed by value but value is reference of arry
		int[] arr1 = {3,6,9,12};
		int[] arr3 = {1,4,6,9,12,14};
		System.out.println(Arrays.toString(sort.merge(arr1, arr3)));
	}

}