/*############################################################################
				     Pair Sum to 0
	Given a random integer array A of size N. Find and print the count of 
	pair of elements in the array which sum up to 0.
	Note: Array A can contain duplicate elements as well.

	Constraints :
		0 <= N <= 10^4
		Time Limit: 1 sec

	Sample Input 1:
		5
		2 1 -2 2 3

	Sample Output 1:
		2



			
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class PairSumToZero{
	public static int PairSum(int[] input, int size) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		// maping input array so i can use the frequency to calculate the pair sum. 
		for(int i = 0; i<input.length;i++){
			if(map.get(input[i])==null){
				map.put(input[i], 1);
			}else map.put(input[i],map.get(input[i])+1);
		}

		// two numbers sum can only be zero if they are negative and postive or both are zero.
		Set<Integer> keys = map.keySet();
		int pairCount =0;
		for(int key: keys){
			// System.out.println(key);
			if(key==0){
				if(map.get(0)>1){
					pairCount+= (map.get(0)*(map.get(0)-1))/2;
				}
			}
			if(key>0){
				if(map.containsKey(-1*key)){
					pairCount += map.get(key)*map.get(-1*key);
				}
			}
		}
		return pairCount;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,1,-2,2,3,0, 0, 0,0,-9,9,9,9,9,-9};
		System.out.println(PairSum(arr,arr.length));
	}	
}
