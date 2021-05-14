/*############################################################################
						Prim's Algorithm
	here i will gonna implement prims algorithm to find the Minimum spaniing
	tree.
		1. this works on principle of creting link between two disjoint sets.
		2. here i will select vertex one by one with minimum weigth and
			mark them visited as their connected vertex weight is updated to
			least possible weight.
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

public class PrimsAlgorithm{
	public static void helper(	ArrayList<ArrayList<Node>> graph, int[] parents,
								boolean[] visited, PriorityQueue<Node> unvisited, Node[] weight){
		System.out.println(Arrays.toString(visited));
		for(int i = 0;i<weight.length;i++){
			System.out.print(weight[i].index+","+parents[i]+","+weight[i].weight+"   ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		if(unvisited.size()<=1) return;
		System.out.println("start itteration");
		System.out.println(unvisited.peek().index+","+unvisited.peek().weight);

		Node minNode = unvisited.poll();
		visited[minNode.index] = true;
		ArrayList<Node> adjacencyVertecies = graph.get(minNode.index);
		for(int i = 0;i<adjacencyVertecies.size();i++){
			int index = adjacencyVertecies.get(i).index;
			int w = adjacencyVertecies.get(i).weight;
			if(!visited[index]){
				if(weight[index].weight>w){
					unvisited.remove(weight[index]);
					weight[index].weight = w;
					unvisited.add(weight[index]);
					parents[index] = minNode.index;
				}
			}
		}
		helper(graph,parents,visited,unvisited,weight);


	}
	public static void primsMST(ArrayList<ArrayList<Node>> graph){
		int v = graph.size();
		int[] parents = new int[v]; // to set the parent of each node.
		Node[] weight = new Node[v]; // to access the weight of the node fast.
		boolean[] visited = new boolean[v];  // to check that node is visited or not.
		PriorityQueue<Node> unvisited = new PriorityQueue<>(v,(a,b) -> a.weight-b.weight); // to make easily extract minimum weighted node fast.
		weight[0] = new Node(0,0);
		unvisited.add(weight[0]);
		for(int i = 1; i<v;i++){
			parents[i] = -1;
			weight[i] = new Node(i); 
			unvisited.add(weight[i]);
		}
		// printing the graph.
		// for(int j = 0; j<graph.size();j++){
		// 	ArrayList<Node> list = graph.get(j);
		// 	System.out.print(j+" -> ");
		// 	for(int i = 0; i<list.size();i++){
		// 		System.out.print(list.get(i).index+","+list.get(i).weight+"  ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println(Arrays.toString(parents));
		// System.out.println(Arrays.toString(visited));
		// for(int i = 0;i<weight.length;i++){
		// 	System.out.print(weight[i].index+","+weight[i].weight+"   ");
		// }
		// for(int i = 0;i<weight.length;i++){
		// 	System.out.print(unvisited.peek().index+","+unvisited.poll().weight+"   ");
		// }

		helper(graph,parents, visited, unvisited, weight);
		for(int i = 1;i<weight.length;i++){
			if(weight[i].index<parents[i]) System.out.print(weight[i].index+" "+parents[i]+" "+weight[i].weight);
			else System.out.print(parents[i]+" "+weight[i].index+" "+weight[i].weight);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i = 0; i<v;i++){
			graph.add(new ArrayList<Node>());
		}
		int v1 = 0, v2 = 0, w = 0;
		// int[][] adjacencyList = {           
						
		// 						{0,1,2},{0,2,1},{0,3,3},
		// 						{1,2,4},{1,3,2},
		// 						{2,3,8},{2,4,6},{2,5,4},
		// 						{3,4,6},{3,5,8},
		// 						{4,5,1}}; // vertex1, vertex2, weight
		int[][] adjacencyList = {           
						
								{0,1,1},{0,2,1},{0,3,1},
								{1,2,1},{1,3,1},
								{2,3,1},{2,4,1},{2,5,1},
								{3,4,1},{3,5,8},
								{4,5,1}}; // vertex1, vertex2, weight
		// ans of this (0 1 1),(0 2 1),(0 3 1),(3 4 1),(2 5 1) but codding ninjaja wonts (0 1 1),(0 2 1),(0 3 1),(2 4 1),(2 5 1) 
		for(int i = 0; i<adjacencyList.length; i++){
			v1 = adjacencyList[i][0];
			v2 = adjacencyList[i][1];
			w = adjacencyList[i][2];
			
			graph.get(v1).add(new Node(v2,w));
			graph.get(v2).add(new Node(v1,w));
		}			
		
		// System.out.println();
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int e = scan.nextInt();
		int v1 = 0, v2 = 0, w = 0;
		if(v<2){
			return;
		}
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int i = 0; i<v;i++){
			graph.add(new ArrayList<Node>());
		}
		for(int i = 0; i<e; i++){
			v1 = scan.nextInt();
			v2 = scan.nextInt();
			w = scan.nextInt();
			graph.get(v1).add(new Node(v2,w));
			graph.get(v2).add(new Node(v1,w));
		}
		primsMST(graph);
		// for(int i = 0; i<arr.length;i++){
		// 	System.out.print("("+i+","+arr[i]+")   ");
		// }
		// for(Integer[] arr:graph) System.out.println(Arrays.toString(arr));

	}
}

// 0 1 1
// 0 2 1
// 0 3 1
// 1 2 1
// 1 3 1
// 2 3 1
// 2 4 1
// 2 5 1
// 3 4 1
// 3 5 8
// 4 5 1
