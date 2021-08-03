/*############################################################################
				          Find all anagrams

	You have been given a string STR and a non-empty string PTR. Your task 
	is to find all the starting indices of PTR’s anagram in STR.
	An anagram of a string is another string which contains the same 
	characters and is obtained by rearranging the characters.
	For example: ‘SILENT’ and ‘LISTEN’ are anagrams of each other. ‘ABA’ 
	and ‘ABB’ are not anagram because we can’t convert ‘ABA’ to ‘ABB’ by 
	rearranging the characters of particular strings.
		
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class FindAllAnagrams{
	 public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
	 	ArrayList<Integer> indecesList = new ArrayList<>();
	 	HashMap<Character,Integer> map = new HashMap<>();// map the character of ptr string with frequancy.
	 	int strLen = str.length(), ptrLen = ptr.length();
	 	// map the ptr to the map;
	 	for(int i =0; i<ptrLen;i++){
	 		if(!map.containsKey(ptr.charAt(i))){
	 			map.put(ptr.charAt(i),1);
	 		}else{
	 			map.put(ptr.charAt(i),map.get(ptr.charAt(i))+1);
	 		}
	 	}
	 	System.out.println(map.entrySet());
	 	int start = 0;
	 	HashMap<Character,Integer> map2 = new HashMap<>();
	 	// map2 maps the character of str string with frequancy. which will be compared later.
	 	for(int i =0;i<strLen;i++){
	 		System.out.print(i);
	 		if(map.containsKey(str.charAt(i))){    // when character present in ptr then we will map it.
	 			System.out.print("  maping "+ str.charAt(i) );
	 			if(!map2.containsKey(str.charAt(i))){
		 			map2.put(str.charAt(i),1);
		 		}else{
		 			map2.put(str.charAt(i),map2.get(str.charAt(i))+1);
		 		}
		 	}
		 	if(!map.containsKey(str.charAt(i))){  // when character is not present in ptr.
	 			System.out.print("  not present "+ str.charAt(i) );
		 		map2.clear();
		 		start = i+1;
		 	}
		 	if(i-start == ptrLen-1){		// comparing map1 and map2
	 			System.out.print("  compare time "+ str.charAt(i) );
		 		boolean check=true;
		 		if(map.size()==map2.size()){  
			 		for(char ele: map.keySet()){
			 			if(map2.get(ele)==null || map2.get(ele)!=map.get(ele)) check = false;
			 		}
			 		if(check) indecesList.add(start);
		 		}		 		
	 			if(map2.get(str.charAt(start))>1) map2.put(str.charAt(start),map2.get(str.charAt(start))-1);
	 			else map2.remove(str.charAt(start));
	 			start++;	 		
		 	}
		 	System.out.println();
	 	}
	 	return indecesList;
    }
	
	public static void main(String[] args) {
		String str = "CBAEBABACD";
		String ptr = "ABC";
		System.out.println(findAnagramsIndices(str,str.length(), ptr, ptr.length()));

		
	}	
}
