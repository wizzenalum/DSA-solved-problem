public class secondLargest{
	//****second largest in array *********************************************************************
    public static int secondLargestElement(int[] arr) {
    	int secondLargest = Integer.MIN_VALUE, largest=Integer.MAX_VALUE;
    	for(int i=0;i<2 && arr.length>1;i++){
    		secondLargest = Integer.MIN_VALUE;
    		for(int j=0;j<arr.length;j++){
    			if(secondLargest<arr[j] && arr[j]<largest){
    				secondLargest = arr[j];
    			}
    		}largest = secondLargest;
    	}return secondLargest;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,30,15,0,0,55,0,0,0,5,2,3,0,8};
        System.out.println(secondLargestElement(arr));
        
    }
}