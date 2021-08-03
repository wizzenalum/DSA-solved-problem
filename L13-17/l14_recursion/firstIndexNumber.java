import java.util.Arrays;
import java.util.Scanner;
public class firstIndexNumber{

	public static int firstIndex1(int[] arr, int x, int index){
		if(arr.length-index<=0) return -1;
		if(arr[index]==x) return index;
		return firstIndex1(arr,x, index+1);
	}
	
	public static int firstIndex(int input[], int x) {
		return firstIndex1(input,x,0);
	}
	public static void main(String[] args){
		int[] arr = {3,4,5,6,3,2,3,58};
		System.out.print(firstIndex(arr,52));
	}

}