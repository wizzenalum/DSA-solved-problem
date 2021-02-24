import java.util.Arrays;
import java.util.Scanner;
public class wavePrinting {
	public static void wavePrint(int mat[][]){
		int n = mat.length, m = mat[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i%2==0) System.out.print(mat[j][i]+" ");
				else System.out.print(mat[n-1-j][i]+" ");

			}
		}

	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test = 0;test<t;test++){
			int n=scan.nextInt();
			int m = scan.nextInt();
			int[][] mat = new int[n][m];
			for(int i=0; i<n;i++) for(int j=0; j<m;j++) mat[i][j] = scan.nextInt();
			wavePrint(mat);
			System.out.println();
		}
	}

}