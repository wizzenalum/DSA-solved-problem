import java.util.Arrays;
import java.util.Scanner;
public class binaryMat{

	public static void printMat(int[][] mat){
		int m = mat.length, n = mat[0].length;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++){
				if(mat[i][j] ==2) mat[i][j]--;
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
	}
	
	public static void turntoOne(int[][] mat, int row, int column){
		for(int i=0; i<mat.length; i++){
			if(mat[i][column] ==0) mat[i][column] = 2;
		}
		for(int i=0; i<mat[0].length;i++){
			if(mat[row][i]==0) mat[row][i] = 2;
		}
	}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int m=scan.nextInt();
		int n = scan.nextInt();
		int[][] mat = new int[m][n];
		for(int i=0; i<m;i++) for(int j=0; j<n;j++) mat[i][j] = scan.nextInt();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if(mat[i][j]==1){
					turntoOne(mat,i,j);
				}
			}
		}
		printMat(mat);
	
	}

}