/*############################################################################
		Given k, find the geometric sum i.e.

		1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 

		using recursion. answer should be upto 5 digits.
#############################################################################*/
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
public class geometricSum{
	public static double findGeometricSum(int k){
		if(k==0) return 1;
		return .5*findGeometricSum(k-1)+1;
	
	}
	public static void main(String[] args){
		int k = 2;
		DecimalFormat df = new DecimalFormat("#0.00000");
		System.out.printf(df.format(findGeometricSum(5)));
	}

}