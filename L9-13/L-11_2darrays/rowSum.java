import java.util.Scanner;
public class rowSum {
	public static void print(int [] arr){
		for(int a: arr) System.out.print(a+" ");
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test = 0; test<t;test++){
			int m=scan.nextInt();
			int n = scan.nextInt();
			int[][] arr2d = new int[m][n];
			for(int i=0; i<m;i++) for(int j=0; j<n;j++) arr2d[i][j] = scan.nextInt();
			int[] sum = new int[m];
			for(int i=0; i<m;i++){
				for(int j=0;j<n;j++) sum[i] += arr2d[i][j];
			}
			print(sum);
		}
	}
	

}