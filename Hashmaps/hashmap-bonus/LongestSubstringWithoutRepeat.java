/*############################################################################
				         Longest Substring without repeat

	You are given a string S that may or may not contain repeating characters.
	Your task is to find out the length of the longest substring of this given 
	string that does not contain any repeating characters.
	
	NOTE : You have to return the length.No need of printing it.
		
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class LongestSubstringWithoutRepeat{
	
	public static int longestSubstringLength(String str) {
		HashMap<Character,Boolean> map = new HashMap<>();
		int retVal = 0, temp =0, start = 0;
		for(int i =0; i<str.length();i++){
			if(map.containsKey(str.charAt(i))){
				while(start-1>=0 && !map.containsKey(str.charAt(start-1))){
					map.put(str.charAt(start-1),true);
					temp++;
					start--;
				}
				if(temp>retVal) retVal = temp;
				map.clear();
				start = i;
				i--;
				temp = 0;
			}else{
				map.put(str.charAt(i),true);
				temp++;
			}
		}
		// System.out.println(map.entrySet());
		// System.out.println(start);
		// System.out.println(retVal);
		while(start-1>=0 && !map.containsKey(str.charAt(start-1))){
			map.put(str.charAt(start-1),true);
			temp++;
			start--;
		}
		if(temp>retVal) retVal = temp;

		return retVal;
	}
	
	public static void main(String[] args) {
		String str = "ibnoffjytr";
		System.out.println(longestSubstringLength(str));

		
	}	
}
