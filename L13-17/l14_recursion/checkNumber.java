import java.util.Arrays;
import java.util.Scanner;
public class checkNumber{
	public static boolean checkNumber(int input[], int x){
		if(input.length <=0) return false;
		if(input[0]==x) return true;
		int[] arr = new int[input.length-1];
		for(int i=0; i<input.length-1; i++) arr[i] = input[i+1];
		return false||checkNumber(arr,x);	
	}
	public static void main(String[] args){
		int[] arr = {3,4,5,6,3,2,3,58};
		System.out.print(checkNumber(arr,58));
	}
}