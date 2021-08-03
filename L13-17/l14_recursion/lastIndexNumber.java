import java.util.Arrays;
import java.util.Scanner;
public class lastIndexNumber{

	public static int lastIndex1(int[] arr, int x, int index){
		if(arr.length-index>=arr.length) return -1;
		if(arr[index]==x) return index;
		return lastIndex1(arr,x, index-1);
	}
	
	public static int lastIndex(int input[], int x) {
		return lastIndex1(input,x,input.length-1);
	}
	public static void main(String[] args){
		int[] arr = {3,4,5,6,3,2,3,58};
		System.out.print(lastIndex(arr,3));
	}

}