/*############################################################################
						   Find binary number

	You are given an integral value n, you have to find all n-digit binary 
	numbers such that the binary number must have more 1's than 0's for any 
	prefix of the number

				completed false;
#############################################################################*/	

class FindBinaryNumber{

	public static void printBinaryHelper(int[] arr, int index, int sum){
		if(arr.length<=index){
			if(sum>=arr.length/2){
				for(int ele:arr) System.out.print(ele);
				System.out.println();
			}
			return;
		}
		arr[index] = 1;
		printBinaryHelper(arr,index+1,sum+1);
		arr[index] = 0;
		printBinaryHelper(arr,index+1,sum);
	}
				
	public static void printBinary(int n) {
		if(n<1) return;
		int[] arr = new int[n];
		arr[0] = 1;
		printBinaryHelper(arr,1,1);
	}
	public static void main(String[] args) {
		int n = 6;
		printBinary(n);
	}
}
// this is my output for n = 6;
// 												111111
// 												111110
// 												111101
// 												111100
// 												111011
// 												111010
// 												111001
// 												111000
// 												110111
// 												110110
// 												110101
// 												110100
// 												110011
// 												110010
// 												110001
// 												101111
// 												101110
// 												101101
// 												101100
// 												101011
// 												101010
// 												101001
// 												100111
// 												100110
// 												100101
// 												100011



// 111111
// 111110
// 111101
// 111100
// 111011
// 111010
// 111001
// 111000
// 110111
// 110110
// 110101
// 110100
// 110011
// 110010
// 101111
// 101110
// 101101
// 101100
// 101011
// 101010												