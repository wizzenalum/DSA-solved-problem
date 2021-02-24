import java.util.Arrays;
import java.util.Scanner;
public class pairSum{
/*############################################################################
	You have been given an integer array/list(ARR) and a number 'num'. 
	Find and return the total number of pairs in the array/list which sum to 'num'.
#############################################################################*/
//****bruit force solution O(n*n) *******************************************************	
	public static int pairSum(int arr[], int num) {
		int l=0;
    	for(int i=0;i<arr.length-1;i++){
    		// System.out.println(i+ " i");
			for(int j=i+1;j<arr.length;j++){
				// System.out.print(j+" j ");
				if(arr[i]+arr[j]==num) l++;
			}
		}
		return l;
    }
//****solution2 by sorting array O(nlogn) *********************************************************************
	//here we sort array then traverse sorted array from boht ends.
	// consider these cases in mind {1,2,2,2,2,2,3,4,5,5,5,5,6,7,8,8,8} where num=10,7,13. 
    public static int pairSum1(int arr[], int num) {
		Arrays.sort(arr);
		int len = arr.length,count=0;
		for (int i=0,j=len-1;i<j;) {
			if(arr[i]+arr[j]==num){
				if(arr[i]==arr[i+1]||arr[j]==arr[j-1]){
					int left=1,right=1;
					while(i<j&&(arr[i]==arr[i+1])){
						left++;
						i++;
					}while(i<j&&arr[j]==arr[j-1]){
						right++;
						j--;
					}
					if(arr[i]==arr[j]) count+=left*(left-1)/2;
					else count+= left*right;
					i++;
					j--;
				}else{
					i++;
					count++;
				}
			}else if(arr[i]+arr[j]>num) j--;
			else i++;			
		}return count;
    	
    }
	public static void main(String[] args){
		// int arr1[] = {1,2,2,2,2,2,3,4,5,5,5,5,6,7,8,8,8};
		int arr1[] = {5, 5};
		System.out.print(pairSum(arr1,9));

		}

}