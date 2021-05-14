/*############################################################################
						Prim's Algorithm
	here i will gonna implement prims algorithm to find the Minimum spaniing
	tree.
		1. this works on principle of creting link between two disjoint sets.
		2. here i will select vertex one by one with minimum weigth and
			mark them visited as their connected vertex weight is updated to
			least possible weight.


					completed - false;
#############################################################################*/
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{	  // node to track unvisited vertex and acess minimum weight from priority queue
	int index;
	int weight;
	Node(int index){
		this.index = index;
		this.weight = Integer.MAX_VALUE ;
	}
	Node(int index, int weight){
		this.index = index;
		this.weight = weight;
	}

}

public class PrimsForCodingNinja{
	// public static int findMinVertex(boolean[] visited, int[] weight){
	// 	int min = -1;
	// 	for(int i = 0; i<weight.length;i++){
	// 		if((min==-1 || weight[i]<weight[min]) && !visited[i]) min = i;
	// 	}return min;
	// }
	public static int findMinVertex(boolean[] visited, int[] weight){
		int min = -1;
		for(int i = weight.length-1; i>=0;i--){
			if(!visited[i] &&(min==-1 || weight[i]<weight[min])) min = i;
		}return min;
	}
	public static void primsMST(int[][] adjMatrix){
		
		int n = adjMatrix.length;
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		int[] weight = new int[n];

		parent[0] = -1;
		weight[0] = 0;
		for(int i=1;i<n;i++){
			int minVertex = findMinVertex(visited,weight);
			visited[minVertex] = true;
			// explore neighbors
			for(int j = 0; j<n;j++){
				if(adjMatrix[minVertex][j]!=0 && !visited[j]){
					if(weight[j]>adjMatrix[minVertex][j]){
						//update values
						weight[j] = adjMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		for(int i = 1;i<n;i++){
			System.out.println(i+" "+parent[i]+" "+weight[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int e = scan.nextInt();
		if(n<2){
			return;
		}
		int[][] adjMatrix = new int[n][n];
		int v1 = 0, v2 = 0, w = 0;
		for(int i = 0; i<e; i++){
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			w = scan.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		primsMST(adjMatrix);
	}
}
