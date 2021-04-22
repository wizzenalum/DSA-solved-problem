
 /*############################################################################
 							   Maximum Square Matrix With All Zeros
	Given an NxM matrix that contains only 0s and 1s, find out the size of the 
	maximum square sub-matrix with all 0s. 
	You need to return the size of the square matrix with all 0s.

			completed true
 #############################################################################*/ 
public class MaximumSquareMatrixWithZeros{
	// recursion 
	static class Pair{
		int max;
		int current;
		Pair(int m, int c){
			max = m;
			current = c;
		}
	}
	public static Pair findMaxSquareWithAllZeros(int[][] input,int i, int j){
    	if(i>= input.length||j>=input[0].length) return new Pair(0,0);
    	int current=0, max=0;
    	Pair pair1, pair2, pair3;
    	pair1 = findMaxSquareWithAllZeros(input,i+1,j);	
    	pair2 = findMaxSquareWithAllZeros(input,i,j+1);	
    	pair3 = findMaxSquareWithAllZeros(input,i+1,j+1);
    	if(input[i][j]==0){
    		current = 1+Math.min(pair1.current,Math.min(pair2.current,pair3.current));
	    	max = Math.max(Math.max(pair1.max,pair2.max),Math.max(pair3.max,current));
    	}else{
    		current = 0;
	    	max = Math.max(Math.max(pair1.max,pair2.max),pair3.max);
    	}
    	Pair pair = new Pair(max,current);
    	return pair;
	}
	public static int findMaxSquareWithAllZeros(int[][] input){	
    	return findMaxSquareWithAllZeros(input,0,0).max;
	}
	// iterative dp bottom up approach
	public static int findMaxSquareWithAllZerosItterDP(int[][] input){
		int count1 =0, count2 =0, count3 =0, count4 =0,max =0,tempMax =0;
		int[][] storage = new int[input.length+1][input[0].length+1];

		for(int i = input.length-1;i>=0;i--){
			for(int j = input[0].length-1; j>=0;j--){
				if(input[i][j]==1) tempMax = 0;
				else{
					count1 = storage[i+1][j];	
			    	count2 = storage[i][j+1];	
			    	count3 = storage[i+1][j+1];
					count4 = Math.min(count1,Math.min(count2,count3));
			    	tempMax = count4+1;
					// System.out.println("In " +tempMax+" "+count4);
				}
				if(tempMax>max) max = tempMax;
    			storage[i][j]=tempMax;
			}
		}
		// for(int[] arr:storage){
		// 	for(int ele:arr) System.out.print(ele+" ");
		// 	System.out.println();
		// }
		return max;
	}
	
	public static void main(String[] args) {
		// int[][] input  = {{0, 0, 0},
		// 				  {0, 0, 0},
		// 				  {1, 0, 0}};
		int[][] input  = {{1, 0, 0},
						  {0, 0, 0},
						  {0, 0, 0}};
		int value = 1000;
		// System.out.println(countWaysToMakeChange(denominations,value,0));
		System.out.println(findMaxSquareWithAllZeros(input));
		System.out.println(findMaxSquareWithAllZerosItterDP(input));
		
	}
}