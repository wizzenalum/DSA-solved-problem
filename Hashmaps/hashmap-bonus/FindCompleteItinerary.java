/*############################################################################
				      Find complete itinerary

	You are given a list of input tickets which are not cyclic and there is 
	only one ticket from every given city except the final destination. You 
	have to find the complete itinerary in order using the given list.
	
	Constraints:
		0<=Number of tickets<=70

	Sample Input:
		6
		Jammu Manali Kashmir Jammu Delhi Chandigarh Amritsar Kashmir Manali Jaipur Chandigarh Amritsar

	Sample Output:
		Delhi -> Chandigarh
		Chandigarh -> Amritsar
		Amritsar -> Kashmir
		Kashmir -> Jammu
		Jammu -> Manali
		Manali -> Jaipur
		
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class FindCompleteItinerary{
	public static void itineary(HashMap<String, String> input) {
		// maping input HashMap with another hash map where destination to source or say reverse.
		HashMap<String,String> destToSource = new HashMap<String,String>();
		String start = null;
		for(String key:input.keySet()) destToSource.put(input.get(key),key);
		for(String key:input.keySet()){
			if(!destToSource.containsKey(key)){
				start = key;
				break;
			}
		}
		boolean check = true;
		while(check){
			if(input.containsKey(start)){
				System.out.println(start+" -> "+input.get(start));
				start = input.get(start);
			}
			else check = false;
		}
		
	}
	
	public static void main(String[] args) {

		HashMap<String,String> map= new HashMap<String,String>();
		map.put("d" ,"c" );
		map.put("c" ,"a" );
		map.put("a" ,"k" );
		map.put("k" ,"j" );
		itineary(map);

		
	}	
}
