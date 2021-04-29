/*############################################################################
				       Shifted strings

	You are given an N-sized array of strings, you have to make groups of 
	those strings in such a way that all the strings of a group are shifted 
	versions of each other.
	
	Two strings A and B are placed in the same group if:
		Length of A= Length of B
		A[i]=B[i]+k
		1 <= i <= Length of A or B  for a constant integer K

	Note: Order doesn't matter w.r.t to different groups, but it does matter 
	within a particular group(should be printed in same order as present in 
	the given array).

	Constraints:
		0<=N<=1000

	Sample Input:
		16
		asd bte ak dn a v b n qwer rxfs iuy poi iuy poi qwe asd

	Sample Output:
		a v b n
		qwe 
		qwer rxfs 
		ak dn 
		iuy iuy 
		asd bte asd 
		poi poi 

		
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

	class Value{
		String str;
		ArrayList<String> list;
		Value right;
		Value(String str){
			this.str = str;
			this.list = new ArrayList<>();
			this.list.add(str);
			this.right = null;
		}
	}
public class ShiftedStrings{
	public static void grouping(String[] arr, int n) {
		HashMap<Integer,Value> map  = new HashMap<Integer,Value>();
		Value value  = null, rootValue = null, temp = null;
		int key = 0;
		boolean stringIsNew = true, stringForSameGroup = true;
		for(String str:arr){
			key = str.length();
			if(!map.containsKey(key)){
				value = new Value(str);
				map.put(key,value);
			}
			else{
				rootValue = map.get(key);
				temp = rootValue;
				stringIsNew = true;
				while(temp!=null){
					stringForSameGroup = true;
					for(int i = 1; i<key;i++){
						if(temp.str.charAt(0)-str.charAt(0)!=temp.str.charAt(i)-str.charAt(i)){
							stringForSameGroup = false;
							break;
						}
					}
					if(stringForSameGroup){
						temp.list.add(str);
						stringIsNew = false;
						break;
					}
					temp = temp.right;
				}
				if(stringIsNew){
					value = new Value(str);
					value.right = rootValue.right;
					rootValue.right = value;
				}  

			}
		}
		// printing the all the group;
		for(int ele:map.keySet()){
			rootValue = map.get(ele);
			temp = rootValue;
			while(temp!=null){
				for(int i = 0; i<temp.list.size();i++){
					System.out.print(temp.list.get(i)+" ");
				}
				System.out.println();
				temp = temp.right;
			}
		}		
	}

	public static void main(String[] args) {
		String[] arr = {"asd ","bte", "ak", "dn", "a", "v", "b", 
						"n", "qwer", "rxfs", "iuy", "poi", "iuy",
						 "poi", "qwe", "asd", };
		grouping(arr,arr.length);

		
	}	
}
