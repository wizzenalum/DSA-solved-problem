import java.util.Arrays;
import java.util.Scanner;
public class identicalArray{
	public static int linearSearch(int[] arr, int check){
		for(int i =0; i<arr.length; i++){
			if(arr[i] == check) return i;
		}
		return -1;
	}

	public static void swap(int[] arr,int first, int second){
		int swap = arr[first];
		arr[first] =arr[second];
		arr[second] =swap;
		arr[arr.length-1]++;
	}

	public static void doubleswap(int[] arr1, int[] arr2,int start){
	//search all possible perfect swap and swap them.		
		for(int i= start; i<arr1.length-1; i++){
			int check1 = linearSearch(arr1,arr2[i]);
			int check2 = linearSearch(arr2,arr1[i]);
			if(check1==check2 && i!=check2) swap(arr2,i,check2);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n+1];
		for(int i=0; i<n;i++) arr1[i]=scan.nextInt();
		for(int i=0; i<n;i++) arr2[i]=scan.nextInt();
		for(int i=0; i<arr1.length; i++){
			doubleswap(arr1,arr2,i);
			if(arr1[i]!=arr2[i]){
				int check =  linearSearch(arr2,arr1[i]);
				swap(arr2, i,check);

			}
		}
		System.out.print(arr2[arr2.length-1]);

	}
	
}