import java.util.Arrays;
import java.util.Scanner;
public class arrayIntersection{
	public static void intersection(int arr1[], int arr2[]) {
//time complexity is O(n*m). brute force solution
		System.out.print(Arrays.toString(arr1));
    	for(int i=0;i<arr1.length;i++){
			for(int j=0;j<arr2.length;j++){
				if(arr1[i]==arr2[j]){
					System.out.print(arr1[i]+" ");
					arr2[j] = Integer.MIN_VALUE;
					break;
				}		
			}
		}
	}
	public static void intersection1(int[] arr1, int[] arr2) {
/*		we sort the arrys then check for intersection by inclreamenting one by one.
		here to sort time complexity == O(nlogn+mlogm)
		time complexity for intersection == O(n+m)
		so time complexity of algorithm = O(nlogn+mlogm)
*/
		if(arr1.length==0||arr2.length==0) return;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i=0,j=0; i<arr1.length&&j<arr2.length;){
			if(arr1[i]>arr2[j]) j++;
			else if(arr1[i]<arr2[j]) i++;
			else{
				System.out.print(arr1[i]+" ");
			j++;
			i++;
			}
		}    	
    }

   	public static int binarySearch(int[] arr,int key){
   		int start =0, end = arr.length-1, mid;
   		while(start<=end){
   			mid = (start+end)/2;
   			if(arr[mid]==key)return mid;
   			else if(arr[mid]>key) end = mid-1;
   			else start=mid+1;
   		}return -1;

   	}

   	public static void printIntersection(int[] arr1, int[] arr2){
   		// always array2 is small in size
   		int n = arr1.length, m=arr2.length, zeros=0;
		Arrays.sort(arr2);
		for(int i=0; i<n&&arr2[i]<=0; i++) if(arr2[i]==0) zeros++;
		for(int i=0; i<n; i++){
			if(arr1[i]==0&&zeros>0) zeros--;
			else if (arr1[i]!=0){
				int index = binarySearch(arr2,arr1[i]);
				if(index>=0){
					System.out.print(arr1[i]+" ");
					arr2[index]=0;
				}
			}
		}	
   	}   	
    public static void intersection2(int[] arr1, int[] arr2){
    /*
		sort first array and then look elements of another array in it by binary search.
		sorting one array = O(nlogn)
		searching all m elements in sorted array = O(mlogn)
		so complexity of algo = O((n+m)logm) if we sort smaller array then complexity also improve.
    */	
   		int n = arr1.length, m=arr2.length;
		if(n==0||m==0) return;
		if(n>=m) printIntersection2(arr1,arr2);
		else printIntersection2(arr2,arr1);
    }
    				
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test=0; test<t; test++){
			int n = scan.nextInt();
			int[] arr1 = new int[n];
			for(int i=0; i<n;i++) arr1[i]=scan.nextInt();
			int m = scan.nextInt();
			int[] arr2 = new int[m];
			for(int i=0; i<m;i++) arr2[i]=scan.nextInt();
			intersection2(arr2,arr1);
		}
		// int[] arr2 = {5,8,7,4,8};
		// int[] arr1 = {4,6,6,10, 8, 5, 5, 1};
		// // System.out.print(Arrays.toString(arr));
		// intersection2(arr2,arr1);
	
	}

}