/*############################################################################
							 Code: N Queens

	You are given N, and for a given N x N chessboard, find a way to place N 
	queens such that no queen can attack any other queen on the chess board. 
	A queen can be killed when it lies in the same row, or same column, or 
	the same diagonal of any of the other queens. You have to print all such 
	configurations.
	Sample Input 1:
		4

	Sample Output 1 :
		0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
		0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 



				completed true;

#############################################################################*/
public class PlaceNQueens{


	public static void printBoard(int[][] mat){
		for(int[] row:mat){
			for(int ele:row){
				System.out.print(ele+" ");
			}
			System.out.println(); 
		}System.out.println("\n");
	}

	public static boolean isQueensPlace(int[][] mat, int x, int y){
		int len = mat.length;
		if(len<=1) return true;
		int sum = 0;
		// checking for rowwise attack
		for(int i  = 0; i<len;i++){
			sum+=mat[x][i];
		}
		if(sum>0) return false;
		// checking for columnwise attack
		sum = 0;
		for(int i  = 0; i<len;i++){
			sum+=mat[i][y];
		}
		if(sum>0) return false;
		// checking for diagonal attack
		sum = mat[x][y];
		for(int i  = 1; i<len;i++){
			if(x-i>=0 && y-i>=0) sum+=mat[x-i][y-i];
			if(x-i>=0 && y+i<len) sum+=mat[x-i][y+i];
			if(x+i<len && y-i>=0) sum+=mat[x+i][y-i];
			if(x+i<len && y+i<len) sum+=mat[x+i][y+i];
		}
		if(sum>0) return false;
		return true;
	}
	public static void placeNQueensHelper(int[][] board, int i){
		if(board.length<=i){
			printBoard(board);
			return;
		} 
		int j = 0;
		for(j=0;j<board.length;j++){
			if(isQueensPlace(board,i,j)){
				board[i][j] = 1;
				placeNQueensHelper(board,i+1);
				board[i][j] = 0;
			}
		}
	}
	

	public static void placeNQueens(int n){
		int[][] board = new int[n][n];
		placeNQueensHelper(board,0);
	}

	public static void main(String[] args) {
			int[][] board = {{1, 0, 0},
							{0, 0, 0},
							{0, 0, 0}};
			placeNQueens(10);
		// System.out.pri++nt(isQueensPlace(board,1,2));
	}
}