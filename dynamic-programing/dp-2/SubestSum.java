/*############################################################################
 							 Subset Sum

	You are given a set of N integers. You have to return true if there exists 
	a subset that sum up to K, otherwise return false.
	
				completed true
 #############################################################################*/ 
 public class SubestSum{
 	// recursion
 	 static boolean isSubsetPresent(int[] arr, int n, int sum) {
 	 	if(sum==0) return true;
 	 	if(n<=0) return false;
 	 	boolean temp = isSubsetPresent(arr,n-1,sum);
 	 	temp = temp||isSubsetPresent(arr,n-1,sum-arr[n-1]);
 	 	return temp;
 	 }
 	 //memoization
 	 static boolean isSubsetPresentMemo(int[] arr, int n, int sum, int[][] storage) {
 	 	if(sum==0) return true;
 	 	if(n<=0||sum<0) return false;
	 	if(storage[n-1][sum]!=-1){
	 		if(storage[n-1][sum] == 1) return true;
	 		else return false;
	 	}
 	 	boolean temp = isSubsetPresentMemo(arr,n-1,sum,storage);
 	 	temp = temp||isSubsetPresentMemo(arr,n-1,sum-arr[n-1],storage);

 		if(temp) storage[n-1][sum] = 1;
 		else storage[n][sum]=0;
	 	
 	 	return temp;
 	 }
 	 //itterative dp.
 	 static boolean isSubsetPresentItterDP(int[] arr, int n, int sum) {
 	 	boolean[][] storage = new boolean[arr.length+1][sum+1];
 	 	int i=0, j=0;
 	 	boolean temp=false;
 	 	for(i=arr.length;i>=0;i--) storage[i][0]=true;

 	 	for(i=arr.length-1;i>=0;i--){
 			for(j = 1;j<storage[0].length;j++){
 				// System.out.println(i+" "+j);
 				temp = storage[i+1][j];
 				if(j-arr[i]>0) temp = temp||storage[i+1][j-arr[i]];
 				else if(j-arr[i]==0) temp = true;
 				storage[i][j] = temp;
 			}
 		}


 	// 	for(boolean[] arr1:storage){
		// 	for(boolean ele:arr1){
		// 		if(ele)System.out.print(" ");
		// 		System.out.print(ele+" ");
		// 	} 
		// 	System.out.println();
		// }

		return storage[0][storage[0].length-1];
    }
 
    public static void main(String[] args) {
    	int[] arr = {1,3,4,5,10};
    	int sum = 21;
    	// System.out.println(isSubsetPresent(arr,arr.length,sum));
    	int[][] storage = new int[arr.length+1][sum+1];
    	for(int i =0; i<storage.length;i++){
	    	for(int j =0; j<storage[0].length;j++) storage[i][j] = -1;

    	}
    	System.out.println(isSubsetPresentMemo(arr,arr.length,sum,storage));
 	//  	Boolean[][] storage1 = new Boolean[arr.length+1][sum+1];
 	//  	for(Boolean[] arr1:storage1){
		// 	for(Boolean ele:arr1) System.out.print(ele+" ");
		// 	System.out.println();
		// }
    	System.out.println(isSubsetPresentItterDP(arr,arr.length,sum));
    }
 }