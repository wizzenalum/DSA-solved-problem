/*############################################################################
    You have been given a random integer array/list(ARR) of size N. 
    Write a function that rotates the given array/list by D elements(towards the left).
    Sample Input 1:
        1 2 3 4 5 6 7
    Sample Output 1:
        3 4 5 6 7 1 2
#############################################################################*/
import java.util.Arrays;

public class rotateArray{
     public static void swap(int[] arr, int i, int j){
        // it will swap the ith and jth element of the array
        int swap =  arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

//**** Solution1 time = O(n*n) space = O(1) *********************************************************************
	// here we are shifting each element one by one.
    public static void rotate(int[] arr, int d) {
    	for(int i=0; i<d;i++){
    		for(int j=0;j<arr.length-1;j++){
                swap(arr,j,j+1);
    		}
    	}
    }
//****Solution 2 time = O(n) space = O(n)*********************************************************************
    // we use an another array and where store first half and then shft whole array and add this half to back.
    public static void rotate1(int[] arr, int d){
        int len = arr.length;
        int[] firsthalf = new int[d];
        for(int i=0;i<len;i++){
            if(i<d) firsthalf[i]=arr[i];
            else {
                arr[i-d]=arr[i]; 
            }
        }
        for(int i=len-d;i<len;i++) arr[i]=firsthalf[i-len+d];

    }
//****Solution3 time= O(n) space = O(1) *********************************************************************

    public static void reverse(int[] arr, int i, int j){
        // it will reverse sub array of arr from i to j both including
        for(int k=i;k<=(i+j)/2;k++){
            swap(arr,k,j+i-k);
        }
    }
    

    public static void rotate2(int[] arr, int d){
        //it will rotate the arr by d elements.
        int len = arr.length;
        if(len ==0) return;
        reverse(arr,0,len-1);
        reverse(arr,0,len-d-1);
        reverse(arr,len-d,len-1);

    }
    public static void main(String[] args) {
        int[] arr = {1,2,30,15,0,0,55,0,0,0,5,2,3,0,8};
        rotate(arr,2);
        System.out.println(Arrays.toString(arr));

    }
}
