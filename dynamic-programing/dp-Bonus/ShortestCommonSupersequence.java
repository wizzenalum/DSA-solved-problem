 /*############################################################################
 							 Shortest Common Supersequence

	You are given two strings string s1 and string s2, you have to find shortest 
	common supersequence of both of the strings. That is, you have to find the 
	smallest string which has both string s1 and string s2 as subsequences.

 #############################################################################*/
import java.util.Scanner;

public class ShortestCommonSupersequence{
	public static int shortestSupersequence(String s1, String s2, int i, int j){
		if(s1.length()<=i&&s2.length()<=j) return 0;
		if(s1.length()<=i) return s2.length()-j;
		if(s2.length()<=j) return s1.length()-i;

		int min1,min2,min3,min=0;
		min1 = shortestSupersequence(s1,s2,i+1,j+1);
		min3 = shortestSupersequence(s1,s2,i+1,j);
		min2 = shortestSupersequence(s1,s2,i,j+1);
		if(s1.charAt(i)!=s2.charAt(j)) min1 = min1+2;
		else min1 +=1;
		min = 1+Math.min(min2,min3);
		min = Math.min(min,min1);
		return min;
	}

	public static int shortestSupersequence(String s1, String s2){
		int[][] storage = new int[s1.length()+1][s2.length()+1];
		int i=0, j= 0,min1=0, min2=0, min3=0, min=0;
		for(i=0;i<=s1.length();i++) storage[i][s2.length()] = s1.length()-i;
		for(j=0;j<=s2.length();j++) storage[s1.length()][j] = s2.length()-j;
		for(i = s1.length()-1;i>=0;i--){
			for(j = s2.length()-1;j>=0;j--){
				min1 = storage[i+1][j+1];
				min3 = storage[i+1][j];;
				min2 = storage[i][j+1];;
				if(s1.charAt(i)!=s2.charAt(j)) min1 = min1+2;
				else min1 +=1;
				min = 1+Math.min(min2,min3);
				min = Math.min(min,min1);
				storage[i][j] = min;
			}

		}
		return storage[0][0];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// String s1 = scan.nextLine();
		// String s2 = scan.nextLine();
		String s1 = "gakfa", s2 = "kga";
		System.out.println(shortestSupersequence(s1,s2,0,0));
		System.out.println(shortestSupersequence(s1,s2));
		// System.out.println(s1+" "+s2);

	}
	
}