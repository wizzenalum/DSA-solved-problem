/*############################################################################
		You are given an integer n, you have to count all those natural 
		numbers from 1 to n whose all permutations is greater than or 
		equal to that number n.
#############################################################################*/
import java.util.*;

class CountTheNumber {
    public static int permutations(int n) {
    	// we are using recursion stack. but it only runs for 13624 times after than it shows stack full error.
    	if(n==1) return 1;
    	if(n%10==n) return 1+permutations(n-1);
    	int a = n%10, m = n/10;
    	while(m!=0){
    		if(a<m%10) return permutations(n-1);
    		a = m%10;
    		m = m/10;
    	}
    	return 1+permutations(n-1);  
    }
    public static int permutations1(int n) {
    	// method 2 to solve this problem we need to solve for 100000 so use itteratve stack;
    	int count =0;
    	while(n>0){
    		if(n%10==n) count++;  		
    		else{
    			int a = n%10,m=n/10;
    			boolean check = true;
    			while(m!=0){
    				if(a<m%10){
    					check = false;
    					break;	
    				} 
    				a=m%10;
    				m=m/10;
    			}
    			if(check) count++;
    		} n = n-1;
    	}
    	return count; 
    }
// method 2 with systemactic way;
    public static boolean isDigitsInIncreasingOrder(int n){
    	int a = n%10;
    	n=n/10;
		while(n!=0){
			if(a<n%10) return false; 
			a=n%10;
			n=n/10;
		}
		return true;
    }
    public static int permutations2(int n) {
    	int count = 0;
    	for(int i = n; i>0;i--){
    		if(isDigitsInIncreasingOrder(i)) count++;
    	}return count;
    }


    
    public static void main(String[] args) {
    	System.out.println(permutations2(136200));
    	System.out.println(permutations1(136200));
    	System.out.println(permutations(1362));
    	System.out.println(isDigitsInIncreasingOrder(555));
    }
}