import java.util.Scanner;
public class boundarySum {

	public static void totalSum(int[][] mat) {
		int n = mat.length, bSum = 0, dSum=0, sum=0;
		for(int i=0; i<n; i++){
			bSum += mat[0][i]+mat[i][n-1]+mat[i][0]+mat[n-1][i];//sum of boundaries in
			dSum += mat[i][i]+mat[i][n-i-1];// sum of diagonals
		sum = bSum+dSum;
		sum -= 2*(mat[0][0]+mat[0][n-1]+mat[n-1][0]+mat[n-1][n-1]);
		if(n%2==1) sum = sum-mat[n/2][n/2];
	}
		System.out.println(sum);
}
	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		int t = scan.nextInt();
		for(int test=0; test<t;test++){
			int n=scan.nextInt();
			int[][] mat = new int[n][n];
			for(int i=0; i<n;i++) for(int j=0; j<n;j++) mat[i][j] = scan.nextInt();
			totalSum(mat);
		}
	}
}