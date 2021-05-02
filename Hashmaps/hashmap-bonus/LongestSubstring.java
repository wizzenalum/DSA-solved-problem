/*############################################################################
				           Longest Substring
	
	Given a string of lower case English letters ('a' to 'z') and a positive 
	number K, find the length longest substring of the given string containing 
	K distinct characters and if K is more than the number of distinct character 
	in the input string output -1.
	
	Note: you have output the length of the substring not the actual substring
		
					completed true
					
#############################################################################*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class LongestSubstring{
	 // public static int longestSubstringOfK(String str, int k){
	 // 	// failed at "BABACD" when k = 3 because i assumed B's ware consicutive for maitaining start.
	 // 	int strLen = str.length();
	 // 	int start = 0, length = 0, maxLength = -1, temp = 0;

	 // 	HashMap<Character,Integer> map = new HashMap<>();

	 // 	for(int i =0;i<strLen;i++){
	 // 		System.out.print(i+" ");
 	// 		if(!map.containsKey(str.charAt(i))){
	 // 			map.put(str.charAt(i),1);
	 // 		}else{
	 // 			map.put(str.charAt(i),map.get(str.charAt(i))+1);
	 // 		}
	 // 		length++;
	 // 		System.out.print(map.entrySet());
	 // 		if(map.size()==k){
	 // 			if(maxLength<length){
	 // 				maxLength = length;
	 // 				System.out.print("update max  "+maxLength);
	 // 			}
	 // 			if(i+1<strLen && str.charAt(i)==str.charAt(i+1)) continue;
	 // 			else{
	 // 				temp = start;
	 // 				length -= map.get(str.charAt(temp));
	 // 				// System.out.print(map.get(str.charAt(temp)));
	 // 				start+= map.get(str.charAt(temp));
	 // 				map.remove(str.charAt(temp));
	 // 				System.out.print("  start is "+start);
	 // 			}
	 // 		}

	 // 		System.out.println();
	 // 	}
	 // 	return maxLength;
  //   }

   //  public static int longestSubstringOfK(String str, int k){
   //  	//here i am using queue to maintaing the start.
   //  	//failed at str = "umuar";  // k = 2 and ans =3;
	 	// int strLen = str.length();
	 	// if(k == 1 && strLen>0) return 1;
	 	// if(k==0 || k==1) return -1;
	 	// int length = 0, maxLength = -1, temp = 0;
	 	// Queue<Character> queue = new LinkedList<Character>();
	 	// HashMap<Character,Integer> map = new HashMap<>();

	 	// for(int i =0;i<strLen;i++){
	 	// 	// System.out.print(i+" ");
 		// 	if(!map.containsKey(str.charAt(i))){
	 	// 		map.put(str.charAt(i),1);
		 // 		queue.add(str.charAt(i));
	 	// 	}else{
	 	// 		map.put(str.charAt(i),map.get(str.charAt(i))+1);
	 	// 	}
	 	// 	length++;
	 	// 	// System.out.print(map.entrySet());
	 	// 	if(map.size()==k){
	 	// 		if(maxLength<length){
	 	// 			maxLength = length;
	 	// 			// System.out.print("update max  "+maxLength);
	 	// 		}
	 	// 		if(i+1<strLen && str.charAt(i)==str.charAt(i+1)) continue;
	 	// 		else{
	 	// 			length -= map.get(queue.peek());
	 	// 			// System.out.print(map.get(str.charAt(temp)));
	 	// 			map.remove(queue.poll());
	 	// 		}
	 	// 	}

	 	// 	// System.out.println();
	 	// }
	 	// return maxLength;
   //  }
	// public static int longestSubstringOfK(String str, int k){
 //    	// here i again assmed consucative repetition 
//     //  it wrong because it dont maintain the substring property due to use to queue;
	// // so all queue itterations are wrong;
	//  	int strLen = str.length();
	//  	int length = 0, maxLength = -1, temp = 0;
	//  	Queue<Character> queue = new LinkedList<Character>();
	//  	HashMap<Character,Integer> map = new HashMap<>();

	//  	for(int i =0;i<strLen;i++){
	//  		// System.out.print(i+" ");
 // 			if(!map.containsKey(str.charAt(i))){
	//  			map.put(str.charAt(i),1);
	// 	 		queue.add(str.charAt(i));
	//  		}else{
	//  			map.put(str.charAt(i),map.get(str.charAt(i))+1);
	//  		}
	//  		length++;
	//  		// System.out.print(map.entrySet());
	//  		if(map.size()==k){
	//  			if(maxLength<length){
	//  				maxLength = length;
	//  				// System.out.print("update max  "+maxLength);
	//  			}
	//  			if(i+1<strLen && map.containsKey(str.charAt(i+1))) continue;
	//  			else{
	//  				length -= map.get(queue.peek());
	//  				// System.out.print(map.get(str.charAt(temp)));
	//  				map.remove(queue.poll());
	//  			}
	//  		}

	//  		// System.out.println();
	//  	}
	//  	return maxLength;
 //    }

	 public static int longestSubstringOfK(String str, int k){
	 	// failed at "BABACD" when k = 3 because i assumed B's ware consicutive for maitaining start.
	 	int strLen = str.length();
	 	int start = 0, length = 0, maxLength = -1;

	 	HashMap<Character,Integer> map = new HashMap<>();

	 	for(int i =0;i<strLen;i++){
	 		// System.out.print(i+" ");
 			if(!map.containsKey(str.charAt(i))){
	 			map.put(str.charAt(i),1);
	 		}else{
	 			map.put(str.charAt(i),map.get(str.charAt(i))+1);
	 		}
	 		length++;
	 		System.out.print(map.entrySet());
	 		if(map.size()==k){
	 			if(maxLength<length){
	 				maxLength = length;
	 				// System.out.print("update max  "+maxLength);
	 			}
	 			if(i+1<strLen && map.containsKey(str.charAt(i+1))) continue;
	 			else{
	 				while(map.size()==k){
		 				if(map.get(str.charAt(start))>1) map.put(str.charAt(start),map.get(str.charAt(start))-1);
		 				else map.remove(str.charAt(start));
		 				length--;
		 				// System.out.print(map.get(str.charAt(temp)));
		 				start++;
		 				// System.out.print("  start is "+start);

	 				}
	 			}
	 		}

	 		// System.out.println();
	 	}
	 	return maxLength;
    }
   
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int testCase = scan.nextInt();
		// for(int i = 0;i<testCase;i++){
		// 	int len = scan.nextInt();
		// 	int k = scan.nextInt();
		// 	String str = scan.next();
		// }
		String str = "umuaraaaaaaaaaaa";  // k = 2 and ans =3;
		int k = 2;
		System.out.println(longestSubstringOfK(str,k));
	}	
}
