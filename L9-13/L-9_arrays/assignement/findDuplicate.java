import java.util.Arrays;
import java.util.Scanner;
public class findDuplicate{ 
	public static int[] linearsort(int[] arr){
		int swap,len = arr.length;

		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(arr[i]>=arr[j]){
					swap = arr[i];
					arr[i] = arr[j];
					arr[j] = swap;
				}		
			}
		}
		return arr;
	}
    public static int duplicateNumber(int arr[]) {
		arr = linearsort(arr);
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]==arr[i+1]) return arr[i];
		}
		return -1;
    }
	public static void main(String[] args){
		int arr[] = {2,1,12,13,4,34,2,3};

		System.out.println(duplicateNumber(arr));

	}	

}