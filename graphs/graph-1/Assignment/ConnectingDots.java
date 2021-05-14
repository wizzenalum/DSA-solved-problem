/*############################################################################
  						  Connecting Dots

	Gary has a board of size NxM. Each cell in the board is a coloured dot. 
	There exist only 26 colours denoted by uppercase Latin characters 
	(i.e. A,B,...,Z). Now Gary is getting bored and wants to play a game. 
	The key of this game is to find a cycle that contain dots of same colour. 
	Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only 
	if it meets the following condition:

	1. These k dots are different: if i ≠ j then di is different from dj.
	2. k is at least 4.
	3. All dots belong to the same colour.
	4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should 
	also be adjacent. Cells x and y are called adjacent if they share an edge.

	Since Gary is colour blind, he wants your help. Your task is to determine if 
	there exists a cycle on the board.

					completed true;
  #############################################################################*/ 
import java.util.Arrays;
import java.util.HashMap;
public class ConnectingDots{

	public static HashMap<String,Boolean> visited = new HashMap<>();
	public static String terminate;
	public static int isCyclePresent(String[] Graph, int i, int j,char color){
		if(visited.containsKey(terminate)){
			// System.out.println("terminated");
			return 0;
		}
		int n = Graph.length;
		int m = Graph[0].length();
		int count = -1, temp =-1 ;
		// int checkM = 0, checkN = 0;
		if(i-1>=0){// for upper line to the elements.
			if(Graph[i-1].charAt(j)==color&& !visited.containsKey((i-1)+""+j)) {
				visited.put(((i-1)+""+j),true);
				// System.out.println("turn up");
				temp = isCyclePresent(Graph,i-1,j,color);
				if(temp>count) count = temp+1;
				visited.remove(((i-1)+""+j),true);

			}
		}
		if(j+1<m){
			if(Graph[i].charAt(j+1)==color && !visited.containsKey(i+""+(j+1))) {
				visited.put((i+""+(j+1)),true);
				// System.out.println("turn right");
				temp = isCyclePresent(Graph,i,j+1,color);
				visited.remove((i+""+(j+1)),true);
				if(temp>count) count = temp+1;
			}
		}
		if(i+1<n){// for upper line to the elements.
			if(Graph[i+1].charAt(j)==color && !visited.containsKey((i+1)+""+j)) {
				visited.put((i+1)+""+j,true);
				// System.out.println("turn down");
				temp = isCyclePresent(Graph,i+1,j,color);
				visited.remove((i+1)+""+j,true);

				if(temp>count) count = temp+1;
			}
		}
		if(j-1>=0){
			if(Graph[i].charAt(j-1)==color && !visited.containsKey(i+""+(j-1))) {
				visited.put((i+""+(j-1)),true);
				// System.out.println("turn left");
				temp = isCyclePresent(Graph,i,j-1,color);
				if(temp>count) count = temp+1;
				visited.remove((i+""+(j-1)),true);

			}
		}

		// System.out.println("R2 "+count);
		return count;
	}
	public static int solve(String[] graph , int n, int m){
	// in this method i will use given graph and choose first all letters then try to make complete word.

		for(int i = 0; i<n;i++){
			for(int j = 0; j<m;j++){
				visited.clear();
				terminate = i+""+j;
				// System.out.println(i+" "+j);
				if(isCyclePresent(graph,i,j, graph[i].charAt(j))>=4) return 1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String[] graph = {	"AACA",
							"AACA",
							"ABAA"};
		// String[] graph = {	"AB",
		// 					"AA"};

		System.out.println(solve(graph,graph.length,graph[0].length()));

	}
}