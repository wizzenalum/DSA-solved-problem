import java.util.Arrays;
import java.util.Scanner;
public class pairSum{
/*############################################################################
	You have been given an integer array/list(ARR) and a number 'num'. 
	Find and return the total number of pairs in the array/list which sum to 'num'.
#############################################################################*/
	public static int pairSum(int arr[], int x) {
		int l=0;
    	for(int i=0;i<arr.length-1;i++){
    		// System.out.println(i+ " i");
			for(int j=i+1;j<arr.length;j++){
				// System.out.print(j+" j ");
				if(arr[i]+arr[j]==x) l++;
			}
		}
		return l;
    }
	public static void main(String[] args){
		int arr1[] = {5, 5, 4,3, 4, 5, 4};

		System.out.print(pairSum(arr1,9));

		}

}