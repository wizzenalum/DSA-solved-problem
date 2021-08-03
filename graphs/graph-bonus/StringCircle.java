/* ############################################################################
  						   String Circle

	You are given an array of strings, you have to find whether those strings 
	can be chained together to form a circle or not. One string('X') can be 
	chained with another string('Y') if the last character of X is same as 
	first character of Y. If every string of the string array can be chained 
	with another string, then it will form a circle and you have to return 
	true, else return false.
INPUTS
4
ab cd bc da

					completed true;
  #############################################################################*/ 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.HashMap;

public class StringCircle{
	public static int visitedCount;
	private static boolean isBigCyclePossible(String[] graph, boolean[] visited, int current,char start) {
		// correct and working mine method.
		// System.out.println(current+" "+start);
		if(visitedCount==graph.length-1 &&  graph[current].charAt(graph[current].length()-1) == start) return true;
		visited[current] = true;
		visitedCount++;
		for (int i = 0; i < graph.length; i++) {
			if(!visited[i]){
				if(graph[current].charAt(graph[current].length()-1) == graph[i].charAt(0)){
					if(isBigCyclePossible(graph, visited, i,start)) return true;
				}
			}
		}
        visitedCount--;
		visited[current] = false;
		return false;
		
	}


	//method two most part written in main.
	public static int countVisited = 1;
	public static boolean isConnected(int[][] adjMatrix, int index, boolean[] visited, int total) {
		// this is dfs search to count all conected indeces 
		// System.out.println(" "+(char)(index+'a')+" "+countVisited+" "+total);
		
		visited[index] = true;
		countVisited++;
		if(countVisited==total){
			// System.out.println("r1 true");
			return true;
		}
		for (int i = 0; i < visited.length; i++) {
			if(adjMatrix[index][i] != 0 && !visited[i]){
				// System.out.print("call  "+ (char)(i+'a')+" "+countVisited+" "+total);
				if(isConnected(adjMatrix, i, visited,total)){
					// System.out.println("R2 true");
					return true;
				}
			}
		}
		// System.out.println("r3 false");
		return false;
	}


	// method 3
	public static boolean isConnected3(String[] lists){
		int[][] dp = new int[26][2]; // here i will store which character at start(0) and end(1) with frequency.
		for(int i =0; i<lists.length;i++){
			char chr1 = lists[i].charAt(0);
			char chr2 = lists[i].charAt(lists[i].length()-1);
			dp[chr1-'a'][0]++;
			dp[chr2-'a'][1]++;
		}
		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.print("("+dp[i][0]+", "+dp[i][1]+")   ");
		// }
		for (int i = 0; i < dp.length; i++) {
			if(dp[i][0]!=dp[i][1]) return false;
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// FileReader r = new FileReader("./graph-smple-text.txt");
		// InputStreamReader r = new InputStreamReader(System.in);
		// BufferedReader br = new BufferedReader(r);
		// int n = Integer.parseInt(br.readLine().trim());
		// String[] graph = br.readLine().trim().split(" ");
		
		String[] graph = { "ab", "cd", "bc", "da", "ab","ba"};
		System.out.println(Arrays.toString(graph));
		if(isBigCyclePossible(graph,new boolean[graph.length],0,graph[0].charAt(0))){
            System.out.print("1");
        }else System.out.print("0");
	
	// method 3
		// System.out.println(isConnected3(graph));

	// // method 2
	// // here we assumed a graph of letters as edges 
	// 	boolean[] visited = new boolean[26];
	// 	int[][] adjMatrix = new int[26][26];  // here i am making graph based on first and last character of the strings given.
	// 	int total = 0, index = -1;
	// 	// creating graph 
	// 	for (String str:graph){
	// 		int row = str.charAt(0)-'a';
	// 		int col = str.charAt(str.length()-1)-'a';
	// 		if(adjMatrix[row][col]==0){  // how many edges are there in the matrix
	// 			if(!visited[row]){
	// 				visited[row] = true;
	// 			}
	// 			if(!visited[col]){
	// 				visited[col] = true;
	// 			}
	// 		}
	// 		adjMatrix[row][col]++;  
	// 		if(index==-1) index = row; // any starting to search begin.
	// 	}
	// 	// counting total edges in the graph
	// 	for (int i = 0; i < visited.length; i++) {
	// 		if(visited[i]){
	// 			total++;
	// 			visited[i] = false;
	// 		}
	// 	}
	// 	// chacking is there all character have same outgoing and incoming edges so that it looping around all strings
	// 	boolean isLooping = true; // varialbe to confirm at last that graph is looping during at each step of checking.
	// 	int arr[][] = new int[26][2]; // arr[i][0] contains edges towards ith cahracter where arr[i][1] aways from it.
	// 	for (int i = 0; i < arr.length; i++) {
	// 		for (int j = 0; j < arr.length; j++) {
	// 			arr[i][0]+=adjMatrix[i][j];
	// 			arr[j][1]+=adjMatrix[i][j];
				
	// 		}
	// 	}
	// 	for (int i = 0; i < arr.length; i++) {
	// 		if(arr[i][0]!=arr[i][1]){ // condition for not same incoming and outoging edge 
	// 			isLooping = false;
	// 			break;
	// 		}
	// 	}
	// 	// for (int i = 0;i<26;i++) {
	// 	// 	if(arr[i][0]!=0||arr[i][1]!=0){
	// 	// 		System.out.print((char)(i+'a')+" "+ arr[i][0]+","+arr[i][1]+"),(");
				
	// 	// 	}
	// 	// }
	// 	// System.out.println(isLooping);
	// 	// now there may be a case where these loops are made in disconnected graph.
	// 	if(isLooping){
	// 		// System.out.println(adjMatrix['c'-'a']['n'-'a']);
	// 		// System.out.println(" first call "+(char)(index+'a'));
	// 		isLooping = isConnected(adjMatrix,index, visited,total);
	// 	}
	// 	if(isLooping){
	// 		System.out.print("1");
    //     }else System.out.print("0");	
	}	
}










