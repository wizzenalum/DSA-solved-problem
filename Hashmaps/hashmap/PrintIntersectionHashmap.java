/*############################################################################
				    Print Intersection
	You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, 
	respectively. You need to print their intersection; An intersection for 
	this problem can be defined when both the arrays/lists contain a particular 
	value or to put it in other words, when there is a common value that exists 
	in both the arrays/lists.

	Note :Input arrays/lists can contain duplicate elements.

	The intersection elements printed would be in the order they appear in the 
	first sorted array/list(ARR1).
		
		Constraints :
				1 <= t <= 10^2
				0 <= N <= 10^6
				0 <= M <= 10^6
				Time Limit: 1 sec 

		Sample Input 1 :
				2
				6
				2 6 8 5 4 3
				4
				2 3 4 7 
				2
				10 10
				1
				10

		Sample Output 1 :
				2 3 4
				10


			
					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class PrintIntersectionHashmap{
	
	public static void intersection(int[] arr1, int[] arr2) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		// maping arr2 so i can use the frequency of this to compare with arr1 
		for(int i = 0; i<arr2.length;i++){
			if(map.get(arr2[i])==null){
				map.put(arr2[i], 1);
			}else map.put(arr2[i],map.get(arr2[i])+1);
		}
		Arrays.sort(arr1);
		for(int i = 0; i<arr1.length;i++){
			if(map.get(arr1[i])!=null){
				if(map.get(arr1[i])==1){
					map.remove(arr1[i]);
					System.out.print(arr1[i]+" ");
				}
				else{
					map.put(arr1[i],map.get(arr1[i])-1);
					System.out.print(arr1[i]+" ");

				}
			}
		}
	    
	}
	public static void main(String[] args) {
		int[] arr1 = {2,1,2,3,4,3,2,1,2,3,4,3,2,1};
		int[] arr2 = {1,2,2,1};
		intersection(arr1,arr2);
	}	
}
