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
import java.util.ArrayList;
class Coordiante{
	int X;
	int Y;
	Coordiante(int i, int j){
		this.X = i;
		this.Y = j;
	}
}
public class RatMazeAllPath{


	public static void printPath(ArrayList<Coordiante> path,int n){
		if(path == null) return;
		int[][] maze = new int[n][n];

		// System.out.println(n);
		for(int i = 0; i<path.size(); i++){
			maze[path.get(i).X][path.get(i).Y]=1;
		}
		maze[n-1][n-1] = 1;

		for(int[] row:maze){
			for(int ele:row){
				System.out.print(ele+" ");
			} 
		}System.out.println();
	}

	public static boolean check(ArrayList<Coordiante> path,int index, int i, int j){
		if(path == null) return false;
		if(path.size()<=index) return false;
		if(path.get(index).X==i && path.get(index).Y == j) return true;
		return check(path, index+1,i,j);

	}

	public static void ratInAMazeHelper(int[][] maze, int i, int j, int pre,
										ArrayList<Coordiante> path ){
	// i,j are the current position of the rat and pre is previos turn taken by the rat;
		// System.out.println(i+" "+j);
		int len = maze.length;
		if(check(path,0,i,j))return;
		if(i>=len||j>=len||i<0||j<0) return;
		if(i==len-1&&j==len-1){
			printPath(path,maze.length);
			return;	
		} 
		// right, down, up, left steps taken as they find out to be failed;
		if(maze[i][j]==0) return;
		path.add(new Coordiante(i,j));
		if(pre != 4) ratInAMazeHelper(maze, i,j+1,1,path);
		if(pre != 3) ratInAMazeHelper(maze, i+1,j,2,path);
		if(pre != 2) ratInAMazeHelper(maze, i-1,j,3,path);
		if(pre != 1) ratInAMazeHelper(maze, i,j-1,4,path);
		path.remove(path.size()-1);
	}
	public static void ratInAMaze(int maze[][]){
		ArrayList<Coordiante> path = new ArrayList<>();
		ratInAMazeHelper(maze,0,0,0,path);
	}

	public static void main(String[] args) {
		// int[][] maze = {{1, 0, 1},
		// 				{1, 1, 1},
		// 				{1, 1, 1}};
			// int[][] maze = {{1, 0, 1},
			// 				{1, 1, 0},
			// 				{1, 0, 1}};
		int[][] maze = {{1,1},{1,1}};
		ratInAMaze(maze);
	}
}