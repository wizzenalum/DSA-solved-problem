/*############################################################################
	You have made a smartphone app and want to set its price such that the 
	profit earned is maximised. There are certain buyers who will buy your 
	app only if their budget is greater than or equal to your price.
	You will be provided with a list of size N having budgets of buyers and 
	you need to return the maximum profit that you can earn.
	Lets say you decide that price of your app is Rs. 
	x and there are N number of buyers. So maximum profit you can earn is :
		 m * x
	where m is total number of buyers whose budget is greater than or equal to x.
			Input format :
				Line 1 : N (No. of buyers)
				Line 2 : Budget of buyers (separated by space)
			Output Format :
				 Maximum profit
			Constraints :
				1 <= N <= 10^6
			Sample Input 1 :
				4
				30 20 53 14
			Sample Output 1 :
				60
			Sample Output 1 Explanation :
				Price of your app should be Rs. 20 or Rs. 30. 
				For both prices, you can get the profit Rs. 60.
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
public class maxProfitableApp{

	public static void mergeSort(int[] arr){
		Arrays.sort(arr);
	}
	
	public static int maximumProfit(int budget[]) {
		int maxProfit=0;
		int len = budget.length;
		mergeSort(budget);
		for(int i=0;i<len;i++){
			int maxTemp = budget[i]*(len-i);
			if(maxProfit<maxTemp) maxProfit = maxTemp;			
			// System.out.println(Arrays.toString(budget)+" "+i+" "+maxProfit);
		}
		return maxProfit;
	
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		// int[] arr = new int[n];
		// for(int i=0; i<n;i++) arr[i]=scan.nextInt();
		int[] arr = {14, 20, 30, 53};
		System.out.print(maximumProfit(arr));

	
	}

}