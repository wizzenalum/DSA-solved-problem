/*############################################################################
							  Find ln(N!)

	You are given a number N and you have to find ln(N!) that is log value of 
	N factorial. Here, ln denotes log with base e.

				completed true;

#############################################################################*/
public class FindlnfactN{
	public static double lnfactHelper(int N) {
		if(N==1) return 0;
		double pre = lnfactHelper(N-1);
		return Math.log(N)+pre;
	}
	public static long lnfact(int N) {
		return (long)lnfactHelper(N);
	}
	public static void main(String[] args) {
		System.out.println(lnfact(100));
		double x = 0;
		for(int i = 1; i<100;i++){
			x+=Math.log(i);
		}	
		System.out.println(x);
	}
}