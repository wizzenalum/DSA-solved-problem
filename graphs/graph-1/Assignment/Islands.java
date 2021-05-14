/*############################################################################
					Islands
	An island is a small piece of land surrounded by water . A group of 
	islands is said to be connected if we can reach from any given island 
	to any other island in the same group . Given V islands (numbered from 
	0 to V-1) and E connections or edges between islands. Can you count the 
	number of connected groups of islands.

	we are given the Adjacency matrix and vertex.

					completed true;
#############################################################################*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class Islands{

	public static HashMap<Integer,Boolean> visitMap = new HashMap<>();

	public static void islandDFTHelper(int source, int[][] graph){
		if(visitMap.containsKey(source)) return;
		// System.out.println(source);
		visitMap.put(source,true);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]==1) islandDFTHelper(i,graph);
		}
	}
	public static int connectedIslandDFT(int[][] graph, int n){
		if(n<=0) return 0;
		if(n==1) return 1;
		visitMap.clear();
		int count=0;
		for(int i = 0;i<graph.length;i++){
			if(!visitMap.containsKey(i)){
				count++;
				islandDFTHelper(i,graph);
			}
		}
		return count;
	}

	public static Queue<Integer> queue = new LinkedList<>();
	public static void islandBFTHelper(int source, int[][] graph){
		// System.out.println("in  "+ source);
		for(int i = 0;i<graph[source].length;i++){
			// System.out.println("for");
			if(graph[source][i]==1 && !visitMap.containsKey(i)){
				queue.add(i);
				visitMap.put(i,true);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()) islandBFTHelper(queue.poll(),graph); 
	}

	public static int connectedIslandBFT(int[][] graph, int n){
		// System.out.println("in  "+ source);
		if(n<=0) return 0;
		if(n==1) return 1;
		int count = 0;
		visitMap.clear();
		for(int i = 0;i<graph.length;i++){
			// System.out.println("for");
			if(!visitMap.containsKey(i)){
				count++;
				visitMap.put(i,true);
				islandBFTHelper(i,graph);
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		int[][] graphAM = {	{0, 1, 1, 1, 0, 0},
							{1, 0, 1, 1, 0, 0},  
							{1, 1, 0, 0, 1, 0},
							{1, 1, 0, 0, 1, 0},  
							{0, 0, 1, 1, 0, 0}, 
							{0, 0, 0, 0, 0, 0}};
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		// int e = scan.nextInt();
		// int[][] graphAM = new int[n][n];
		// for(int i =0; i<e;i++){
		// 	int a = scan.nextInt();
		// 	int b = scan.nextInt();
		// 	graphAM[a][b] = 1;
		// 	graphAM[b][a] = 1;
		// }
		// int[][] graphAM = {{0,1},
		// 					{1,0}};
		System.out.println(connectedIslandDFT(graphAM, graphAM.length));
		System.out.println("bredth first traversal");
		System.out.println(connectedIslandBFT(graphAM, graphAM.length));

	}
}