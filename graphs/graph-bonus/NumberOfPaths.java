/*############################################################################
                             Number of paths
    A n x n grid is given, you have to traverse this grid from top left 
    corner to the bottom right corner. But you can only move downwards and 
    rightwards and there are some obstacles present in the grid. You have 
    to tell how many paths are there from the start position to the goal 
    position. If there are none, could you have made it to the goal if you 
    could walk upwards and leftwards?
    
    So, you have to write a program to tell the possible number of different 
    ways to move from the top left corner(S) to bottom right(g) by just 
    moving downwards and rightwards. If none, then print "THE GAME IS A LIE" 
    i.e. if you cannot go from s to g going only rightwards and downwards but 
    you can if you are allowed to go left and up as well, or "INCONCEIVABLE" 
    if there simply is no path from s to g.
            
        Input Format:
            The first line contains an integer n. Then follows n lines, each 
            with n characters, where each character is one of '.' and '#', 
            where '.' is to be interpreted as a walkable cell and '#' as a 
            non-walkable cell. 

        Output Format:
            The output line contains the number of different paths starting from 
            s and ending at g (modulo 2^31 - 1) or "THE GAME IS A LIE" if you cannot 
            go from s to g going only rightwards and downwards but you can if you 
            are allowed to go left and up as well, or "INCONCEIVABLE" if there simply 
            is no path from s to g.

        Constraints:
            1 < n <= 1000
            There will never be an obstacle at s, and there will never be an 
            obstacle at g

        Sample Input:
            4
            .#.#
            ...#
            .#..
            ....

        Sample Output:
            3

    
					completed false;
  #############################################################################*/ 

  import java.io.FileReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.util.Scanner;
  import java.util.HashMap;
  import java.util.Stack;
  import java.util.Queue;
  import java.util.LinkedList;
  import java.util.ArrayList;
    
    
  public class NumberOfPaths{
      public static int n;
      public static int count;
      public static boolean[][] visited;
      public static String[] table;
  
      public static void maxPath(int row, int col) {
        //   method can solve the problem but giving time limit exceeding
        //   System.out.println(row +" "+col);
          if(row==n-1 && col==n-1){
              count++;
              return;
          }
          visited[row][col] = true;
          if(col+1<n && table[row].charAt(col+1)=='.' && !visited[row][col+1]){
              maxPath(row, col+1);
              visited[row][col+1] = false;
          }
          if(row+1<n && table[row+1].charAt(col)=='.' && !visited[row+1][col]){
            maxPath(row+1, col);
            visited[row+1][col] = false;
        }
      }
      public static boolean isPathPosible(int i, int j) {
        //   stack overflow problem is occureing to i need to use iterative using stack
        //   System.out.println(i+" "+j);
          if(i == n-1 && j==n-1) return true;
          visited[i][j] = true;
          if(j+1<n && table[i].charAt(j+1)=='.'&& !visited[i][j+1]){
            if(isPathPosible(i, j+1)) return true;
            visited[i][j+1] = false;
         }
         if(j-1>=0 && table[i].charAt(j-1)=='.'&& !visited[i][j-1]){
            if(isPathPosible(i, j-1)) return true;
            visited[i][j-1] = false;
         }
         if(i+1<n && table[i+1].charAt(j)=='.'&& !visited[i+1][j]){
            if(isPathPosible(i+1, j)) return true;
            visited[i+1][j] = false;
         }
         if(i-1>=0 && table[i-1].charAt(j)=='.'&& !visited[i-1][j]){
            if(isPathPosible(i-1, j)) return true;
            visited[i-1][j] = false;
         }
          return false;
      }

    // method 2 using dynamic programming
      public static int maxPath1() {
        // works but path reaches out of the range for integer so gave wrong output
        int[][] pathCount = new int[n+1][n+1]; 
        pathCount[0][1] = 1;
        for (int i = 1; i < pathCount.length; i++) {
            for (int j = 1; j < pathCount.length; j++) {
                // System.out.print(i+" "+j+" ");
                if(table[i-1].charAt(j-1)=='.'){
                    pathCount[i][j] = pathCount[i-1][j]+pathCount[i][j-1];
                    // System.out.print(i+" "+j+" "+pathCount[i][j]);
                }
            }
            // System.out.println();
        }
        return pathCount[n][n];
    }
    // method 2 updated 
    public static long maxPath2() {
        // works but path reaches out of the range for integer so gave wrong output
        long[][] pathCount = new long[n+1][n+1]; 
        pathCount[0][1] = 1;
        for (int i = 1; i < pathCount.length; i++) {
            for (int j = 1; j < pathCount.length; j++) {
                // System.out.println(i+" "+j+" ");
                if(table[i-1].charAt(j-1)=='.'){
                    pathCount[i][j] = pathCount[i-1][j]+pathCount[i][j-1];
                    // System.out.print(i+" "+j+" "+pathCount[i][j]);
                }
            }
            // System.out.println();
        }
        return pathCount[n][n];
    }
// iterative way of the recurvive previous version.
    static class Triplet{
        int row;
        int col;
        int status;
        Triplet(int i,int j){
            this.row = i;
            this.col = j;
            this.status = 0;
        }
    }
    public static boolean isPathPosible() {
        // some implementation issue is there 
        Stack<Triplet> st = new Stack<>();
        st.add(new Triplet(0,0)); 
        int i = 0, j = 0; 
        Triplet index = null;    
        while(!st.isEmpty()){
            index = st.peek();
            i = index.row;
            j = index.col;
            if(i==n-1 && j==n-1) return true;
            visited[i][j] = true;
            if(index.status==4){
                visited[i][j] = false;
                st.pop();
            }else if(index.status==3){
                index.status++;
                if(i-1>=0 && table[i-1].charAt(j)=='.'&& !visited[i-1][j]){
                   st.add(new Triplet(i-1,j));
                }
            }else if(index.status==2){
                index.status++;
                if(j+1<n && table[i].charAt(j+1)=='.'&& !visited[i][j+1]){
                   st.add(new Triplet(i,j+1));
                }
            }else if(index.status==1){
                index.status++;
                if(i+1<n && table[i+1].charAt(j)=='.'&& !visited[i+1][j]){
                   st.add(new Triplet(i+1,j));
                }
            }else{
                index.status++;
                if(j-1>=0 && table[i].charAt(j-1)=='.'&& !visited[i][j-1]){
                   st.add(new Triplet(i,j-1));
                }
            }

        }
        return false;
    }
  
    public static void main(String[] args) throws IOException {
        // InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/graph-smple-text.txt");
        Scanner scan = new Scanner(r);
        n = scan.nextInt(); // total rows and cols
        table = new String[n];
        for (int i = 0; i < n; i++) {
            table[i] = scan.next();
        }
        scan.close();
        r.close();
        visited = new boolean[n][n];
    //     System.out.println(n);
    //     for(String a:table) System.out.println(a);
    // // mehod 1
    //     count = 0;    
    //     maxPath(0, 0);
    //     if(count>0){
    //         System.out.println(count);
    //     }
    //     else if(isPathPosible(0,0)){
    //         System.out.println("THE GAME IS A LIE");
    //     }else System.out.println("INCONCEIVABLE");
// //method 2
//         // int count2 = maxPath1();
//         long count2 = maxPath2();
//         if(count2>0){
//             System.out.println(count2);
//         }
//         else if(isPathPosible(0,0)){
//             System.out.println("THE GAME IS A LIE");
//         }else System.out.println("INCONCEIVABLE");

    //method 3 max 2 with iterative has path
        long count2 = maxPath2();
        if(count2>0){
            System.out.println(count2);
        }
        else if(isPathPosible()){
            System.out.println("THE GAME IS A LIE");
        }else System.out.println("INCONCEIVABLE");
    }
}
    