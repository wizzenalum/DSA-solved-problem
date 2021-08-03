/*############################################################################
				  Extract Unique characters

	Given a string S, you need to remove all the duplicates. That means, 
	the output string should contain each character only once. The respective 
	order of characters should remain same, as in the input string.

					completed true
					
#############################################################################*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class ExtractUniqueCharacter{
	public static String uniqueChar(String str){
		HashMap<Character,Boolean> map = new HashMap<Character,Boolean>();
		String output = "";
		for(int i = 0; i<str.length();i++){
			char temp = str.charAt(i);
			if(!map.containsKey(temp)){
				output = output+temp;
				map.put(temp, true);
			}
		}
		return output;
		

	}

	 
	public static void main(String[] args) {
		String str = "lkagakgagjakjglakjgaljgagjakgjalkjgkal";
		System.out.println(uniqueChar(str));
	}	
}
