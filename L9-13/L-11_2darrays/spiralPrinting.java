import java.util.Arrays;
import java.util.Scanner;
public class spiralPrinting {

	public static void spiralPrint(int matrix[][]){
		int re = matrix.length-1;
		if(re<0) return;
		int ce = matrix[0].length-1,cs=0,rs=0; 
		int count = (re+1)*(ce+1), counter = 0;
		while(true){
			for(int i = cs; i<=ce;i++) {
				System.out.print(matrix[rs][i]+" ");
				counter++;
			}
			rs++;
			if(count==counter) return;
			for(int i = rs; i<=re;i++){
				System.out.print(matrix[i][ce]+" ");
				counter++;
			}
			ce--;
			if(count==counter) return;
			for(int i=ce; i>=cs;i--){
				System.out.print(matrix[re][i]+" ");
				counter++;
			}
			re--;
			if(count==counter) return;
			for(int i=re; i>=rs;i--){
				System.out.print(matrix[i][cs]+" ");
				counter++;
			}
			cs++;
			if(count==counter) return;
		
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
			spiralPrint(mat);
			System.out.println();
		}
	}

}