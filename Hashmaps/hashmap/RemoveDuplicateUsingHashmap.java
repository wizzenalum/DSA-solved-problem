/*############################################################################
				  remove duplicate from array.
					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class RemoveDuplicateUsingHashmap{

	public static ArrayList<Integer> removeDuplicate(int[] arr){
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();

		ArrayList<Integer> copyArr = new ArrayList<Integer>(arr.length);
		for(int i = 0; i<arr.length;i++){
			if(map.get(arr[i])==null){
				copyArr.add(arr[i]);
				map.put(arr[i], true);
			}
		}
		return copyArr;
	}
	
	 
	public static void main(String[] args) {
		int[] arr = {2,1,2,3,4,3,2,1,2,3,4,3,2,1};

		System.out.println(removeDuplicate(arr));
	}	
}
