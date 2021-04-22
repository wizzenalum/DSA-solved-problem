 /*############################################################################
 							  Ways To Make Coin Change

	For the given infinite supply of coins of each of denominations, 
	D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number 
	of ways W, in which you can make the change for Value V using coins of 
	denominations D.
	Return 0 if the change isn't possible.


			completed false
 #############################################################################*/ 
public class WayToMakeCoinChange{
	// recursion 
	public static int countWaysToMakeChange(int denominations[], int value,int index){
		if(index>=denominations.length) return 0;
		if(value == 0) return 1;
		if(value<0) return 0;
        if(denominations[index]>value) return countWaysToMakeChange(denominations,value,index+1);
        // i am just using current penny to make change. 
        int count1 = countWaysToMakeChange(denominations, value-denominations[index],index);
        // i am not using current penny to make change.
        int count2 = countWaysToMakeChange(denominations, value,index+1);
        // int count3 = countWaysToMakeChange(denominations, value-denominations[index],index+1);
        return count1+count2;

	}
	// iterative dp bottom up approach
	public static int countWaysToMakeChange(int denominations[], int value){
		int index = denominations.length-1, count=0;
		int[][] storage = new int[denominations.length+1][value+1];
		for(int i = 0; i<storage.length;i++) storage[i][0] = 1;
		for(int v = 1; v<=value;v++){
			for(index = denominations.length-1;index>=0;index--){
				if(denominations[index]>v) count = storage[index+1][v];
				else{
					count = storage[index][v-denominations[index]];
					count = count+storage[index+1][v];
				}
				storage[index][v] = count;
			}
		}
		// for(int[] arr:storage){
		// 	for(int ele:arr) System.out.print(ele+" ");
		// 	System.out.println();
		// }
		return storage[0][value];
	}
	public static void main(String[] args) {
		int[] denominations  = {1,3,5,2};
		int value = 1000;
		// System.out.println(countWaysToMakeChange(denominations,value,0));
		System.out.println(countWaysToMakeChange(denominations,value));
		
	}
}