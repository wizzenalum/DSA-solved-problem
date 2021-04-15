/*############################################################################
	// here i will calcuate the nth fibonacci number by dynamic programing
	concept by sotring data instead of recalculating it.


			 completed true
			 
#############################################################################*/
import java.util.ArrayList;
class nthFibonacciNumber{
// step 1 recursive solution
// old aproach is very slower.
	public static int fibNumber(int var){
		// time complexity O(2^n) space O(1)
		if(var==0) return 0;
		if(var==1) return 1;
		return fibNumber(var-1)+fibNumber(var-2);
	}
// step 2 memoization implementation of problem
// newe approach just reach the time O(n) but space inclrease O(n)	
	public static int fibHelper(ArrayList<Integer> storage, int num){

		if(storage.size()>num) return storage.get(num);
		int num1 = fibHelper(storage,num-1);
		int num2 = fibHelper(storage,num-2);
		storage.add(num1+num2);
		return storage.get(num);

	}

	public static int fibNumberDynamic(int var){

		ArrayList<Integer> storage = new ArrayList<>();
		storage.add(0);
		storage.add(1);
		return fibHelper(storage, var);
	}
	
// step 3  iterative dynamic programing

	public static int fibNumberIterDP(int var){
		// time O(n) and space O(1);
		// here i only need to store two number that storage is done by pre1, pre2;
		if(var<2) return var;
		int pre1 = 0;
		int pre2 = 1;
		int temp = 0;
		int i=2;
		while(i<=var){
			temp = pre1;
			pre1 = pre2;
			pre2 = pre2+temp;
			i++;
		}
		return pre2;
	}
	

	public static void main(String[] args) {
		int n  = 40;
	// simple recursion fibonacci
		System.out.println(fibNumber(n));
	// recursive way for dynamic programing 
		System.out.println(fibNumberDynamic(n));
	// iterative way of dynamic programing for finding the nth fib number;
		System.out.println(fibNumberIterDP(n));	


	}
}