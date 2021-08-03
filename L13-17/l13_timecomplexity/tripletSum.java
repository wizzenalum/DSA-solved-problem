import java.util.Arrays;
import java.util.Scanner;
public class tripletSum{
/*############################################################################
	You have been given a random integer array/list(ARR) and a number X. 
	Find and return the triplet(s) in the array/list which sum to X.
#############################################################################*/
//****solution1 O(n*n*n) *********************************************************************

	public static int tripletSum(int arr[], int x) {
		int l=0;
    	for(int i=0;i<arr.length-2;i++){
    		// System.out.println(i+ " i");
			for(int j=i+1;j<arr.length-1;j++){
				// System.out.print(j+" j ");
				for( int k=j+1;k<arr.length;k++){
				// System.out.print(k);
					if(arr[i]+arr[j]+arr[k]==x){
						l++;
						// System.out.println(l);
					}		
				}

			}
		}return l;
    }
//****solution2 sorted array with pairsum O(n*n) *********************************************************************
	public static int pairSum(int arr[],int start, int num) {
	// return the possible pairs in the array those have sum = num.

		int len = arr.length,count=0;
		for (int i=start,j=len-1;i<j;) {
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
    public static int tripletSum1(int[] arr, int num) {
    	int count =0,tempNum=num;
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			tempNum=num-arr[i];
			count +=pairSum(arr,i+1,tempNum);
			tempNum=num;
		}
		return count;
	}
	public static void main(String[] args){
		int arr1[] = {5, 5, 4, 4, 5};
		System.out.print(tripletSum1(arr1,13));
		}


}