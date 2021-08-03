import java.util.Scanner;

public class findTransition {

	
	// public static int nearestTansition(int[] arr, int n){
	// 	int start = 0, end = n-1,mid = (start+end)/2;
	// 	while(start<end){
	// 		mid = (start+end)/2;
	// 		if(arr[start]!=arr[mid]){ 
	// 			end = mid-1;
	// 			if(arr[mid-1]!=arr[mid]) return mid;
	// 		}
	// 		else if(arr[mid]!=arr[end]){
	// 			start = mid+1;
	// 			if(arr[mid+1]!=arr[mid]) return mid;
	// 		}
	// 	}
	// 	return mid;
	// }
	public static int nearestTansition(int[] arr, int n){
		int start = 0, end = n-1,mid = (start+end)/2;
		while(start<end){
			mid = (start+end)/2;
			if(arr[mid-1]==1) end = mid-1;
			else if(arr[mid+1]==0) start = mid+1;
			else break;
		}
		return mid;
	}	
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		// int[] arr = new int[n];
		// for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		int[] arr = {0,0,0,1,1,1};
		int n = arr.length;
		if(arr[0]!=arr[n-1]){
			int near = nearestTansition(arr,n);
			if(arr[near]==0) System.out.print(near+1);
			else System.out.print(near);
		}else if(arr[0]==1) System.out.print(0);
		else System.out.print(-1);
	}

}