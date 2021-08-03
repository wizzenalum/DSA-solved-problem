/*############################################################################
  							 3 Cycle

	Given a graph with N vertices (numbered from 0 to N-1) and M undirected 
	edges, then count the distinct 3-cycles in the graph. A 3-cycle PQR is 
	a cycle in which (P,Q), (Q,R) and (R,P) are connected by an edge.


					completed true;
  #############################################################################*/ 
import java.util.Arrays;
import java.util.HashMap;
public class ThreeCycle{

	public static int solve(boolean[][] graph, int n) {
		int countCycle = 0, temp = 0;

		for(int i = 0; i<n;i++){
			for(int j = i+1; j<n;j++){
				if(graph[i][j]){
					for(int k = j+1;k<n;k++){
						if(graph[i][k] && graph[j][k]) countCycle++;
					}
				}

			}
		}
		return countCycle;
	}

	public static void main(String[] args) {
		// boolean[][] graph = {
		// 					{true,true, true},
		// 					{true,true, true},
		// 					{true,true, true}};
		boolean[][] graph = {
							{true,true, true, true},
							{true,true, true, true},
							{true,true, true, true},
							{true,true,true, true}};

		System.out.println(solve(graph,graph.length));

	}
}