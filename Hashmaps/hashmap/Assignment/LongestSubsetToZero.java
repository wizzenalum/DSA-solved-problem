/*############################################################################
						     Longest subset zero sum

	Given an array consisting of positive and negative integers, find the 
	length of the longest subarray whose sum is zero.


					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class LongestSubsetToZero{
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();  // used to map the arrays coummulative sum with index
		// as we consicutivly move forward negative value agin reduce it if it become equal to any other conisucutive sum then
		// it will be certain that betweeen those indeces sum is zero. 
		int maxLength = 0, coummulativeSum=0;
		map.put(0,-1);
		for(int i = 0; i<arr.length;i++){
			coummulativeSum += arr[i];
			if(map.containsKey(coummulativeSum)){
				if(i-map.get(coummulativeSum)>maxLength){
					maxLength = i - map.get(coummulativeSum);
				}
			}else map.put(coummulativeSum,i);
		}
		
		return maxLength;
	}
	public static void main(String[] args) {
		int[] arr = { 95,-97,-387,-435,-5,-70,897,127,23,284};
		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
	}	
}
