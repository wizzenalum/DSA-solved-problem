/*############################################################################
				   Longest Consecutive Sequence

	You are given an array of unique integers that contain numbers in random 
	order. You have to find the longest possible sequence of consecutive 
	numbers using the numbers from given array.
	You need to return the output array which contains starting and ending 
	element. If the length of the longest possible sequence is one, then 
	the output array must contain only single element.

	Note:

	1. Best solution takes O(n) time.
	2. If two sequences are of equal length, then return the sequence starting 
	with the number whose occurrence is earlier in the array.

	Constraints :
		0 <= n <= 10^6
		Time Limit: 1 sec

	Sample Input 1 :
		13
		2 12 9 16 10 5 3 20 25 11 1 8 6 

	Sample Output 1 :
		8 12 



					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class LongestConsecutiveSequence{
		public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();  // used to map the array with location
			HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>(); // used to verify is that used or not.
			// maping the arr in the map1
			for(int i = 0; i<arr.length;i++){
				map1.putIfAbsent(arr[i], i);
			}
			int start = 0, end = 0, temp = 0, preStart =0, preEnd = -1;

			for(int i:map1.keySet()){
				if(!map2.containsKey(i)){
					start = i;
					end = start;
					map2.put(i,1);
					// cheacking how many digits are consicutive before start.
					while(map1.containsKey(start-1)){
						start--;
						map2.put(start,1);
					}
					// cheacking how many digits are consicutive after end.
					while(map1.containsKey(end+1)){
						end++;
						map2.put(end,1);
					}
				}
				if(preEnd-preStart<end-start){
					preEnd = end;
					preStart = start;
				}else if(preEnd-preStart==end-start){
					if(map1.get(start)<map1.get(preStart)){
						preEnd = end;
						preStart = start;
					}
				}
				
			}
			output.add(preStart);
			if(preStart!=preEnd) output.add(preEnd);
			return output;


	    }
	 
	public static void main(String[] args) {
		int[] arr = {2,6,3,8,4,8,9,45,23,12};
		System.out.println(longestConsecutiveIncreasingSequence(arr).subList(0,2));
	}	
}
