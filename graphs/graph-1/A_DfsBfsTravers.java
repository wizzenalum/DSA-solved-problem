/*############################################################################
					BFS and DFS traversal
	i will going to implement the both traversals one by one.
					completed true;
#############################################################################*/

import java.util.LinkedList;
import java.util.Queue;

public class A_DfsBfsTravers {
    // here we know vertices are same as indeces so no need of vertices.
    static boolean[] visited;
    static Queue<Integer> que;
    public static void dfs(int[][] edges, int index){
        if(index>=visited.length) return;
        System.out.println(index+" ");
        visited[index] = true;
        int[] adjcents = edges[index];
        for (int adjcent:adjcents) {
            if(!visited[adjcent]){
                dfs(edges,adjcent);
            }
        }
    }
    public static void bfs(int[][] edges){
        int index = 1;
        que.add(index);
        int[] adjcents;
        visited[index] = true;
        System.out.println(index);
         
        while(!que.isEmpty()){
            index = que.poll();
            adjcents = edges[index];
            for(int adjcent:adjcents){
                if(!visited[adjcent]){
                    visited[adjcent] = true;
                    System.out.println(adjcent);
                    que.add(adjcent);
                }
            }

        }
    }

    public static void main(String[] args) {
        // i will use adjacency list for a graph
        int[] vertices = {0,1,2,3,4,5,6,7,8};
        int[][] edges = {
                        {6},
                        {2,5,4},
                        {1,3,4},
                        {2,7,8},
                        {1,2,8},
                        {1,7},
                        {0},
                        {3,5,8},
                        {3,4,7},
                    };
        // visited = new boolean[vertices.length];
        // dfs(edges,1);
        visited = new boolean[vertices.length];
        que = new LinkedList<>();
        bfs(edges);
        // print by dfs search
        

        

    }
}


