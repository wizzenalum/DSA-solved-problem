/*############################################################################
						    Pairs with difference K
	You are given with an array of integers and an integer K. You have to 
	find and print the count of all such pairs which have difference K.
	
	Note: Take absolute difference between the elements of the array.


					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class PairsWithDifferenceK{
	public static int getPairsWithDifferenceK(int arr[], int k) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();  // used to map the array with frequncy
		// maping the arr in the map
		for(int i = 0; i<arr.length;i++){
			if(!map.containsKey(arr[i])) map.put(arr[i], 1);
			else map.replace(arr[i], map.get(arr[i])+1);
		}
		int count = 0;
		boolean check = false;
		// System.out.println(map.entrySet());
		int[] keyArr = new int[map.size()];
		int i =0;
		for(int key:map.keySet()){
			// System.out.println(key);
			keyArr[i] = key;
			i++;
		}
		// System.out.println(Arrays.toString(keyArr));
		for(int key: keyArr){
			// System.out.println(key);
			check = false;
			if(k==0){
				if(map.containsKey(key)){
					count += (map.get(key)*(map.get(key)-1))/2;
					check = true;
				}
			}
			else{
				if(map.containsKey(key-k)){
					count += map.get(key-k)*map.get(key);
					check = true;
				}
				if(map.containsKey(k+key)){
					count += map.get(key+k)*map.get(key);
					check = true;
				}
			}
			if(check) map.remove(key);
		}
		return count;
	}
	public static void main(String[] args) {
		int[] arr = {2,6,3,8,4,8,9,45,23,12};
		System.out.println(getPairsWithDifferenceK(arr,3));
	}	
}
