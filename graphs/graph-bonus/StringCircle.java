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

					completed false;
  #############################################################################*/ 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

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
	private static boolean isBigCyclePossible(String[] graph, boolean[] visited,int current,int countVisited) {
		System.out.println(current+" "+countVisited);
		String currentStr = graph[current];
		char endChar = graph[current].charAt(graph[current].length()-1);
		if(countVisited==graph.length-1 && endChar== graph[0].charAt(0)) return true;
		visited[current] = true;
		countVisited++;
		for (int i = 0; i < graph.length; i++) {
			if(!visited[i]){
				if(endChar == graph[i].charAt(0)){
					if(isBigCyclePossible(graph, visited, i ,countVisited)) return true;
				}
			}
		}
		return false;
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/StringCircle.txt");
		// InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		int n = Integer.parseInt(br.readLine().trim());
		String[] graph = br.readLine().trim().split(" ");
		System.out.println(Arrays.toString(graph));
		// if(isBigCyclePossible(graph, new HashMap<String,Boolean>(),graph[0],graph[0].charAt(0))){
        //     System.out.print("1");
        // }else System.out.print("0");
		if(isBigCyclePossible(graph, new boolean[graph.length],0,0)){
            System.out.print("1");
        }else System.out.print("0");
	}

}