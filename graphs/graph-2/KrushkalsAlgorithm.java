/*############################################################################
						Krushkals Algorithm(greedy aproach)
		this is one approach by which we can find the minimum spaning tree 

						completed true;					
#############################################################################*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class NodePQ{
	int v1;
	int v2;
	int weight;
	NodePQ(int v1, int v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;	
	}
}
public class KrushkalsAlgorithm{
	// check for cycle or not here i will do this by checking is their path or not

	public static HashMap<Integer,Boolean> visitMap = new HashMap<>();

	public static boolean hasPathDFT(int source, int key, Integer[][] graph){
		if(source==key) return true;
		if(visitMap.containsKey(source)) return false;
		visitMap.put(source,true);
		for(int i = 0;i<graph[source].length;i++){
			if(graph[source][i]!=null){
				if(hasPathDFT(i,key,graph)) return true;
			}
		}
		return false;
	}

	public static void print(Integer[][] graph){
		for(int i = 0;i<graph.length;i++){
			boolean check = true;
			for(int j = i; j<graph[0].length;j++){
				if(graph[i][j]!=null){
					if(check){
						System.out.print(i+" -> "+ j);
						check = false;
					}
					else System.out.print(", "+j);;
				}
			}
			if(!check) System.out.println();
		}
	}
	
	public static Integer[][] krushkalsMST(Integer[][] graph){
		Integer[][] mst = new Integer[graph.length][graph[0].length];// this not a good idea becasue it will going to have least number of edges.
		PriorityQueue<NodePQ> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
		for(int i = 0;i<graph.length;i++){
			for(int j = i; j<graph[0].length;j++){
				if(graph[i][j]!=null) pq.add(new NodePQ(i,j,graph[i][j]));
			}
		}
		int edge = 0;

		while(edge<graph.length&& !pq.isEmpty()){
			NodePQ min = pq.poll();
			// System.out.println("\n\n");
			// for(Integer[] arr:mst) System.out.println(Arrays.toString(arr));
			// print(mst);
			// System.out.println("\n"+min.v1+" "+min.v2);
			visitMap.clear();
			boolean con = hasPathDFT(min.v1,min.v2,mst);
			// System.out.println(con);
			if(!con){
				// System.out.println("checked in");
				mst[min.v1][min.v2] = min.weight;
				mst[min.v2][min.v1] = min.weight;
				edge++;
			}

		}

		return mst;
	}
	
	
	public static void main(String[] args) {
		// here is matrix if the value is null that means no relation else given value is weight
		int vertex = 6;
		int edges = 11;
		Integer[][] graph = new Integer[vertex][vertex];
		int[][] adjacencyList = {           // vertex1, vertex2, weight
								{0,1,2},{0,2,1},{0,3,3},
								{1,2,4},{1,3,2},
								{2,3,8},{2,4,6},{2,5,4},
								{3,4,6},{3,5,8},
								{4,5,1}};
		// Integer[][] adjacencyList = {           // vertex1, vertex2, weight
		// 						{0,1,2},{0,2,1},
		// 						{1,3,2},
		// 						{4,5,1}};

		for(int i = 0; i<adjacencyList.length;i++){
			graph[adjacencyList[i][0]][adjacencyList[i][1]] = adjacencyList[i][2];
			graph[adjacencyList[i][1]][adjacencyList[i][0]] = adjacencyList[i][2];
		}
		// for(Integer[] arr:graph) System.out.println(Arrays.toString(arr));
		// print(graph);
		// System.out.println(!hasPathDFT(0,3,graph));
		// krushkalsMST(graph);
		print(krushkalsMST(graph));

	}
}

// [null, 2, 1, null, null, null]
// [2, null, null, 2, null, null]
// [1, null, null, null, null, null]
// [null, 2, null, null, null, null]
// [null, null, null, null, null, 1]
// [null, null, null, null, 1, null]
// 0 -> 1, 2
// 1 -> 3
// 4 -> 5