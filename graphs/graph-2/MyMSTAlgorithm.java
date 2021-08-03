/*############################################################################
					i thought if i remove all the gretest edges.
		then i will remain with mst.
#############################################################################*/
/*############################################################################
						Prim's Algorithm
	here i will gonna implement prims algorithm to find the Minimum spaniing
	tree.
		1. this works on principle of creting link between two disjoint sets.
		2. here i will select vertex one by one with minimum weigth and
			mark them visited as their connected vertex weight is updated to
			least possible weight.
				COMPLETED - FALSE;
	here is one problem is that i am stuck at the loops. 
#############################################################################*/
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyMSTAlgorithm{
	public static void myMST(int[][] edgeList, int v){
		System.out.println("run");
		int[] allAdjacent = new int[v]; // to track the connected links to perticular vertex
		for(int[] edge:edgeList){
			allAdjacent[edge[0]]++;
			allAdjacent[edge[1]]++;
		}
		Arrays.sort(edgeList,(a,b) -> b[2]-a[2]);
		// for(int[] edge:edgeList) System.out.println(edge[0]+" "+edge[1]+" "+edge[2]);
		for(int[] edge:edgeList){
			// System.out.println(Arrays.toString(allAdjacent)+"\n\n");
			// System.out.println("checking  "+edge[0]+" "+edge[1]);

			if((allAdjacent[edge[0]]>1 && allAdjacent[edge[1]]>2)||
				(allAdjacent[edge[0]]>2 && allAdjacent[edge[1]]>1)){
				allAdjacent[edge[0]]--;
				allAdjacent[edge[1]]--;
			}else{
				System.out.println(edge[0]+" "+edge[1]+" "+edge[2]);
			}
		}
		

		
	}

	public static void main(String[] args) {
		// int v = 6;
		// int[][] edgeList = {           
						
		// 						{0,1,2},{0,2,1},{0,3,3},
		// 						{1,2,4},{1,3,2},
		// 						{2,3,8},{2,4,6},{2,5,4},
		// 						{3,4,6},{3,5,8},
		// 						{4,5,1}}; // vertex1, vertex2, weight
		// int[][] edgeList = {           
						
		// 						{0,1,1},{0,2,1},{0,3,1},
		// 						{1,2,1},{1,3,1},
		// 						{2,3,1},{2,4,1},{2,5,1},
		// 						{3,4,1},{3,5,8},
		// 						{4,5,1}}; // vertex1, vertex2, weight
		// ans of this (0 1 1),(0 2 1),(0 3 1),(3 4 1),(2 5 1) but codding ninjaja wonts (0 1 1),(0 2 1),(0 3 1),(2 4 1),(2 5 1) 
		int e = edgeList.length;			
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int e = scan.nextInt();
		int v1 = 0, v2 = 0, w = 0;
		if(v<2){
			return;
		}
		int[][] edgeList = new int[e][3]; // edgeList[0] = vertex1, edgeList[1] = vertex2, edgeList[2] = weight
		for(int i = 0; i<e; i++){
			edgeList[0] = scan.nextInt();
			edgeList[1] = scan.nextInt();
			edgeList[2] = scan.nextInt();
		}
		myMST(edgeList,v);

	}
}
