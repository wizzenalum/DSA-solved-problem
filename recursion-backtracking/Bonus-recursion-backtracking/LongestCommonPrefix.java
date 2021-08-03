/*############################################################################
						     Longest common prefix

	You are given n number of strings and you have to find the longest 
	common prefix in all those strings
		Sample Input:
			4
			Codingninjas
			Coding
			Coders
			Codezen

		Sample Output:
			Cod


				completed true;
#############################################################################*/	

class LongestCommonPrefix{

	public static int commonUpto(String str1, String str2, int index, int n){
		if(index>=str1.length()||index>=str1.length()||index>=n) return index; 
		if(str1.charAt(index)==str2.charAt(index)){
			return commonUpto(str1,str2,index+1,n);
		}return index;
	}
	
	public static int commonPrefix(String[] input,int index){
		if(input.length==index+1) return input[index].length();
		int commonPrefixLength = commonPrefix(input,index+1);
		return commonUpto(input[index],input[index+1],0,commonPrefixLength);


	}
	
	public static void answer(String input[]) {
		int len = commonPrefix(input,0);
		System.out.println(input[0].substring(0,len));
	}	
	public static void main(String[] args) {
		String[] input = {"Codingninjas","Coding", "Coders", "Codezen"};
		answer(input);

	}
}