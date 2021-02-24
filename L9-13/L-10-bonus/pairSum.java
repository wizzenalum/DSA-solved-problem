import java.util.Scanner;

public class pairSum {


	public static boolean checkPairSum(int[] arr, int min, int max,int sum){
		// it will check given sum is posible by any two elements of arr or not.
		int n = arr.length;
		for(int i=0;i<n;i++){
			if(sum==arr[max]+arr[min]) return true;
			else if(sum<arr[max]+arr[min]) max = (max+n-1)%n;
			else min = (min+n+1)%n; 
		} 
		return false;
	}
	

	
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		// int[] arr = new int[n];
		// for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		// int sum = scanner.nextInt();
		int sum = 3;
		int[] arr = {12,15,20,32,43,5,6,7,8,9};
		int n = arr.length;
		int min = 0, max = n-1;
		boolean minflag = true, maxflag = true;
		while(minflag || maxflag){
			if(arr[max]>arr[(max+n+1)%n]) maxflag = false;
			else max = (max+n+1)%n;
			if(arr[min]<arr[(min+n-1)%n]) minflag = false;
			else min = (n+min-1)%n;
		}
		if(checkPairSum(arr,min,max,sum)) System.out.print("true");
		else System.out.print("false");
	}
}
// 6
// 3 4 5 0 1 2
// 7