/*############################################################################
  						 Coding Ninjas

  	Given a NxM matrix containing Uppercase English Alphabets only. Your 
  	task is to tell if there is a path in the given matrix which makes the 
  	sentence “CODINGNINJA” .
	There is a path from any cell to all its neighbouring cells. For a particular 
	cell, neighbouring cells are those cells that share an edge or a corner 
	with the cell.


		why back tracking is terrible thought.
		1. because to start we need to look for all first letter and then start from there.
			which increase time complexity M*N(for chosing starting letter)*(x)found first sam letter.

		but with graphs we can do this only by m*n time which will be taken.

					completed false;
  #############################################################################*/ 
import java.util.Arrays;
import java.util.HashMap;
public class CodingNinjas{
	// public static void createAMatrix(int[][] graph, String[] Graph, int n, int m){
	// 	//   [i-1,j-1]	[i-1,j]	[i-1,j+1]

	// 	//   [i,j-1]     [i,j]   [i,j+1]

	// 	//   [i+1,j-1]   [i+1,j] [i+1,j+1]

	// 	for(int i = 0; i<n;i++){
	// 		for(int j = 0; j<m;j++){
	// 			int index = Graph[i].charAt(j)-'A';
	// 			if(i-1>=0){// for upper line to the elements.
	// 				graph[index][Graph[i-1].charAt(j)-'A'] = 1;
	// 				graph[Graph[i-1].charAt(j)-'A'][index] = 1;
	// 				if(j-1>=0){
	// 					graph[index][Graph[i-1].charAt(j-1)-'A'] = 1;
	// 					graph[Graph[i-1].charAt(j-1)-'A'][index] = 1;
	// 				}
	// 				if(j+1<m){
	// 					graph[index][Graph[i-1].charAt(j+1)-'A'] = 1;
	// 					graph[Graph[i-1].charAt(j+1)-'A'][index] = 1;
	// 				}
	// 			}
	// 			if(i+1<n){ // for below line to the element.
	// 				graph[index][Graph[i+1].charAt(j)-'A'] = 1;
	// 				graph[Graph[i+1].charAt(j)-'A'][index] = 1;
	// 				if(j-1>=0){
	// 					graph[index][Graph[i+1].charAt(j-1)-'A'] = 1;
	// 					graph[Graph[i+1].charAt(j-1)-'A'][index] = 1;
	// 				}
	// 				if(j+1<m){
	// 					graph[index][Graph[i+1].charAt(j+1)-'A'] = 1;
	// 					graph[Graph[i+1].charAt(j+1)-'A'][index] = 1;
	// 				}
	// 			}
	// 			if(j-1>=0){
	// 				graph[index][Graph[i].charAt(j-1)-'A'] = 1;
	// 				graph[Graph[i].charAt(j-1)-'A'][index] = 1;
	// 			}
	// 			if(j+1<m){
	// 				graph[index][Graph[i].charAt(j+1)-'A'] = 1;
	// 				graph[Graph[i].charAt(j+1)-'A'][index] = 1;
	// 			}
	// 		}
	// 	}
	// }
	// public static int solve(String[] Graph , int n, int m){
	/* fails at 
				5 5
				DANDO
				NNINJ
				AXGJC
				INJAA
				CODDI
		because my matrix can't distinguish between two defferent sam letter.
*/
	// 	int[][] graph = new int[26][26];
	// 	// in this graph 0=A and 25 = Z as same
	// 	createAMatrix(graph, Graph, n,m);
	// 	// for(int[] arr: graph) System.out.println(Arrays.toString(arr));
	// 	String compare = "CODINGNINJA";
	// 	for(int k = 1; k<compare.length();k++){
	// 		int i = compare.charAt(k-1)-'A'; 
	// 		int j = compare.charAt(k)-'A';
	// 		if(graph[i][j]==0) return 0; 
	// 	}
	// 	return 1;
	// }
	// public static boolean makeWord(String[] Graph, int i, int j){
	// 	String compare = "CODINGNINJA";
	// 	int n = Graph.length;
	// 	int m = Graph[0].length();
	// 	HashMap<String,Boolean> visited = new HashMap<>();
	// 	for(int k = 1; k<compare.length();k++){
	// 		visited.put((i+""+j),true);
	// 		if(i-1>=0){// for upper line to the elements.
	// 			if(Graph[i-1].charAt(j)==compare.charAt(k) && !visited.containsKey((i-1)+""+j)) {
	// 				i = i-1;
	// 				continue;
	// 			}
	// 			if(j-1>=0){
	// 				if(Graph[i-1].charAt(j-1)==compare.charAt(k) && !visited.containsKey((i-1)+""+(j-1))) {
	// 					i = i-1;
	// 					j = j-1;
	// 					continue;
	// 				}
	// 			}
	// 			if(j+1<m){
	// 				// System.out.println("in"+Graph[i-1].charAt(j+1)+" "+i+" "+j);
	// 				if(Graph[i-1].charAt(j+1)==compare.charAt(k) && !visited.containsKey((i-1)+""+(j+1))){
	// 					i = i-1;
	// 					j = j+1;
	// 					continue;
	// 				}
	// 			}
	// 		}
	// 		if(i+1<n){// for upper line to the elements.
	// 			if(Graph[i+1].charAt(j)==compare.charAt(k) && !visited.containsKey((i+1)+""+(j))){
	// 				i = i+1;
	// 				continue;
	// 			}
	// 			if(j-1>=0){
	// 				if(Graph[i+1].charAt(j-1)==compare.charAt(k) && !visited.containsKey((i+1)+""+(j-1))){
	// 					i = i+1;
	// 					j = j-1;
	// 					continue;
	// 				}
	// 			}
	// 			if(j+1<m){
	// 				if(Graph[i+1].charAt(j+1)==compare.charAt(k) && !visited.containsKey((i+1)+""+(j+1))){
	// 				// System.out.println("in"+Graph[i+1].charAt(j+1)+" "+i+" "+j);
	// 					i = i+1;
	// 					j = j+1;
	// 					continue;
	// 				}
	// 			}
	// 		}
	// 		if(j-1>=0){
	// 			if(Graph[i].charAt(j-1)==compare.charAt(k) && !visited.containsKey((i)+""+(j-1))){
	// 				j = j-1;
	// 				continue;
	// 			}
	// 		}
	// 		if(j+1<m){
	// 			if(Graph[i].charAt(j+1)==compare.charAt(k) && !visited.containsKey((i)+""+(j+1))){
	// 				j = j+1;
	// 				continue;
	// 			}
	// 		}
	// 		// System.out.println(i+" "+j);
	// 		return false;
	// 	}
	// 	return true;
	// }
	// public static int solve(String[] graph , int n, int m){
	// // in this method i will use given graph and choose first all letters then try to make complete word.

	// 	for(int i = 0; i<n;i++){
	// 		for(int j = 0; j<m;j++){
	// 			if(graph[i].charAt(j) == 'C'){   // here searching for first word
	// 				if(makeWord(graph,i,j)) return 1;
	// 			}
	// 		}
	// 	}
	// 	return 0;
	// }

	public static HashMap<String,Boolean> visited = new HashMap<>();
	public static boolean makeWord(String[] Graph, int i, int j, String compare){
		if(compare.length()==0) return true;
		int n = Graph.length;
		int m = Graph[0].length();
		System.out.println(Graph[i].charAt(j));
		char nextLetter = compare.charAt(0);
		compare = compare.substring(1);
		visited.put((i+""+j),true);
		if(i-1>=0){// for upper line to the elements.
			if(Graph[i-1].charAt(j)==nextLetter && !visited.containsKey((i-1)+""+j)) {
				if(makeWord(Graph,i-1,j,compare)) return true;
			}
			if(j-1>=0){
				if(Graph[i-1].charAt(j-1)==nextLetter && !visited.containsKey((i-1)+""+(j-1))) {
					if(makeWord(Graph,i-1,j-1,compare)) return true;
				}
			}
			if(j+1<m){
				// System.out.println("in"+Graph[i-1].charAt(j+1)+" "+i+" "+j);
				if(Graph[i-1].charAt(j+1)==nextLetter && !visited.containsKey((i-1)+""+(j+1))){
					if(makeWord(Graph,i-1,j+1,compare)) return true;
				}
			}
		}
		if(i+1<n){// for upper line to the elements.
			if(Graph[i+1].charAt(j)==nextLetter && !visited.containsKey((i+1)+""+(j))){
				if(makeWord(Graph,i+1,j,compare)) return true;
			}
			if(j-1>=0){
				if(Graph[i+1].charAt(j-1)==nextLetter && !visited.containsKey((i+1)+""+(j-1))){
					if(makeWord(Graph,i+1,j-1,compare)) return true;
				}
			}
			if(j+1<m){
				if(Graph[i+1].charAt(j+1)==nextLetter && !visited.containsKey((i+1)+""+(j+1))){
				System.out.println("correct");
				// System.out.println("in"+Graph[i+1].charAt(j+1)+" "+i+" "+j);
					if(makeWord(Graph,i+1,j+1,compare)) return true;
				}
			}
		}
		if(j-1>=0){
			if(Graph[i].charAt(j-1)==nextLetter && !visited.containsKey(i+""+(j-1))){
				if(makeWord(Graph,i,j-1,compare)) return true;
			}
		}
		if(j+1<m){
			if(Graph[i].charAt(j+1)==nextLetter && !visited.containsKey(i+""+(j+1))){
				if(makeWord(Graph,i,j+1,compare)) return true;
			}
		}
		// System.out.println(i+" "+j);
		return false;
	}
	public static int solve(String[] graph , int n, int m){
	// in this method i will use given graph and choose first all letters then try to make complete word.

		for(int i = 0; i<n;i++){
			for(int j = 0; j<m;j++){
				if(graph[i].charAt(j) == 'C'){   // here searching for first word
					visited.clear();
					if(makeWord(graph,i,j, "ODINGNINJA")) return 1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// String[] graph = {	"CXDXNXNXNXA",
		// 					"XOXIXGXIXJX"};
		// String[] graph = {
		// 				"CXNAXC",
		// 				"OIJNOD",
		// 				"DXNGIX"};
		// String[] graph = {
		// 				"AXODX",
		// 				"JCXXI",
		// 				"NXXXN",
		// 				"XINGX"};

		// String[] graph = {	"ABE",
		// 					"CDF"};
		// String[] graph = {	"CANI",
		// 					"OOJN",
		// 					"DDIG",
		// 					"JNIN"};
		String[] graph = {
			"CANAA",
			"IOAII",
			"DDIND",
			"AJINS",
			"XINNG",
		};
		System.out.println(solve(graph,graph.length,graph[0].length()));

	}
}