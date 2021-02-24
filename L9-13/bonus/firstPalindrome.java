import java.util.Arrays;
import java.util.Scanner;
public class firstPalindrome{

	public static  int[] frequancy(String str){
		// it will create a frequancy array for given string.
		int[] freqArr = new int[256];
		for(int i=0; i<str.length();i++){
			freqArr[(int)str.charAt(i)]++;
		}return freqArr;
	}
	public static int checkPalindromPossibility(int[] arr){
		//if this function return -1 means palindrom is not possible
		// if return -2 then palindrom is possible and length is even.
		// if return other number then middle letter should be at that ascci value.
		int send = -2;
		for(int i=0; i<arr.length;i++){
			if(arr[i]%2==1){
				if(send==-2) send = i;
				else return -1;
			}
		}return send;
	}
	public static String nextPalindrome(String input) {
		int[] arr = frequancy(input);
		// System.out.println(Arrays.toString(arr));
		int middle = checkPalindromPossibility(arr);
		String firstHalf="",secondHalf="";
		if(middle==-1) return "";
		for(int i=0;i<arr.length;i++){

			while(arr[i]/2!=0){
				firstHalf +=(char)(i);
				secondHalf =(char)(i)+secondHalf;
				arr[i]-=2;
			}
		}
		if(middle==-2) return firstHalf+secondHalf;
		else return firstHalf+(char)middle+secondHalf;
	}
	public static void main(String[] args){
		Scaner scan = new Scanner(System.in);
		String str = scan.nextLine();
		// String str = "hollo";
		// System.out.print(nextPalindrome(str));	
		
	}

}