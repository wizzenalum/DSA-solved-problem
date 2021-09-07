/*############################################################################
  						 Coding Ninjas

  	Given a NxM matrix containing Uppercase English Alphabets only. Your 
  	task is to tell if there is a path in the given matrix which makes the 
  	sentence “CODINGNINJA” .
	There is a path from any cell to all its neighbouring cells. For a particular 
	cell, neighbouring cells are those cells that share an edge or a corner 
	with the cell.


		why back tracking is terrible thought.
		1. because to start we need to look for all first letter and then start from there.
			which increase time complexity M*N(for chosing starting letter)*(x)found first sam letter.

		but with graphs we can do this only by m*n time which will be taken.

					completed false;
  #############################################################################*/ 
import java.util.Arrays;
import java.util.HashMap;
public class CodingNinjas{
	public static boolean[][] visit;
	public static final int[][] direction = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

	public static boolean makeWord(String[] graph, int row,int col,String str,int index){
		if(index==str.length()) return true;
		if(row>=graph.length || col >= graph[0].length()|| row<0|| col<0) return false;
		if(str.charAt(index)!=graph[row].charAt(col)) return false;
		if(visit[row][col]) return false;
		visit[row][col] = true;
		for (int[] dir : direction) {
			if(makeWord(graph, row+dir[0], col+dir[1], str,index+1)) return true;
		}
		visit[row][col] = false;
		return false;
	}
	public static int solve(String[] graph , int n, int m){
	// in this method i will use given graph and choose first all letters then try to make complete word.
		for(int i = 0; i<n;i++){
			for(int j = 0; j<m;j++){
				if(graph[i].charAt(j) == 'C'){   // here searching for first word
					visit = new boolean[graph.length][graph[0].length()];
					if(makeWord(graph,i,j, "CODINGNINJA",0)) return 1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// System.out.println("print");
		String[] graph = {
			"CANAA",
			"IOAII",
			"DDIND",
			"AJINS",
			"XINNG"
		};
		System.out.println(solve(graph,graph.length,graph[0].length()));

	}
}