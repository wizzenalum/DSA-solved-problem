import java.util.Arrays;
public class pushZero{
	//****push zero to end *********************************************************************
 //    public static void pushZerosAtEnd(int[] arr) {
 //    	for (int i =0;i<arr.length;i++){
 //    		if(arr[i]!=0) continue;
 //    		for(int j=i+1;j<arr.length;j++){
 //    			if(arr[j]==0) continue;
 //    			int swap =  arr[j];
 //    			arr[j] = arr[i];
 //    			arr[i] = swap;
 //    			break;
 //    		}
	//     }
	// }
// above solution teking to much resoureses.
    public static void pushZerosAtEnd(int[] arr){
        int i,j;
	      for(i = 0,j = 0;j < arr.length;j++) {
			if(arr[j] != 0){	
	        arr[i] = arr[j];
	        i++;
	        }
	    }
	        for(int k = i;k < arr.length;k++)
	          arr[k] = 0;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,30,15,0,0,55,0,0,0,5,2,3,0,8};
		pushZero.pushZerosAtEnd(arr);
		System.out.print(Arrays.toString(arr));

	}
}