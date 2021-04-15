/*############################################################################
							   Reverse Number

	You are given an integer N, you have to find the reverse of this integer N.
	Value of N should lie in the range [-100000000, 100000000]

		Sample Input:
			-4683
		
		Sample Output:
			-3864



				completed true;

#############################################################################*/
public class reverseNumber{
// method 1	but failed at 102, 1003, because loose info of zeros
	// public static int reverseInteger(int num) {
	// 	if(num<10&&num>-10) return num;
	// 	int leftnum = num;
	// 	int divideFactor = 1;
	// 	while(leftnum>=10||leftnum<=-10){
	// 		leftnum /=10;
	// 		divideFactor *=10;
	// 	}
	// 	leftnum = num/divideFactor;
	// 	int reversed = reverseInteger(num%divideFactor);
	// 	num = reversed*10+leftnum;
	// 	return num;
	// }
// method 1	with little tweaks 
	public static int reverseInteger(int num) {
		if(num<10&&num>-10) return num;
		int rightDigit = num;
		int multiplire = 1;
		int reversed = reverseInteger(num/10);
		while(rightDigit>=10||rightDigit<=-10){
			rightDigit /=10;
			multiplire *=10;
		}
		rightDigit = num%10;

		num = reversed+rightDigit*multiplire;
		return num;
	}
// method 2 elemenate the while loop 
	// here i will return the reversed number and a multiplire in a arr;
	public static void reverseIntegerHelper(int num, int[] arr) {
		if(num<10&&num>-10){
			arr[1] = 1;
			arr[0] = num;
			return;	
		}
		int rightDigit = num%10;
		reverseIntegerHelper(num/10,arr);
		arr[1]*=10;
		arr[0] = arr[0]+rightDigit*arr[1];	
	}
	public static int reverseInteger1(int num) {
		int[] arr = new int[2];
		reverseIntegerHelper(num,arr);
		return arr[0];
	}
	public static void main(String[] args) {
		int n = -102;
	//method 1
		// System.out.println(reverseInteger(n));
		// System.out.println(n%10);
	//method 2 eleminate the while loop;
		System.out.println(reverseInteger1(n));



	}
}