/*############################################################################
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
import java.util.concurrent.CountDownLatch;

import jdk.tools.jlink.resources.plugins;
public class StringCircle{
	
	private static boolean isBigCyclePossible(String[] graph, HashMap<String,Boolean> visited, String current,char start) {
		//  6
	// ab cd bc da ab ba
	// fails at above case becaus i did not look into repeating String. so partally correct.
		System.out.println(current+" "+start);
		if(visited.size()==graph.length-1 &&  current.charAt(current.length()-1)== start) return true;
		visited.put(current,true);
		for (int i = 0; i < graph.length; i++) {
			if(!visited.containsKey(graph[i])){
				if(current.charAt(current.length()-1) == graph[i].charAt(0)){
					if(isBigCyclePossible(graph, visited, graph[i],start)) return true;
				}
			}
		}
		return false;
		
	}
	// method mine not working at all.
	
	public static int count = 0;
	public static boolean isBigCyclePossible(String[] graph, boolean[] visited,int current) {
		System.out.println(current+" "+count);
		String currentStr = graph[current];
		char endChar = graph[current].charAt(graph[current].length()-1);
		visited[current] = true;
		count++;
		if(count==graph.length && endChar== graph[0].charAt(0)) return true;
		for (int i = 0; i < graph.length; i++) {
			if(!visited[i]){
				if(endChar == graph[i].charAt(0)){
					if(isBigCyclePossible(graph, visited, i)) return true;
				}
			}
		}
		return false;
	}

	//method two most part written in main.
	public static int countVisited = 1;
	public static boolean isConnected(int[][] adjMatrix, int index, boolean[] visited, int total) {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/graph-smple-text.txt");
		// InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int n = Integer.parseInt(br.readLine().trim());
		String[] graph = br.readLine().trim().split(" ");
		// System.out.println(Arrays.toString(graph));
		// if(isBigCyclePossible(graph, new HashMap<String,Boolean>(),graph[0],graph[0].charAt(0))){
        //     System.out.print("1");
        // }else System.out.print("0");
		// count = 0;
		// if(isBigCyclePossible(graph, new boolean[graph.length],0)){
        //     System.out.print("1");
        // }else System.out.print("0");

	// method 2
		boolean[] visited = new boolean[26];
		int[][] adjMatrix = new int[26][26];  // here i am making graph based on first and last character of the strings given.
		int total = 0, index = -1;
		for (String str:graph){
			int row = str.charAt(0)-'a';
			int col = str.charAt(str.length()-1)-'a';
			if(adjMatrix[row][col]==0){  // how many edges are there in the matrix
				if(!visited[row]){
					visited[row] = true;
				}
				if(!visited[col]){
					visited[col] = true;
				}
			}
			adjMatrix[row][col]++;  
			if(index==-1) index = row; // any starting to search begin.
		}
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]){
				total++;
				visited[i] = false;
			}
		}
		// chacking is there all character have same outgoing and incoming edges so that it looping around all strings
		int arr[][] = new int[26][2]; // arr[i][0] contains edges towards ith cahracter where arr[i][1] aways from it.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][0]+=adjMatrix[i][j];
				arr[j][1]+=adjMatrix[i][j];
				
			}
		}
		
		boolean isLooping = true;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][0]!=arr[i][1]){ // condition for not same incoming and outoging edge 
				isLooping = false;
				break;
			}
		}
		// for (int i = 0;i<26;i++) {
		// 	if(arr[i][0]!=0||arr[i][1]!=0){
		// 		System.out.print((char)(i+'a')+" "+ arr[i][0]+","+arr[i][1]+"),(");
				
		// 	}
		// }
		// System.out.println(isLooping);
		// now there may be a case where these loops are made in disconnected graph.
		if(isLooping){
			// System.out.println(adjMatrix['c'-'a']['n'-'a']);
			// System.out.println(" first call "+(char)(index+'a'));
			isLooping = isConnected(adjMatrix,index, visited,total);
		}
		if(isLooping){
			System.out.print("1");
        }else System.out.print("0");
		
		
	}
	
}

// cat
// goat
// tog
// gone
// eat
// tom
// more
// tag
// eat
// note
// ease
// elfi
// nos
// sam
// mota
// aloo
// oton
// tan
// yarned
// doomedingn
// ion
// nasty
// karma
// aloon
// name
// east
// naughty
// tanged
// yolk
// dac

















