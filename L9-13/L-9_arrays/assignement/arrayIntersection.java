import java.util.Arrays;
import java.util.Scanner;
public class arrayIntersection{
    public static void intersections(int arr1[], int arr2[]) {
    	int l=0,len = arr1.length>arr1.length?arr1.length:arr2.length;
    	int[] arr = new int[len];
    	for(int i=0;i<arr1.length;i++){
    		// System.out.println(i+ " i");
			for(int j=0;j<arr2.length;j++){
				// System.out.print(j+" j ");
				if(arr1[i]==arr2[j]){
					arr[l] = arr1[i];
					l++;
					arr2[j] = Integer.MIN_VALUE;
					break;
				}		
			}
		}
		for(int i=0;i<l;i++){
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args){
		int arr1[] = {5, 5, 4, 4, 5, 4};
		int arr2[] = {2,2,3,4,5};
		intersections(arr1,arr2);
	}
}