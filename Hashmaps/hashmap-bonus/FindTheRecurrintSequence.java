/*############################################################################
				        Find the recurring sequence

	You are given the numerator and denominator of a fraction, you have to 
	find the recurring sequence of digits if exists when this fraction is 
	converted into decimal.
	
	Note: If there is no recurring sequence of digits then return an empty string.
		
					completed true
					
#############################################################################*/
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class FindTheRecurrintSequence{
	public static String recurr(int num, int den) {
		if(num%den==0) return "";
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		// maping the current num%den to (num*10)%den
		num = num%den;
		int temp = 0;
		while(num!=0){
			// System.out.println(num+" first");
			if(map.containsKey(num)){
				// System.out.println(map.entrySet());
				String str = "";
				temp = num;
				while(map.get(temp)!=num){
					str = str+(temp*10)/den;
					// System.out.println(str+"   second");
					temp = map.get(temp);
				} 
				str = str+ (temp*10)/den;
				return str;
			}
			temp = (num*10)%den;
			map.put(num,temp);
			num = temp;
		}
		return "";
	}
	
	public static void main(String[] args) {
		int num = 3;
		int den = 7;
		System.out.println(recurr(num,den));

		
	}	
}
