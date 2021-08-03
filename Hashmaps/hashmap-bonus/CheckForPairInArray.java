/*############################################################################
				      Check for pairs in the array

	You are given a N-sized array of integers and a value k. In the given 
	array you have to find whether this array can be divided into pairs such 
	that the sum of every pair is divisible by k.
	Constraints:
		1<=Number of elements of array<=1000

	Sample Input:
		8 
		1 5 0 4 4 3 7 0
		8

	Sample Output:
		true

	Explanation:
		We can divide array into (1, 7), (5, 3), (4, 4) and (0,0). Sum of 
		all of these pairs is a multiple of 8.


					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class CheckForPairInArray{

	// public static boolean ispairexist(int[] arr, int n, int k) {
	// 	// failed at the case of 0,0,0,0,0 and devid3ed by 4;
	// 	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	// 	// maping arr array so i can use the frequency to calculate the pair sum. 
	// 	for(int i = 0; i<arr.length;i++){

	// 		if(map.get(arr[i]%k)==null){
	// 			map.put(arr[i]%k, 1);
	// 		}else map.put(arr[i]%k,map.get(arr[i]%k)+1);
	// 	}
	// 	System.out.println(map.entrySet());
	// 	for(int key:map.keySet()){
	// 		if(key==0) continue;
	// 		if(k%2==0 && k==key*2 && map.get(key)%2==1) return false;
	// 		if(map.get(key)!=(map.get(k-key))) {
	// 			// System.out.println(map.get(key)+" "+map.get(k-key));
	// 			return false;
	// 		}
			
	// 	}

	// 	return true;
	// }

	// public static boolean ispairexist(int[] arr, int n, int k) {
	// 	// it failled at 2,0,2 when devid by 2;
	// 	if(k==0) return false;
	// 	// i have to seperatly store zeroos and complete divisible by k.
	// 	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	// 	// maping arr array so i can use the frequency to calculate the pair sum. 
	// 	for(int i = 0; i<arr.length;i++){
	// 		if(arr[i]%k==0){
	// 			if(arr[i] != 0 && map.get(k)==null){
	// 				map.put(k, 1);
	// 			}else if(arr[i] != 0) map.put(k,map.get(k)+1);
	// 			else if(map.get(0)==null) map.put(0,1);
	// 			else map.put(0,map.get(0)+1);

	// 		}
	// 		else{
	// 			if(map.get(arr[i]%k)==null){
	// 				map.put(arr[i]%k, 1);
	// 			}else map.put(arr[i]%k,map.get(arr[i]%k)+1);

	// 		}
	// 	}
	// 	System.out.println(map.entrySet());
	// 	for(int key:map.keySet()){
	// 		if(key==k) continue;
	// 		if(key==0 && (map.get(k) == null || map.get(key)>map.get(k))) return false;
	// 		if(k%2==0 && k==key*2 && map.get(key)%2==1) return false;
	// 		if(key!=0&&map.get(key)!= map.get(k-key)) {
	// 			// System.out.println(map.get(key)+" "+map.get(k-key));
	// 			return false;
	// 		}
			
	// 	}

	// 	return true;
	// }

	public static boolean ispairexist(int[] arr, int n, int k) {
		// add some condition to solve that problem
		if(k==0) return false;
		// i have to seperatly store zeroos and complete divisible by k.
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		// maping arr array so i can use the frequency to calculate the pair sum. 
		for(int i = 0; i<arr.length;i++){
			if(arr[i]%k==0){
				if(arr[i] != 0 && map.get(k)==null){
					map.put(k, 1);
				}else if(arr[i] != 0) map.put(k,map.get(k)+1);
				else if(map.get(0)==null) map.put(0,1);
				else map.put(0,map.get(0)+1);

			}
			else{
				if(map.get(arr[i]%k)==null){
					map.put(arr[i]%k, 1);
				}else map.put(arr[i]%k,map.get(arr[i]%k)+1);

			}
		}
		System.out.println(map.entrySet());
		for(int key:map.keySet()){
			if(key==k || key == 0){
				if(map.get(k)==null) return false;
				if(map.get(0)==null){
					if(map.get(k)%2 == 1)return false;
					else continue;
				} 
				if(map.get(0)>map.get(k)) {
					return false;
				}else{
					if((map.get(k)-map.get(0))%2 ==1) return false;
					else continue;
				}
			} 
			else if(k%2==0 && k==key*2 && map.get(key)%2==1) return false;
			else if(key!=0&&map.get(key)!= map.get(k-key)) {
				// System.out.println(map.get(key)+" "+map.get(k-key));
				return false;
			}
			
		}

		return true;
	}
	public static void main(String[] args) {
		// int[] arr = {2,4,3,3,3,3,5,1};// divide by 4 ans = false
		int[] arr = {2,3,4,2,18,9,92,1,3,4,6,7,81,2,9,9,2,91,90,2,21,32,3,43}; // devid by 4 and ans true;
		// int[] arr = {1,3,4,4};
		// int[] arr = {4,0,4,0};
		System.out.println(ispairexist(arr,arr.length,4));
	}	
}
