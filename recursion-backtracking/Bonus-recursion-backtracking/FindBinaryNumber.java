/*############################################################################
						   Find binary number

	You are given an integral value n, you have to find all n-digit binary 
	numbers such that the binary number must have more 1's than 0's for any 
	prefix of the number

				completed false;
#############################################################################*/	
import java.util.Arrays;
class FindBinaryNumber{

	public static boolean check(int[] arr){
		// System.out.println(Arrays.toString(arr));
		// correct cases 11011000, 111000, 1011001;
		// incorrect   1100100;

		int prefix1=0, count0=0, prefix = 0;
		
		for(int i = 0; i<arr.length;){
			if(arr[i] == 1) prefix1++;
			if(arr[i] == 0) count0++;
			if(count0>prefix1) return false;
			i++;
		}
		return true;
	}
	
	public static void printBinaryHelper(int[] arr, int index){
		// time (n*2^n) time complexity. space O(n)
		if(arr.length<=index){
			if(check(arr)){
				for(int ele:arr) System.out.print(ele);
				System.out.println();
			}
			return;
		}
		arr[index] = 1;
		printBinaryHelper(arr,index+1);
		arr[index] = 0;
		printBinaryHelper(arr,index+1);
	}
// in this function i will try to combine both check and printBinaryHelper function.
	public static void printBinaryHelper(int[] arr, int index,int count1, int count0){
		// time (2^n) time complexity. space O(n)
		if(arr.length<=index){
			if(check(arr)){
				for(int ele:arr) System.out.print(ele);
				System.out.println();
			}
			return;
		}
		arr[index] = 1;
		printBinaryHelper(arr,index+1,count1+1, count0);
		if(count1>=count0){
			arr[index] = 0;
			printBinaryHelper(arr,index+1,count1, count0+1);

		}
	}


	public static void printBinary(int n) {
		if(n<1) return;
		int[] arr = new int[n];

		// printBinaryHelper(arr,0);
		printBinaryHelper(arr,0,0,0);
	}
	public static void main(String[] args) {
		int n = 6;
		printBinary(n);
	}
}
// this is my output for n = 6;
// 111111  111111   111111
// 111110  111110   111110
// 111101  111101   111101
// 111100  111100   111100
// 111011  111011   111011
// 111010  111010   111010
// 111001  111001   111001
// 111000  111000   111000
// 110111  110111   110111
// 110110  110110   110110
// 110101  110101   110101
// 110011  110100   110100
// 110010  110011   110011
// 101111  110010   110010
// 101110  101111   110001
// 101101  101110   101111
// 101100  101101   101110
// 101011  101100   101101
// 101010  101011   101100
// 101010   101011
//           101010
//           101001
//           100111
//           100110
//           100101
//           100011



















