/*############################################################################
				 Min Cost Path Problem

	An integer matrix of size (M x N) has been given. Find out the minimum 
	cost to reach from the cell (0, 0) to (M - 1, N - 1).
	From a cell (i, j), you can move in three directions:

		1. ((i + 1),  j) which is, "down"
		2. (i, (j + 1)) which is, "to the right"
		3. ((i+1), (j+1)) which is, "to the diagonal"

	The cost of a path is defined as the sum of each cell's values through 
	which the route passes.
				completed 1,2,3 true
			
#############################################################################*/
import java.util.Scanner;
import java.util.ArrayList;
public class MinCostPath{
// step 1  recursion
	public static int minCostPath(int[][] input, int m, int n) {
		if(m==input.length-1 && n==input[0].length-1) return input[m][n];
		int minCost = Integer.MAX_VALUE, temp =0;
		if(m<input.length-1) minCost = minCostPath(input,m+1,n);
		if(n<input[0].length-1) {
			temp = minCostPath(input,m,n+1);
			minCost = temp>minCost?minCost:temp;
		}
		if(n<input[0].length-1&&m<input.length-1) {
			temp = minCostPath(input,m+1,n+1);
			minCost = temp>minCost?minCost:temp;
		}
		return minCost+input[m][n];
	}

// // step 2 using memoization technique
	public static int minCostPathMemo(int[][] input, int [][] storage, int m, int n){
		// System.out.println(m+" "+n+" "+storage[m][n]);
		int maxM = input.length, maxN = input[0].length;
		if(storage[m][n]!=Integer.MAX_VALUE){
			// System.out.println("storage use");
			return storage[m][n];	
		} 

		if(m==maxM-1 && n==maxN-1) return input[m][n];
		int minCost = Integer.MAX_VALUE, temp =0;
		if(m<maxM-1) minCost = minCostPathMemo(input,storage,m+1,n);
		if(n<maxN-1) {
			temp = minCostPathMemo(input,storage,m,n+1);
			minCost = temp>minCost?minCost:temp;
		}
		if(n<maxN-1&&m<maxM-1) {
			temp = minCostPathMemo(input,storage,m+1,n+1);
			minCost = temp>minCost?minCost:temp;
		}
		storage[m][n] = minCost+input[m][n];
		return minCost+input[m][n];

	}
// step 3 iterative dp
	public static int minCostPathIterDP(int[][] input){
		if(input.length<=0) return 0;
		int maxM = input.length-1, maxN = input[0].length-1;
		if(maxM==0) return input[maxM][maxN];

		// variables will be used to find the min cost.
		int m = maxM-1, n = maxN, minCost = Integer.MAX_VALUE, temp =0;

		// variables to set m, n values.
		int diff = maxM-maxN, row=maxM-1, column=maxN-1, i=0, toggle = 0;

		// storage area
		int[][] storage = new int[maxM+1][maxN+1];
		storage[maxM][maxN] = input[maxM][maxN];


		while(m>=0&&n>=0){
			// System.out.println("ii");
			// caculating min cost and storing it to mattrix for m,n cell.
			minCost = Integer.MAX_VALUE;
			if(m<maxM) minCost = storage[m+1][n];
			if(n<maxN) {
				temp = storage[m][n+1];
				minCost = temp>minCost?minCost:temp;
			}
			if(n<maxN&&m<maxM) {
				temp = storage[m+1][n+1];
				minCost = temp>minCost?minCost:temp;
			}
			storage[m][n] = minCost+input[m][n];
			// setting m and n for next ittration.
			// here toggle can have three value 0,1,2
			if(toggle==0){
				if(m-n==diff){
					column = n-1;
					row = m-1;
					i=0;
					m=m-1;
					n = maxN;
				} else if(m-n < diff){
					m = maxM-i;
					n = column;
					i++;
				}else if(m-n>diff){
					n = maxN-i;
					m = row;
				}

			}
			if(toggle == 1 || m<0 && n>=0){
				if(m<=0) {
					m = maxM;
					n = column;
					i = 0;
					column--;
				}else m--;
				toggle = 1;
			}
			if(toggle == 2 || n<0 && m>=0){
				if(n<=0){
					n = maxN;
					m = row;
					i =0;
					row--;
				}else n--;
				toggle = 2;
			}

		}return storage[0][0];		
	}

	public static void main(String[] args){
		// int[][] input = {{3, 4, 1, 2},
		// 				{2, 1, 8, 9},
		// 				{4, 7, 8, 1}};
		int[][] input = {
			{9, 6, 0, 12, 90, 1},
			{2, 7, 8, 5, 78, 6},
			{1, 6, 0, 5, 10, -4}, 
			{9, 6, 2, -10, 7, 4},
			{10, -2, 0, 5, 5, 7}
		};
		// int[][] input = {
		// 	{9, 6, 0, 12},
		// 	{2, 7, 8, 5},
		// 	{1, 6, 0, 5}, 
		// 	{9, 6, 2, -10},
		// };
	// recursive approach
		System.out.println(minCostPath(input, 0,0));
	// memoization approach.
		int[][] storage = new int[input.length][input[0].length];
		for(int i = 0; i<input.length;i++){
			// System.out.println("in");
			for(int j = 0; j<input[0].length;j++) storage[i][j]=Integer.MAX_VALUE;
		}
		System.out.println(minCostPathMemo(input, storage, 0,0));
	// iterative dp appraoch
		System.out.println(minCostPathIterDP(input));	
	}


}