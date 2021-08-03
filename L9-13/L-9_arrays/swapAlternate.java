import java.util.Arrays;
import java.util.Scanner;
public class swapAlternate{
	public static void swapAlternate(int arr[]) {
		for(int i=0;i<arr.length-1;i+=2){
			arr[i]   = arr[i+1]+arr[i];
			arr[i+1] = arr[i]-arr[i+1];
			arr[i]   = arr[i]-arr[i+1];
		}
    }
	public static void main(String[] args) {
		int arr[] = {9, 3, 6, 12, 4, 32, 5, 11, 19};
		swapAlternate(arr);	
	
	}
}
