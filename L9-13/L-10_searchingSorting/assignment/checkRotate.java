public class checkRotate{
	//****check array rotation *********************************************************************
    public static int arrayRotateCheck(int[] arr){
    	for(int i=0;i<arr.length-1;i++){
    		if (arr[i+1]<arr[i]) return i+1;
    	}return 0;
    }
    public static void main(String[] args) {
    	int[] arr3 = {7,8,9,1,2,3,4};
		System.out.println(arrayRotateCheck(arr3));
    }
}