
 /*############################################################################
 						 Smallest Super-Sequence

	 Given two strings S and T with lengths M and N. Find and return the length 
	 of their shortest 'Super Sequence'.
	 The shortest 'Super Sequence' of two strings is defined as the smallest 
	 string possible that will have both the given strings as its subsequences.
	Note :
		If the two strings do not have any common characters, then return the 
		sum of the lengths of the two strings. 

			completed true
			
 #############################################################################*/ 
public class SmallestSuperSequence{
	// recursion 

	public static int smallestSuperSequence(String str1, String str2,int i, int j) {
		// System.out.println(i+ " ,"+j);
		if(str1.length()<=i && str2.length()<=j){
			// System.out.println("r1   " + 0);
			return 0;
		}
		if(str1.length()<=i){
			// System.out.println("r2   " + (str2.length()-j));
			return str2.length()-j;
		}
		if(str2.length()<=j){
			// System.out.println("r3   " + (str1.length()-i));
			return str1.length()-i;
		}
		int min1 = smallestSuperSequence(str1,str2,i+1,j+1);
		int min2 = smallestSuperSequence(str1,str2,i,j+1);
		int min3 = smallestSuperSequence(str1,str2,i+1,j), min=0;
		if(str1.charAt(i)==str2.charAt(j)) min1+=1;
		else min1+=2;
		min2 = Math.min(min2,min3);
		min = Math.min(min1,min2+1);
		return min;
	}
	public static int smallestSuperSequenceItterDP(String str1, String str2) {
		int i=str1.length()-1, j=str2.length()-1;
		int min1=0,min2=0, min3=0, min=0;
		int[][] storage = new int[i+2][j+2];
		for(i = 0; i<str1.length();i++) storage[i][str2.length()] = str1.length()-i;
		for(j = 0; j<str2.length();j++) storage[str1.length()][j] = str2.length()-j;
		
		for(i=str1.length()-1;i>=0;i--){
			for(j=str2.length()-1;j>=0;j--){
				min1 = storage[i+1][j+1];
				min2 = storage[i][j+1];
				min3 = storage[i+1][j];
				if(str1.charAt(i)==str2.charAt(j)) min1+=1;
				else min1+=2;
				min2 = Math.min(min2,min3);
				min = Math.min(min1,min2+1);
				storage[i][j] = min;
			}
		} return storage[0][0];
	}
	
	public static void main(String[] args) {
		String str1 = "ab", str2 = "bd";
		System.out.println(smallestSuperSequence(str1,str2,0,0));		
		System.out.println(smallestSuperSequenceItterDP(str1,str2));		
	}
}