/*############################################################################
						  Print all possible strings

	You are given a binary string containing '?' at some of its positions, 
	you have to find all the possible binary strings that can be formed by 
	replacing '?' by either '0' or '1'.

	Sample Input:
		110?01?1

	Sample Output:
		11000101
		11000111
		11010101
		11010111

				completed true;
#############################################################################*/	

class PrintAllPosibleString{

	public static void printAllHelper(String str, int index){
		if(str.length()<=index){
			System.out.println(str);
			return;
		}
		if(str.charAt(index)=='?'){
			String start = str.substring(0,index);
			String end = str.substring(index+1);
			printAllHelper(start+0+end,index+1);
			printAllHelper(start+1+end,index+1);
		}else printAllHelper(str,index+1);
	}
		
	public static void printAllPossibleStrings(String str) {
		printAllHelper(str,0);
	}
	public static void main(String[] args) {
		String str = "?100?111";
		printAllPossibleStrings(str);
	}
}