import java.util.Scanner;
public class searchInArray{
	

	public static int search(int[] arr, int start, int end,int k){
		if(start<end){
			int mid = (start+end)/2;
			if(arr[mid]==k) return mid;
			if((arr[start]<k&& k<arr[mid])||(arr[start]>arr[mid]&&k>arr[start]&&k>arr[mid])||(arr[start]>arr[mid]&&k<arr[start]&&k<arr[mid])){
				return search(arr,start,mid-1,k);
			}
			if((arr[mid]<k&&k<arr[end])||(arr[mid]>arr[end]&&arr[mid]>k&&arr[end]>k)||(arr[mid]>arr[end]&&arr[mid]<k&&arr[end]<k)) {
				return search(arr,mid+1,end,k);

			}
		}return -1;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		int k = scanner.nextInt();


		// int[] arr = {4,5,7,8,1,2,3};
		System.out.print(search(arr,0,n-1,k));

		
	}
}