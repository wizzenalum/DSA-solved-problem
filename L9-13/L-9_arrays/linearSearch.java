import java.util.Arrays;
import java.util.Scanner;
public class linearSearch{
	public static int linearSearch(int arr[], int x) {
		for(int i = 0;i<arr.length;i++){
			if(x == arr[i]) return i ;
		}
		return -1;
	}
  	public static void main(String[] args) {
  		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i=1;i<=t;i++){
			int n = scan.nextInt();
			int[] inarr = new int[n];
			for(int j=0;j<n;j++) inarr[j] = scan.nextInt();
			int x = scan.nextInt();
			System.out.println(linearSearch(inarr,x));
		}
  		
	}

}