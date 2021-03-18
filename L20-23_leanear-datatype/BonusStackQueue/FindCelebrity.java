/*############################################################################
	There is a party of N people, out of which only one person is known 
	to everyone (known as the celebrity). That person may be present at 
	the party or maybe not. If that person is present he(she) doesn't 
	know anyone present at the party. We can only ask the question 
	"does A know B? “. Find the celebrity in a minimum number of questions.

	You will be given a square matrix M[][] where if an element of row i 
	and column j is set to 1 it means the ith person knows the jth person. 
	You need to complete the function which finds the celebrity if present 
	else returns -1.
#############################################################################*/

import java.util.*;

class FindCelebrity {
    public static int celebrity(int[][] arr, int n) {
    // bruit force solution and sking to many time.
    	int numberOfQuestionAsked = 0;
    	for(int i=0;i<n;i++){
    		int count =0;
    		for(int j=0;j<n;j++){
    			numberOfQuestionAsked++;
    			if(arr[i][j] == 1) break;
    			count++;
    		}
    		if(count == n){
    			int sum = 0;
    			for(int k = 0;k<n;k++){
    				numberOfQuestionAsked++;
    				sum += arr[k][i];
    			}
    			System.out.println(numberOfQuestionAsked);
    			if(sum+1==n) return i;
    		}
    	}
    	System.out.println(numberOfQuestionAsked);
    	return -1;
    }
    public static int celebrity1(int[][] arr, int n) {
    // solving this question by asking less question.
    	for(int i=0;i<n;i++){
    		int count =0;
    		for(int j=0;j<n;j++){
    			if(arr[i][j] == 1) break;
    			count++;
    		}
    		if(count == n){
    			int sum = 0;
    			for(int k = 0;k<n;k++){
    				sum += arr[k][i];
    			}if(sum+1==n) return i;
    		}
    	}
    	return -1;
    }

    public static void main(String[] args) {
    	int[][] mat = {
    					{0,1,0},
    					{0,0,0},
    					{0,1,0},
    					};
    	System.out.println(celebrity(mat,3));
    }
}