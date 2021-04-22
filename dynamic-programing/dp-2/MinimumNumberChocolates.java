/*############################################################################
 							  Minimum Number of Chocolates

	Miss. Noor Rashid is a teacher. She wants to give some chocolates to the 
	students in her class. All the students sit in a line, and each of them 
	has a score according to performance. Noor wants to give at least one 
	chocolate to each student. She distributes chocolates to them such that 
	If two students sit next to each other, then the one with the higher 
	score must get more chocolates. Miss. Noor wants to save money, so she 
	wants to minimize the total number of chocolates.
	
				completed true
				
 #############################################################################*/ 
 import java.util.Arrays;
 // bruit force solution with dp. 
 public class MinimumNumberChocolates{
 	// recursion
 	 public static int getMin(int arr[], int N){
       int[] dp = new int[arr.length];
       dp[0]=1;
       int chocolates=0;

       for(int i =1; i<arr.length;i++){
       	if(arr[i-1]<arr[i]) dp[i] = dp[i-1]+1;
       	if(arr[i-1]>=arr[i]){
       		dp[i] = 1;
       		int j=i-1;
       		while(j>=0 && dp[j]==dp[j+1]){
       			dp[j]++;
       			j--;
       		}
       	}
       }
       for(int count:dp) chocolates+=count;
       System.out.println(Arrays.toString(dp));
       return chocolates;

    }
    // dinamic programing...
    public static int getMin1(int arr[], int N){
       int[] dp = new int[arr.length];
       dp[0]=1;
       int chocolates=0;

       for(int i =1; i<arr.length;i++){
       	if(arr[i-1]<arr[i]) dp[i] = dp[i-1]+1;
       	if(arr[i-1]>=arr[i]){
       		dp[i] = 1;
       	}
       }
        for(int i =arr.length-2; i>=0;i--){
       	if(arr[i]<arr[i+1]) continue;
       	if(arr[i]>=arr[i+1]){
       		if(dp[i]<=dp[i+1]) dp[i] = dp[i+1]+1;
       	}
       }
       for(int count:dp) chocolates+=count;
       System.out.println(Arrays.toString(dp));
       return chocolates;

    }

 	 
    public static void main(String[] args) {
    	// int[] arr = {10,20,30}; // increasing order.
    	// int[] arr = {30,20,10}; // decreasing order.
    	// int[] arr = {10, 20, 40, 30, 10}; // increasing decreasing;
    	// int[] arr = {10, 20, 40, 40, 30, 10}; // increasing decreasing;
    	int[] arr = {40,30,20,40,40,30,20,10,40}; // random order.

    	// System.out.println(getMin(arr,arr.length));
    	System.out.println(getMin1(arr,arr.length));


    }
 }