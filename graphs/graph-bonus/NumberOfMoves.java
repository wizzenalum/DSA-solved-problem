/*############################################################################
                                 Number of moves

    A chessboard is given with n rows and m columns. On that chessboard some of 
    the cells are already occupied. There is queen placed at one of the cell 
    in that chessboard. Queen wants to move to the another cell on that 
    chessboard. You have to find the least possible moves required by the queen. 
    The queen can go any number of cells in any of eight directions in a single 
    move, but it can't pass through or stand on the occupied cells and leave 
    the board.

    Input format:
        The first line consists of two numbers n and m separated with a space. 
        Then n lines follow each containing m characters describing the board. 
        Character ‘.’ means a free cell, character ‘X’ – an occupied cell, 
        character ‘S’ – the starting cell of the queen, character ‘F’ – the 
        cell where the queen wants to go. 

    Output Format:
        Print the minimum number of moves the queen has to do to reach the 
        desired cell. Print ‘-1’ if the queen can’t reach the cell.

    Constraints:
        2 <= n, m <= 1000
        It is guaranteed that there will be exactly one character ‘S’ and 
        one character ‘F’ on each board.

    Sample Input:
        4 4
        S...
        X.X.
        .X.X
        XFX.

    Sample Output:
        2	    
					completed false;
  #############################################################################*/ 

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileStore;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;
  
  
public class NumberOfMoves{
    public static int n;
    public static int m;
    public static int count;
    public static Queue<Pair> queue;
    public static Pair[][] visited;
    public static Pair START;
    public static Pair FINAL;
    public static String[] table;

    static class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        public boolean isEqual(Pair a){
            if(this.row == a.row && a.col==this.col) return true;
            return false;
        }
        public String toString(){
           return "("+this.row+","+this.col+")";
        }
    }
    public static void addChildsToQueue(Pair index){
        int i = index.row, j = index.col;
        while(i+1<n && j+1<m && table[i+1].charAt(j+1) !='X'){ // forward+downward
                if(visited[i+1][j+1] == null){
                    visited[i+1][j+1]= index;
                    queue.add(new Pair(i+1,j+1));  
                } 
                i++; j++;  
        }
        i= index.row; j=index.col;
        while(i-1>=0 && j-1>=0 && table[i-1].charAt(j-1) !='X'){ // backward and upward
            if(visited[i-1][j-1] == null){
                visited[i-1][j-1]= index;
                queue.add(new Pair(i-1,j-1));  
            } 
            i--; j--;  
        }
        i= index.row; j=index.col;
        while(i+1<n && j-1>=0 && table[i+1].charAt(j-1) !='X'){  //backard downward 
            if(visited[i+1][j-1] == null){
                visited[i+1][j-1]= index;
                queue.add(new Pair(i+1,j-1));  
            } 
            i++; j--;  
        }
        i= index.row; j=index.col;
        while(i-1>=0 && j+1<m && table[i-1].charAt(j+1) !='X'){  //forward upward
            if(visited[i-1][j+1] == null){
                visited[i-1][j+1]= index;
                queue.add(new Pair(i-1,j+1));  
            } 
            i--; j++;  
        }
        i= index.row; j=index.col;
        while(i+1<n && table[i+1].charAt(j) !='X'){  // down ward only
            if(visited[i+1][j] == null){
                visited[i+1][j]= index;
                queue.add(new Pair(i+1,j));  
            } 
            i++;  
        }
        i= index.row; j=index.col;
        while(i-1>=0 && table[i-1].charAt(j) !='X'){ // upward only
            if(visited[i-1][j] == null){
                visited[i-1][j]= index;
                queue.add(new Pair(i-1,j));  
            } 
            i--;  
        }
        i= index.row; j=index.col;
        while(j+1<m && table[i].charAt(j+1) !='X'){  //forward
            if(visited[i][j+1] == null){
                visited[i][j+1]= index;
                queue.add(new Pair(i,j+1));  
            } 
            j++;  
        }
        i= index.row; j=index.col;
        while(j-1>=0 && table[i].charAt(j-1) !='X'){ // backward and upward
            if(visited[i][j-1] == null){
                visited[i][j-1]= index;
                queue.add(new Pair(i,j-1));  
            } 
            j--;  
        }

    }
    public static Pair minMoves(Pair index) {
        if(index.isEqual(FINAL)){
            count++;
            return index;
        }
        addChildsToQueue(index);
        if(queue.isEmpty()){
            count = -1;
            return null;
        }
        Pair next = minMoves(queue.poll());
        if(next!=null){
            if(visited[next.row][next.col].isEqual(index)){
                count++;
                return index;
            }
            else return next;
        }
        return null;
    }
    public static void minMoves1(Pair start) {
        Stack<Pair> st = new Stack<>();
        Pair index = start;
        while(true){
            // System.out.print("\n"+index.toString()+" ");
            if(index.isEqual(FINAL)){
                count++;
                index = visited[index.row][index.col];
                // System.out.print(" found ");
                break;
            }
            st.add(index);
            addChildsToQueue(index);
            if(queue.isEmpty()){ 
                // System.out.print(" end queue empty ");

                return;
            }
            index = queue.poll();
            // System.out.println();
        }
        while(st.size()>0){
            // System.out.println(" "+st.peek().toString()+" ");

            if(st.peek().isEqual(index)){
                count++;
                // System.out.print(count+" ");
                index = visited[index.row][index.col];
            } st.pop();
            // System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        // InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/graph-smple-text.txt");
        Scanner scan = new Scanner(r);
        n = scan.nextInt(); // total rows
        m = scan.nextInt(); // total columns
        visited = new Pair[n][m];
        table = new String[n];
        for (int i = 0; i < n; i++) {
            table[i] = scan.next();
        }
        scan.close();
        r.close();
        
        // System.out.println(n+" "+m);
        // for(String a:table) System.out.println(a);
        
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < m; j++) {
                if(table[i].charAt(j)=='S') START = new Pair(i,j);
                if(table[i].charAt(j)=='F') FINAL = new Pair(i,j);  
            }
        }
    
        queue = new LinkedList<>();
        count = -1;    
        // minMoves(START);
        minMoves1(START);
        System.out.println(count);
        // if(count == 0) System.out.println("-1");
        // else System.out.println(count);   
    }
  }
  