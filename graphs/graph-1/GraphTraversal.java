/*############################################################################
					BFS and DFS traversal
	i will going to implement the both traversals one by one.
					completed true;
#############################################################################*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class GraphTraversal{

	public static HashMap<Integer,Boolean> visitMap = new HashMap<>();

	public static void depthFirstTraversalConnectedGraph(int source, int[][] graph){
		if(visitMap.containsKey(source)) return;
		System.out.println(source);
		visitMap.put(source,true);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]==1) depthFirstTraversalConnectedGraph(i,graph);
		}
	}
	public static void depthFirstTraversalDisconnectedGraph(int[][] graph){
		visitMap.clear();
		for(int i = 0;i<graph.length;i++){
			if(!visitMap.containsKey(i)) depthFirstTraversalConnectedGraph(i,graph);
		}
	}

	public static Queue<Integer> queue = new LinkedList<>();
	public static void bredthFirstTraversalConnectedGraph(int source, int[][] graph){
		// System.out.println("in  "+ source);
		for(int i = 0;i<graph[source].length;i++){
			// System.out.println("for");
			if(graph[source][i]==1 && !visitMap.containsKey(i)){
				System.out.println(i);
				queue.add(i);
				visitMap.put(i,true);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()) bredthFirstTraversalConnectedGraph(queue.poll(),graph); 
	}

	public static void bredthFirstTraversalDisconnectedGraph(int[][] graph){
		// System.out.println("in  "+ source);
		visitMap.clear();
		for(int i = 0;i<graph.length;i++){
			// System.out.println("for");
			if(!visitMap.containsKey(i)){
				System.out.println(i);
				visitMap.put(i,true);
				bredthFirstTraversalConnectedGraph(i,graph);
			}
		}
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
		depthFirstTraversalDisconnectedGraph(graphAM);
		System.out.println("bredth first traversal");
		bredthFirstTraversalDisconnectedGraph(graphAM);

	}
}