import java.util.Arrays;
import java.util.Scanner;
public class returnArraySum{
	public static int sum(int[] arr){
		int sum = 0;
		for(int i :arr) sum +=i;
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i=1;i<=t;i++){
			int n = scan.nextInt();
			int[] inarr = new int[n];
			for(int j=0;j<n;j++) inarr[j] = scan.nextInt();
			System.out.println(sum(inarr));
		}
	}

}