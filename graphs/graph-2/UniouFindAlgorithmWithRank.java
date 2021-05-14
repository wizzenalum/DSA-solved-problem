/*############################################################################
						union find algorithm with rank
	Given an undirected, connected and weighted graph G(V, E) with V number 
	of vertices (which are numbered from 0 to V-1) and E number of edges.
	Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
	
	For printing MST follow the steps -
	1. In one line, print an edge which is part of MST in the format - 
		v1 v2 w
	where, v1 and v2 are the vertices of the edge which is included in MST 
	and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first 
	while printing an edge.
	
	2. Print V-1 edges in above format in different lines.

	Note : Order of different edges doesn't matter.

				completed - true;
#############################################################################*/
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

class NodePQ{
	int v1;
	int v2;
	int weight;
	NodePQ(int v1, int v2, int weight){
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;	
	}
	String toStr(){
		return this.v1+" "+this.v2+" "+this.weight;
	}
}
class Pair{
	int rank;
	int parent;
	Pair(int parent,int rank){
		this.rank = rank;
		this.parent = parent;
	}
}
class SortByWeight implements Comparator<NodePQ>{
    // Used for sorting in ascending order of
    // roll number
    public int compare(NodePQ a, NodePQ b)
    {
        return a.weight - b.weight-Integer.MIN_VALUE;
    }
}

public class UniouFindAlgorithmWithRank {


	public static int find(Pair[] parent,int i){	
		if(parent[i].parent == i) return i;
		return find(parent,parent[i].parent);
	}
	public static void union(Pair[] parent, int i, int j){
		if(parent[i].rank==parent[j].rank){
			parent[i].parent = parent[j].parent;
			parent[j].rank++;
		}
		else if(parent[i].rank>parent[j].rank){
			parent[j].parent = parent[i].parent;
		}else{
			parent[i].parent = parent[j].parent;
		}
	}
	public static Integer[][] krushkalsMST(NodePQ[] edges, int v){
		// sorting the edges
		Arrays.sort(edges,(a,b)->a.weight-b.weight);
		
		Integer[][] mst = new Integer[v][v];// this not a good idea becasue it will going to have least number of edges.
		int edge = 0, index = 0;
		Pair[] parent = new Pair[v];        // here i will make track of the parents
		for(int i = 0;i<parent.length;i++) parent[i] = new Pair(i,0); // first we assumed all vertex is its own parent.

		while(edge<v&& index<edges.length){
			NodePQ min = edges[index];
			index++;
			// System.out.println("\n\n");
			// for(Integer[] arr:mst) System.out.println(Arrays.toString(arr));
			// print(mst);
			// System.out.println("\n"+min.v1+" "+min.v2);
			int parent1 = find(parent,min.v1);
			int parent2 = find(parent,min.v2);			// System.out.println(con);
			if(parent1!=parent2){
				// System.out.println("checked in");
				union(parent,parent1,parent2);
				if(min.v1<min.v2) System.out.println(min.v1+" "+min.v2+" "+min.weight);
				else System.out.println(min.v2+" "+min.v1+" "+min.weight);
				edge++;
			}
		}return mst;
	}
	public static void main(String[] args) {
		int v = 6;
		Integer[][] graph = new Integer[v][v];
		int[][] adjacencyList = {           // vertex1, vertex2, weight
								{0,1,2},{0,2,1},{0,3,3},
								{1,2,4},{1,3,2},
								{2,3,8},{2,4,6},{2,5,4},
								{3,4,6},{3,5,8},
								{4,5,1}};
		NodePQ[] edges = new NodePQ[adjacencyList.length];
		for(int i = 0; i<adjacencyList.length;i++){
			edges[i] = new NodePQ(adjacencyList[i][0],adjacencyList[i][1],adjacencyList[i][2]);
		}
		// for(NodePQ node:edges) System.out.print(node.toStr()+" , ");
		// System.out.println();
		// for(NodePQ node:edges) System.out.print(node.toStr()+" , ");
		// System.out.println();
		// Scanner scan = new Scanner(System.in);
		// int v = scan.nextInt();
		// int e = scan.nextInt();
		// NodePQ[] edges = new NodePQ[e];
		// int v1 = 0, v2 = 0, w = 0;
		// for(int i = 0; i<e; i++){
		// 	v1 = scan.nextInt();
		// 	v2 = scan.nextInt();
		// 	w = scan.nextInt();
		// 	edges[i] = new NodePQ(v1,v2,w);
		// }

		// for(Integer[] arr:graph) System.out.println(Arrays.toString(arr));
		krushkalsMST(edges,v);

	}
}