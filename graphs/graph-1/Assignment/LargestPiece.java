/*############################################################################
  							Largest Piece					  
	  It's Gary's birthday today and he has ordered his favourite square 
	  cake consisting of '0's and '1's . But Gary wants the biggest piece 
	  of '1's and no '0's . A piece of cake is defined as a part which 
	  consist of only '1's, and all '1's share an edge with each other on 
	  the cake. Given the size of cake N and the cake, can you find the 
	  count of '1's in the biggest piece of '1's for Gary ?

	  	Constraints :
			1 <= N <= 1000
			Time Limit: 1 sec

		Sample Input 1:
			2
			1 1
			0 1

		Sample Output 1:
			3



					completed true;
  #############################################################################*/ 
import java.util.Arrays;
import java.util.HashMap;
public class LargestPiece{

	public static HashMap<String,Boolean> visited = new HashMap<>();
	public static HashMap<String,Boolean> visitedGraph = new HashMap<>();
	public static String terminate;
	public static int largestPiece(String[] Graph, int i, int j){
		int n = Graph.length;
		int m = Graph[0].length();
		int count = 1, temp =0 ;
		visited.put((i+""+j),true);
		visitedGraph.put((i+""+j),true);
		// int checkM = 0, checkN = 0;
		if(i-1>=0){// for upper line to the elements.
			if(Graph[i-1].charAt(j)=='1' && !visited.containsKey((i-1)+""+j)) {
				// System.out.println("turn up");
				temp = largestPiece(Graph,i-1,j);
				count += temp;

			}
		}
		if(j+1<m){
			if(Graph[i].charAt(j+1)=='1' && !visited.containsKey(i+""+(j+1))) {
				// System.out.println("turn right");
				temp = largestPiece(Graph,i,j+1);
				count += temp;
			}
		}
		if(i+1<n){// for upper line to the elements.
			if(Graph[i+1].charAt(j)=='1' && !visited.containsKey((i+1)+""+j)) {
				// System.out.println("turn down");
				temp = largestPiece(Graph,i+1,j);
				count += temp;
			}
		}
		if(j-1>=0){
			if(Graph[i].charAt(j-1)=='1' && !visited.containsKey(i+""+(j-1))) {
				// System.out.println("turn left");
				temp = largestPiece(Graph,i,j-1);
				count += temp;

			}
		}

		// System.out.println("R2 "+count);
		return count;
	}
	public static int dfs(String[] graph , int n){
	// in this method i will use given graph and choose first all letters then try to make complete word.
		int biggestPiece = 0, temp = 0;
		for(int i = 0; i<n;i++){
			for(int j = 0; j<n;j++){
				visited.clear();
				// System.out.println(i+" "+j);
				if(graph[i].charAt(j)=='1' && !visitedGraph.containsKey(i+""+j)){
					temp = largestPiece(graph,i,j);
					if(temp>biggestPiece) biggestPiece = temp;
				}
			}
		}
		return biggestPiece;
	}
	public static void main(String[] args) {
		String[] graph = {	"1010",
							"1111",
							"0000",
							"0011"};
		// String[] graph = {	"10",
		// 					"11"};

		System.out.println(dfs(graph,graph.length));

	}
}
// 



// 5 5
// CANAA
// IOAII
// DDIND
// AJINS
// XINNG
