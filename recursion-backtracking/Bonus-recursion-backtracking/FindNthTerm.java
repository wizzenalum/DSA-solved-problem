/*############################################################################
						 Find nth Term

	You are given an integer n and you have to print F(n)th term of the sequence if
	F(n)=(1)+(2 * 3)+(4 * 5 * 6)+...n
	Try to solve this problem using recursion.

	Constraints:
		The value of n lies between [0,10]

	Sample Input:
		3

	Sample Output:
		127

	Explanation:
		F(3)=1+(2*3)+(4*5*6)
		    =127

				completed true;
#############################################################################*/	

class FindNthTerm{
	public static long Fnth_term(int n) {
		if(n==0) return 0;
		long currentTerm =1;
		int count = (n*(n-1))/2;
		long previousTerm = Fnth_term(n-1);
		for(int i =count+1; i<=count+n;i++) currentTerm*=i;
		return previousTerm+currentTerm;
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println(Fnth_term(n));
	}
}