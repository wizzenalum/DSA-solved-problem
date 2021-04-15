/*############################################################################
						     Number of Ways

	You are given an array of n elements and a sum value, you have to calculate 
	the total number of ways to calculate the given sum using the elements of 
	the array by using only addition(+) and subtraction operator(-).

		Constraints:
			Value of n should lie between [1,15]

		Sample Input:
			5
			-1 9 8 -3 4
			5

		Sample Output:
			8

		Explanation:
			The ways to get 5 as sum are:
			(+)-3 (+)9 (+)-1 
			(+)-3 (+)8 
			(-)-3 (-)8 (+)9 (-)-1 
			(+)4 (-)-1 
			(+)4 (-)8 (+)9 
			(+)4 (-)-3 (+)8 (-)9 (+)-1 
			(-)4 (+)9 
			(-)4 (+)8 (-)-1 

				completed true;
#############################################################################*/	

class NumberOfWays{

	
	public static int numberOfWaysHelper(int[] input, int sum, int presum, int index,int count){
		if(index>=input.length){
			if(sum==presum) return count+1;
			return count;
		}
		int digit = input[index];
		if(digit!=0){
			count = numberOfWaysHelper(input,sum,presum+digit,index+1,count);
			count = numberOfWaysHelper(input,sum,presum-digit,index+1,count);
		}
		input[index] = 0;
		count = numberOfWaysHelper(input,sum,presum,index+1,count);
		input[index] = digit;
		return count;
	}
	
	
	public static int numberOfWays(int[] input, int sum) {
		return numberOfWaysHelper(input,sum,0,0,0);
	}	
	public static void main(String[] args) {
		int[] input = {-1, 9, 8, -3, 4};
		System.out.println(numberOfWays(input,5));

	}
}