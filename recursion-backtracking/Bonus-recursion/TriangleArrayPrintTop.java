/*############################################################################
						     Triangle Array

	Harshit gave an array to Aahad and asked to make a triangle and calculate 
	the topmost element of this array for each layer the element is the sum of 
	two number below them and last layer is array Ex array {1, 2, 3, 4} then 
	the triangle:

        20
      8   12
   3    5    7
1    2    3     4

the Last layer is an array and each element is the sum of two numbers below. 
Your task is to Print the top element of the tringle as the element is very 
large print answer modulo 1000000007

				completed true
#############################################################################*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class TriangleArrayPrintTop{
	
	public static void printTop(int[] arr, int size){
		if(size<=0) return;
		if(size==1) {
			System.out.println(arr[0]);
			return;
		}
		size = size-1;
		for(int i=0; i<size;i++){
			arr[i] = (arr[i]+arr[i+1])%1000000007;
		}
		printTop(arr,size);		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<size;i++) arr[i] = scan.nextInt();
		// int[] arr = {1,2,3,4,5};
		// int size = arr.length;
		printTop(arr,size);

	}
}