 /*############################################################################
 							  0 1 Knapsack - Problem

	A thief robbing a store can carry a maximal weight of W into his knapsack. 
	There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What 
	would be the maximum value V, that the thief can steal?


			completed false
 #############################################################################*/ 
public class ZeroOneKnapsack{
	// recursion 
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		// System.out.println(maxWeight+" "+n);
		if(n<=0) return 0;
		if(weights[n-1]>maxWeight) return knapsack(weights,values,n-1,maxWeight);
		int maxValue = values[n-1]+knapsack(weights,values,n-1,maxWeight-weights[n-1]);
		maxValue = Math.max(maxValue,knapsack(weights,values,n-1,maxWeight));
		return maxValue;
	}
	// iterative dp bottom up approach

	public static int knapsackItterDP(int[] weights, int[] values, int n, int maxWeight){
		int storage[][] = new int[n+1][maxWeight+1];
		int maxValue = 0, w = maxWeight, max=0;
		n = weights.length-1;
		while(n>=0){
			// System.out.println(n+" "+w);
			if(weights[n]>w){
				storage[n][w] = storage[n+1][w];
				if(max<storage[n][w]) max = storage[n][w];
			} 
			else{
				maxValue = values[n]+storage[n+1][w-weights[n]];
				maxValue = Math.max(maxValue, storage[n+1][w]);
				storage[n][w] = maxValue;
				if(max<storage[n][w]) max = storage[n][w];
			}
			if(w>0) w--;
			else{
				w=maxWeight;
				n--;
			}

		}
		for(int[] arr:storage){
			for(int ele:arr) System.out.print(ele+" ");
			System.out.println();
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] weights  = {1,3,5};
		int[] values = {2,4,6};
		System.out.println(knapsack(weights,values,values.length, 6));
		System.out.println(knapsackItterDP(weights,values,values.length, 6));
	}
}