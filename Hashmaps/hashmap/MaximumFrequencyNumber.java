/*############################################################################
				   Maximum Frequency Number
	You are given an array of integers that contain numbers in random order. 
	Write a program to find and return the number which occurs the maximum 
	times in the given input.
	If two or more elements contend for the maximum frequency, return the 
	element which occurs in the array first.emove duplicate from array.
			
					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class MaximumFrequencyNumber{

	 public static int maxFrequencyNumber(int[] arr){
	 	// it return the maximum frequency element 
	 	// but it failed to send first maximum frequency element as following case.

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

		int maxfreq = 0, value = 0;
		for(int i = 0; i<arr.length;i++){
			if(map.get(arr[i])==null){
				map.put(arr[i], 1);
			}else map.put(arr[i],map.get(arr[i])+1);
			if(map.get(arr[i])>maxfreq){
				value = arr[i];
				maxfreq = map.get(arr[i]);
			}
		}
		System.out.println(map.entrySet());
		return value;
	}

	public static int maxFrequencyNumber1(int[] arr){
		// it return the maximum frequency element 
	 	// but this return first occured max frequency element.
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

		ArrayList<Integer> list = new ArrayList<>(arr.length);

		int maxfreq = 0, value = 0;
		for(int i = 0; i<arr.length;i++){
			if(map.get(arr[i])==null){
				map.put(arr[i], 1);
				list.add(arr[i]);
			}else map.put(arr[i],map.get(arr[i])+1);
		}
		for(int i = 0; i<list.size();i++){
			if(maxfreq<map.get(list.get(i))){
				maxfreq = map.get(list.get(i));
				value = list.get(i);
			}
		}
		System.out.println(map.entrySet());
		return value;
	}
	
	 
	public static void main(String[] args) {
		// int[] arr = {2,1,2,3,4,3,2,1,2,3,4,3,2,1};
		int[] arr = {1,2,2,1};
		System.out.println(maxFrequencyNumber(arr));
		System.out.println(maxFrequencyNumber1(arr));
	}	
}
