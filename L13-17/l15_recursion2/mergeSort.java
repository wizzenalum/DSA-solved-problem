/*############################################################################
		sort a given array in increasing order.
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class mergeSort{
//****Solution1 time = O(nlogn) space = O(n) *********************************************************************

	public static void mergesort(int[] arr){
		int len = arr.length;
		if(len<=1) return;
		int mid = len/2;
		int[] arr1 = new int[mid];
		int[] arr2 = new int[len-mid];
		for(int i=0;i<mid;i++) arr1[i] = arr[i];
		for(int i=0;i<arr2.length;i++) arr2[i] = arr[mid+i];
		mergesort(arr1);
		mergesort(arr2);
		for(int i=0,j=0,k=0;i<arr.length;i++){

			if(k>=arr2.length||(j<arr1.length&&arr1[j]<=arr2[k])){
				arr[i] = arr1[j];
				j++;
			}else{
				arr[i]=arr2[k];
				k++;
			}
		}
		
	}
	public static void mergesort1(int[] arr,int start, int end){
		if(end-start<2){
			if(end-start==1 && arr[start]>arr[end]){
				int swap = arr[start];
				arr[start]=arr[end];
				arr[end]=swap;
				System.out.println(Arrays.toString(arr));
				return;
			}else return;
		}
		int mid=(start+end)/2;
		mergesort1(arr,start,mid);
		mergesort1(arr,mid+1,end);
		int[] arr1 =  new int[end-start+1];
		for(int i=0,j=start,k=mid+1;i<arr1.length;i++){
			if(k>end||(j<=mid&&arr[j]<=arr[k])){
				arr1[i] = arr[j];
				j++;
			}else{
				arr1[i]=arr[k];
				k++;
			}
		}for(int i=0;i<arr1.length;i++) arr[start+i] = arr1[i];	
	}
	
	public static void main(String[] args){
		int[] arr = {184,15};
		// mergesort1(arr,0,3);
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}

}