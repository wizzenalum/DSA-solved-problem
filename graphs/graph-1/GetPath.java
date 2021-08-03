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
public class GetPath{

	public static HashMap<Integer,Integer> visitMap = new HashMap<>();

	public static boolean depthFirstTraversalGetPath(int source, int key, int[][] graph){
		if(source==key){ 
			System.out.print(source+" ");
			return true;
		}
		if(visitMap.containsKey(source)) return false;
		visitMap.put(source,1);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]==1){
				if(depthFirstTraversalGetPath(i,key,graph)){
					System.out.print(source+" ");
					return true;
				} 
			}
		}
		return false;
	}

	public static Queue<Integer> queue = new LinkedList<>();
	public static int bredthFirstTraversalGetPath(int source, int key, int[][] graph){
		// System.out.println(source);
		if(source == key){
					// System.out.print("R1  ");
					System.out.print(source+" ");
					return source; 
				}
		
		for(int i = 0;i<graph[source].length;i++){
			// System.out.println("for");
			
			if(graph[source][i]==1 && !visitMap.containsKey(i)){
				queue.add(i);
				visitMap.put(i,source);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()){ 
			int k = bredthFirstTraversalGetPath(queue.poll(), key, graph);
			if(k!=-1){
				if(visitMap.get(k)!=source){
				// System.out.println(source+"R2 " +k+" " +visitMap.entrySet());
					return k;	
				} 
				// System.out.print("R22 ");
				System.out.print(source+" ");
				return source;
			}

		}
			// System.out.println("R3  -1");
			return -1;
	}	

	public static void main(String[] args) {
						//	 0  1  2  3  4  5
		int[][] graphAM = {	{0, 1, 1, 1, 0, 0},//0
							{1, 0, 1, 1, 0, 0},//1  
							{1, 1, 0, 0, 1, 0},//2
							{1, 1, 0, 0, 1, 0},//3  
							{0, 0, 1, 1, 0, 0},//4 
							{0, 0, 0, 0, 0, 0}};//5;
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
		// int a = scan.nextInt();
		// int b = scan.nextInt();
		// int[][] graphAM = {{0,1},
		// 					{1,0}};
		depthFirstTraversalGetPath(0,4,graphAM);
		visitMap.clear();
		System.out.println("bredth first traversal");
		bredthFirstTraversalGetPath(4,1,graphAM);

	}
}