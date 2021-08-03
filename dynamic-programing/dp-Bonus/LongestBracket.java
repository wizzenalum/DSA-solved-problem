/*############################################################################
 							   Longest Bracket

    Bracket sequence is called regular, if parenthesis in the given 
    expression are balanced. You are given a string s, consisting of only 
    '(' and ')' characters. You need to find its longest substring which is 
    a regular bracket sequence. You have to find the number of such substrings 
    as well.
    Print first the length of output substring and then count of these. If 
    no such substring exists, print "0 1" (without quotes).

				completed false
 #############################################################################*/ 
 import java.util.Arrays;
 public class LongestBracket{
 	public static void countSubstring(String str){
        int freq = 0, maxLength = -1, count =0;
        int stack = 0;
        boolean check = false;
        for(int i = 0; i<str.length();i++){
            check = false;
            if(str.charAt(i)=='(') stack++;
            else if(str.charAt(i)==')'){
                if(stack>0){
                   stack--;
                   count+=2; 
                   check = true;
                }
                else count = 0;

            }
            if(count==maxLength&&check) freq++;
            if(count>maxLength){
                maxLength = count;
                freq = 1;
            }
        }
        if(maxLength == 0) System.out.println("0 1");
        System.out.println(maxLength+" "+freq);
    }

    public static void main(String[] args) {
    	String str = ")((())))(()())";
        countSubstring(str);
    }
 }