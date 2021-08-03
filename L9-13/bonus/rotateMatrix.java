import java.util.Arrays;
import java.util.Scanner;
public class rotateMatrix{

	public static void printmat(int[][] mat){
		for(int[] a:mat){
			System.out.println(Arrays.toString(a));
		}
	}
	
	public static void rotate(int input[][]){
		int n = input.length-1;
		for(int i=0;i<=n/2;i++){
			for(int j=i;j<=n-1-i;j++){
				int swap = input[i][j];
				input[i][j] = input[j][n-i];
				input[j][n-i] = input[n-i][n-j];
				input[n-i][n-j] = input[n-j][i];
				input[n-j][i] = swap;
			}
		}
	}
	public static void main(String[] args){
		int[][] mat = {	{00,01,02},
						{10,11,12},
						{20,21,22}};
		rotate(mat);
		printmat(mat);

	}

}