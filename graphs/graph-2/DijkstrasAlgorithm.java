/*#####################################################################################################
                                        Dijkstra's Algorithm

    Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are 
    numbered from 0 to V-1) and E number of edges.
    Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices 
    (including source vertex also) using Dijkstra's Algorithm.

                        completed false
#########################################################################################################*/
import java.util.Arrays;

import jdk.tools.jlink.resources.plugins;

// import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DijkstrasAlgorithm {
    public static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if(minDistance==-1 || distance[i]<distance[minDistance]) minDistance = i;
            }
        }
        return minDistance;
    }
    private static void printMST(int[][] adjMatrix, boolean[] visited, int[] distance, int current) {
        for (int j = current+1; j < visited.length; j++) {
            if(adjMatrix[current][j]!=0 && !visited[j]){
               if(distance[j]== distance[current]+adjMatrix[current][j]){
                    if(current<j) System.out.println(current+" "+j+" "+adjMatrix[current][j]);
                    else System.out.println(j+" "+current+" "+adjMatrix[current][j]);
                    visited[j] = true;
                    printMST(adjMatrix, visited, distance, j);
               }
                
            }
        }
    }
    public static void dijkstra(int[][] adjMatrix) {
        int n = adjMatrix.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for (int i = 1; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = findMinDistance(distance, visited);
            // System.out.println(minIndex);
            // System.out.println(Arrays.toString(distance));
            visited[minIndex] = true;
            for (int j = 0; j < n; j++) {
                // System.out.print(i+" "+j+",");
                if(adjMatrix[minIndex][j]!= 0 && !visited[j]){
                    // System.out.println("get in");
                    if(distance[minIndex]+adjMatrix[minIndex][j]<distance[j]){
                        distance[j] = distance[minIndex]+adjMatrix[minIndex][j];
                    }
                }
            }
        }
        // printing the all edges in MST are 
        // printMST(adjMatrix,new boolean[n],distance, 0);
        for (int i = 0; i < n; i++) {
            System.out.println(i+" "+distance[i]);
        }
        // System.out.println(Arrays.toString(distance));
    }
	
    public static void main(String[] args) throws IOException{
        FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-2/dijkstaras.txt");
        // InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);  
        String[] ve = br.readLine().trim().split(" "); 
        int V = Integer.parseInt(ve[0]);
        int E = Integer.parseInt(ve[1]);
        int[][] adjMatrix = new int[V][V];
        int v1=0, v2=0, w=0;
        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().trim().split(" "); 
            v1 = Integer.parseInt(edge[0]);
            v2 = Integer.parseInt(edge[1]);
            w = Integer.parseInt(edge[2]);
            adjMatrix[v1][v2] = w;
            adjMatrix[v2][v1] = w;
        }
        br.close();
        r.close();
		// Scanner s = new Scanner(System.in);
		// int V = s.nextInt();
		// int E = s.nextInt();        
        // int[][] adjMatrix = new int[V][V];
        // int v1=0, v2=0, w=0;
        // for (int i = 0; i < E; i++) {
        //     v1 = s.nextInt();
        //     v2 = s.nextInt();
        //     w = s.nextInt();
        //     adjMatrix[v1][v2] = w;
        //     adjMatrix[v2][v1] = w;
        // }
        dijkstra(adjMatrix);
	}
}