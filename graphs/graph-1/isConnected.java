/*############################################################################
					 isConnected?

	Given an undirected graph G(V,E), check if the graph G is connected 
	graph or not.

		1. V is the number of vertices present in graph G and vertices are 
			numbered from 0 to V-1. 
		2. E is the number of edges present in graph G.
					completed true;
#############################################################################*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class isConnected{

	public static HashMap<Integer,Boolean> visitMap = new HashMap<>();

	public static void isConnectedDFTHelper(int source, int[][] graph){
		if(visitMap.containsKey(source)) return;
		// System.out.println(source);
		visitMap.put(source,true);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]==1) isConnectedDFTHelper(i,graph);
		}
	}
	public static boolean isConnectedDFT(int[][] graph){
		visitMap.clear();
		isConnectedDFTHelper(0,graph);
		for(int i = 0;i<graph.length;i++){
			if(!visitMap.containsKey(i)) return false;
		}
		return true;
	}

	public static Queue<Integer> queue = new LinkedList<>();
	public static void isConnectedBFTHelper(int source, int[][] graph){
		// System.out.println("in  "+ source);
		for(int i = 0;i<graph[source].length;i++){
			// System.out.println("for");
			if(graph[source][i]==1 && !visitMap.containsKey(i)){
				// System.out.println(i);
				queue.add(i);
				visitMap.put(i,true);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()) isConnectedBFTHelper(queue.poll(),graph); 
	}

	public static boolean isConnectedBFT(int[][] graph){
		// System.out.println("in  "+ source);
		visitMap.clear();
		isConnectedBFTHelper(0,graph);
		for(int i = 0;i<graph.length;i++){
			// System.out.println("for");
			if(!visitMap.containsKey(i)) return false;
		}
		return true;
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
		System.out.println(isConnectedDFT(graphAM));
		// System.out.println("bredth first traversal");
		System.out.println(isConnectedBFT(graphAM));

	}
}