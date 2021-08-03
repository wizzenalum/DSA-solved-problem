import java.util.Arrays;
import java.util.Scanner;
public class sumOfArray{
	public static int sum(int input[]) {
	//return
		if(input.length==0) return 0;
		int[] arr = new int[input.length-1];
		for(int i=0; i<input.length-1; i++) arr[i] = input[i+1];
		return input[0]+sum(arr);
	}
	public static int sum2(int input[],int start) {
	//return sum recursively.
		if(input.length-start<=0) return 0;
		return input[start]+sum2(input, start+1);
	}
	public static void main(String[] args){
		int[] arr = {3,4,5,6,3,2,3};
		System.out.println(sum(arr));
		System.out.println(sum2(arr,0));
	}

}