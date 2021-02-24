import java.util.Arrays;
public class sort012{
	public static void swap(int[] arr, int i, int j){
        // it will swap the ith and jth element of the array
        int swap =  arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
	//****sort 0 1 2 *********************************************************************
    public static void sort012(int[] arr){
    	int len = arr.length,left = 0, right = len-1;
    	int p = 0;
    	while(p<=right){
    		if (arr[p]==0){
    			swap(arr,p,left);
    			if(arr[p]==1||p==left) p++;
    			left++;
    		}
    		else if(arr[p]==2){
    			swap(arr,p,right);
    			if(arr[p]==1||p==right) p++;
    			right--;
    		}else p++;
    	}
    }
   	public static void main(String[] args) {

   		int[] arr = {2,1,0,1,2,0};
   		sort012(arr);
   		System.out.print(Arrays.toString(arr));
   	}
}