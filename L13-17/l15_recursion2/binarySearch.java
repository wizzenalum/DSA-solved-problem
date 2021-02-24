import java.util.Scanner;
public class binarySearch{
	

	public static int search(int[] arr, int start, int end,int k){
		// return the index of k in sorted arr if it present if not return -1.
		if(start<=end){
			int mid = (start+end)/2;
			if(arr[mid]==k) return mid;
			if(arr[mid]>k){
				return search(arr,start,mid-1,k);
			}
			if(arr[mid]<k) {
				return search(arr,mid+1,end,k);

			}
		}return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		// int[] arr = new int[n];
		// for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		// int k = scanner.nextInt();
		// System.out.print(search(arr,0,n-1,k));


		int[] arr = {1,2,3,4,5,6,55,435,678};
		System.out.print(search(arr,0,8,678));

		
	}
}