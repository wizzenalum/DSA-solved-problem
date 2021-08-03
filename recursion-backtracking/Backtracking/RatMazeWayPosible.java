/*############################################################################
							Rat In A Maze way posible or not; 
	You are given a N*N maze with a rat placed at maze[0][0]. Find whether any 
	path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. 
	Rat can move in any direc­tion ( left, right, up and down).
	Value of every cell in the maze can either be 0 or 1. Cells with value 0 
	are blocked means rat can­not enter into those cells and those with value 
	1 are open.

				completed true;

#############################################################################*/
public class RatMazeWayPosible{



	// public static boolean ratInAMazeHelper(int[][] maze, int i, int j){
	// i,j are the current position of the rat
	// 	System.out.println(i+" "+j);
	// 	int len = maze.length;
	// 	if(i==len-1&&j==len-1) return true;
	// 	// right, down, up, left steps taken as they find out to be failed;
	// 	if(i>=len||j>=len) return false;
	// 	if(maze[i][j]==0) return false;
	// 	if(ratInAMazeHelper(maze, i,j+1)) return true;
	// 	if(ratInAMazeHelper(maze, i+1,j)) return true;
	// 	if(i>1 && ratInAMazeHelper(maze, i-1,j)) return true;
	// 	if(j>1 && ratInAMazeHelper(maze, i,j-1)) return true;
	// 	return false;
	// }
	// work well for first maze but in second maze i stuck in loop by calling same cell from where i cam from.
	public static boolean ratInAMazeHelper(int[][] maze, int i, int j, int pre){
	// i,j are the current position of the rat and pre is previos turn taken by the rat;
		int len = maze.length;
		if(i>=len||j>=len||i<0||j<0) return false;
		System.out.println(i+" "+j);
		if(i==len-1&&j==len-1) return true;
		// right, down, up, left steps taken as they find out to be failed;
		if(maze[i][j]==0) return false;
		if(pre != 4 && ratInAMazeHelper(maze, i,j+1,1)) return true;
		if(pre != 3 && ratInAMazeHelper(maze, i+1,j,2)) return true;
		if(pre != 2 && ratInAMazeHelper(maze, i-1,j,3)) return true;
		if(pre != 1 && ratInAMazeHelper(maze, i,j-1,4)) return true;
		return false;
	}
	public static boolean ratInAMaze(int maze[][]){
		return ratInAMazeHelper(maze,0,0,0);
	}

	public static void main(String[] args) {
	// int[][] maze = {{1, 0, 1},
	// 				{1, 0, 1},
	// 				{1, 1, 1}};
		int[][] maze = {{1, 0, 1},
						{1, 1, 0},
						{1, 0, 1}};
	System.out.println(ratInAMaze(maze));


	}
}