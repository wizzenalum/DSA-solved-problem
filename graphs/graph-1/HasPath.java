/*############################################################################
					 Has Path?
	Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), 
	check if there exists any path between them or not. Print true if the path 
	exists and false otherwise.

	Note:

		1. V is the number of vertices present in graph G and vertices are 
		numbered from 0 to V-1. 
		2. E is the number of edges present in graph G.

					completed true;
#############################################################################*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class HasPath{

	public static HashMap<Integer,Boolean> visitMap = new HashMap<>();

	public static boolean depthFirstTraversalHasPath(int source, int key, int[][] graph){
		if(source==key) return true;
		if(visitMap.containsKey(source)) return false;
		visitMap.put(source,true);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]==1){
				if(depthFirstTraversalHasPath(i,key,graph)) return true;
			}
		}
		return false;
	}

	public static Queue<Integer> queue = new LinkedList<>();
	public static boolean bredthFirstTraversalHasPath(int source, int key, int[][] graph){
		if(source == key) return true;
		for(int i = 0;i<graph[source].length;i++){
			// System.out.println("for");
			if(graph[source][i]==1 && !visitMap.containsKey(i)){
				queue.add(i);
				visitMap.put(i,true);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()) return bredthFirstTraversalHasPath(queue.poll(), key, graph); 
		return false;
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
		System.out.println(depthFirstTraversalHasPath(0,1,graphAM));
		// System.out.println("bredth first traversal");
		System.out.println(bredthFirstTraversalHasPath(0,1,graphAM));

	}
}