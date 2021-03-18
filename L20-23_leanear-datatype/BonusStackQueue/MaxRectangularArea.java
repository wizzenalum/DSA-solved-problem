import java.util.Scanner;
public class MaxRectangularArea {
	public static int MaxAreaForward(int[][] mat, int row, int column, int currentColumn){
		if(mat.length<1) return 0;
		int prevColumn =currentColumn, max = currentColumn, tempMax = 0;
		for(int i = row+1;i<mat.length;i++){
			currentColumn = 0;
			for(int j = column;column==0?j<prevColumn:j<=prevColumn;j++){
				if(mat[i][j] ==0) break;
				currentColumn++;
			}
			tempMax = currentColumn*(i-row+1);
			prevColumn = currentColumn;
			if(max<tempMax) max = tempMax;
			if(currentColumn==0) break;
		} return max;
	}



	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] mat = new int[m][n];
		for(int i = 0; i<m;i++){
			for(int j=0;j<n;j++){
				mat[i][j] = scan.nextInt();
			}
		}
		int max =0, tempMax = 0;
		for(int i =0; i<mat.length;i++){
			for(int j =0; j<mat[i].length;j++){
				int currentColumn = 0;
				for(int k=j; k<mat[i].length;k++){
					if(mat[i][k]==0) break;
					currentColumn++;
				}
				tempMax = MaxAreaForward(mat,i,j,currentColumn);
				if(tempMax>max) max = tempMax;

			}
		}
		System.out.println(max);
		// System.out.println(MaxAreaForward(mat,1,0,2));
		// for(int i = 0; i<m;i++){
		// 	for(int j=0;j<n;j++){
		// 		System.out.print(mat[i][j]+" ");
		// 	}System.out.println();
		// }
	}

}