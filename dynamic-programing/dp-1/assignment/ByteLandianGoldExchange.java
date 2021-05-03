/*############################################################################
						    Byte Landian

	Byteland has a very strange monetary system.
	Each Bytelandian gold coin has an integer number written on it. A coin n can 
	be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers 
	are all rounded down (the banks have to make a profit).
	You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. 
	But you can not buy Bytelandian coins.
	You have one gold coin. What is the maximum amount of American dollars you can 
	get for it?
		Constraints :
			0 <= n <= 10 ^ 9
			Time Limit: 1 sec

		Sample Input 1 :
			12

		Sample Output 1 :
			13

		Explanation of Sample Output 1 :
			You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
 

				completed 1,2,3 true  4 false
			
#############################################################################*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class ByteLandianGoldExchange{
// step 1  recursion
	public static int bytelandian(int n) {
		if(n<4) return n;
		int maxCoin = bytelandian(n/2)+bytelandian(n/3)+bytelandian(n/4);
		return n>maxCoin?n:maxCoin;
	}
// step 2 using memoization technique
	public static int bytelandianMemo(int n, int[] arr){
		if(n<4) return n;
		if(arr[n]!=0) return arr[n];
		int maxCoin = bytelandian(n/2)+bytelandian(n/3)+bytelandian(n/4);
		arr[n] = n>maxCoin?n:maxCoin;
		return arr[n];

	}
// step 3 iterative dp
	public static int bytelandianIterDP(int n){
		if(n<4) return n;
		int[] storage = new int[n+1];
		for(int i = 0;i<4;i++) storage[i] = i;
		int i = 4, maxCoin=0;
		while(i<=n){
			maxCoin = storage[i/2]+storage[i/3]+storage[i/4];
			maxCoin = i>maxCoin?i:maxCoin;
			storage[i] = maxCoin;
			i++;
		}
		return storage[n];	
	}
// last solution can't solve problem for long value because array can't store more 
	public static long bytelandianIterDP2(long n){
		// not working giving heap size exceeded;
		if(n<4) return n;
		long unitStorage = Integer.MAX_VALUE/10l;
		long totalUnit = (n/unitStorage)+1l;
		long[][] storage = new long[(int)unitStorage][(int)totalUnit];
		for(int i = 0;i<4;i++) storage[0][i] = i;
		long i = 4, maxCoin=0;
		while(i<=n){
			long first = storage[(int)((i/2l)/unitStorage)][(int)((i/2l)%unitStorage)];
			long second = storage[(int)((i/3l)/unitStorage)][(int)((i/3l)%unitStorage)];
			long third = storage[(int)((i/4l)/unitStorage)][(int)((i/4l)%unitStorage)];
			maxCoin = first+second+third;
			maxCoin = i>maxCoin?i:maxCoin;
			storage[(int)(i/unitStorage)][(int)(i%unitStorage)] = maxCoin;
			i++;
		}
		return storage[(int)(n/unitStorage)][(int)(n%unitStorage)];	
	}
// 4 iterative dp with hash map
	public static long bytelandianIterDpHash(long n, HashMap<Long, Long> memo) {
    	if(n<4) return n;
		for(Long i = 0l;i<4l;i++) memo.put(i,i);
		Long i = 4l, maxCoin=0l;
		while(i<=n){
			maxCoin = memo.get(i/2l)+memo.get(i/3l)+memo.get(i/4l);
			maxCoin = i>maxCoin?i:maxCoin;
			memo.put(i,maxCoin);
			i++;
		}
		return memo.get(n);	

	}

// some time iterative functions are not good too.
// as here reange is too much to we need to look in recursion.
// *********  problem was that i was trying to store all the value of n  even i never gonna
	// need them but by recursion that problem will also gona solve.

	public static long bytelandianIterDpHashRecur(long n, HashMap<Long, Long> memo) {
    	if(n<4) return n;
    	if(memo.containsKey(n)) return memo.get(n);
		long maxCoin = 	bytelandianIterDpHashRecur(n/2l,memo)+
						bytelandianIterDpHashRecur(n/3l,memo)+
						bytelandianIterDpHashRecur(n/4l,memo);
		maxCoin = maxCoin>n?maxCoin:n;
		memo.put(n,maxCoin);
		return maxCoin;	

	}


	public static void main(String[] args){
	// 	Scanner scan =  new Scanner(System.in);
		// int n = scan.nextInt();
		int n = 100000;
	// recursive approach
		// System.out.println(bytelandian(n));
	// memoization approach.
		int[] arr = new int[n+1];
		// System.out.println(bytelandianMemo(n,arr));
	// iterative d		// iterative dp for long input
		long m = 1232000000;
		// System.out.println(bytelandianIterDP2(m));
		HashMap<Long, Long> memo = new HashMap<Long,Long>();

		// System.out.println(bytelandianIterDpHash(m,memo));
		System.out.println(bytelandianIterDpHashRecur(m,memo));

	
	}


}