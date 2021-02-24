import java.util.Scanner;
import java.util.Arrays;
public class distribution {
	public static void swap(int[] arr, int i, int j){
		int swap =  arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}	
	public static void sort(int[] arr){

		for(int i=1;i<arr.length;i++){
			int index = i;
			for(int j=i-1;j>=0;j--){
				if(arr[j]>arr[index]){
					swap(arr,j,index);
					index = j;
				}
				else break;
			}	
		}
	}

	public static int distribution(int[] arr, int m){
		int dif = Integer.MAX_VALUE;
		for(int i=0; i<=arr.length-m;i++){
			if(arr[i+m-1]-arr[i]<dif){
				dif =arr[i+m-1]-arr[i];
			}

		}
		return dif;
	}

	
	public static void main(String[] args) {
//****Distribution Problem *********************************************************************
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		int m = scanner.nextInt();
		// System.out.print(Arrays.toString(arr));
		// int[] arr = {6,4,2,9,0,5};
		sort(arr);
		// System.out.println(Arrays.toString(arr));
		System.out.print(distribution(arr,m));

	}
}