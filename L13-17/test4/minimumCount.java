/*############################################################################
	Given an integer N, find and return the count of minimum numbers, 
	sum of whose squares is equal to N.
	That is, if N is 4, then we can represent it as : 
	{1^2 + 1^2 + 1^2 + 1^2} and {2^2}. Output will be 1, as 1 is the minimum 
	count of numbers required.
	Note : x^y represents x raise to the power y.
			Input Format :
				Integer N
			Output Format :
				Required minimum count
			Constraints :
				1 <= N <= 50
			Sample Input 1 :
				12
			Sample Output 1 :
				3
			Sample Output 1 Explanation :
				12 can be represented as :
				1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1
				1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 1^1 + 2^2
				1^1 + 1^1 + 1^1 + 1^1 + 2^2 + 2^2
				2^2 + 2^2 + 2^2
				As we can see, the output should be 3.
			Sample Input 2 :
				9
			Sample Output 2 :
				1
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class minimumCount{

	public static int minCount(int n){
		// System.out.println(n+ " ");
		if(n<0) return 0;
        if(n==1) return 1;
        int min =Integer.MAX_VALUE,i;
        for(i=1;i*i<=n;i++) if(i*i==n) return 1;
        for(i=1;i*i<n;i++){
        	// System.out.print("i" + i);
        	int temp =1+minCount(n-i*i);
            if(min>temp){
                min = temp;
            }
            
        }
        return min;
    }
    public static void main(String[] args) {
    	int n = 66;
    	System.out.print(minCount(n));		
	}

}