/* ******************* Rotten Oranges  ************************************
    You are given a 2D array of integers of size N * M. Each of the cell 
    contains either of these 3 integers: 0, 1, 2. The integer 2 denotes a 
    rotten orange, 1 denotes a fresh orange and 0 denotes an empty cell.
    Each rotten orange can rot fresh oranges in 4 adjacent cells in 1 
    unit of time. The 4 cells are left, right, top and bottom cell.
    For a given matrix, find the minimum units of time in which all oranges 
    become rot. Return -1, if it is not possible.
    
        Input Format:
            The first line of input contains 2 space separated integers, N and 
            M, that denotes size of given 2D array.
            The following N lines contains M space separated integers, that 
            denotes the value of cells of given 2D array.

        Constraints:
            Value of N and M lies in the range: [1, 10000].
            Value of each cell in 2D array can be either 0, 1 or 2.

        Output Format:
            Print the required integer, as described in the problem description.   

        Sample Input 1:
            3 5
            2 1 0 2 1
            1 0 1 2 1
            1 0 0 2 1

        Sample Output 1:
            2

        Explanation:
            In the first unit of time, fresh oranges at coordinates: (0, 1), (0, 4), 
            (1, 0), (1, 2), (1, 4), (2, 4).
            In the second unit of time, fresh orange at coordinate: (2, 0) gets rot. 
            Hence, in 2 units of time, all the fresh oranges become rot.

        Sample Input 2:
            3 5
            2 1 0 2 1
            1 0 1 0 1
            1 0 0 0 2

        Sample Output 2:
            -1

        Explanation:
            It is impossible to rot the fresh orange at (1, 2).   

 */


package test10;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

class FastInput {
    BufferedReader br;
    StringTokenizer st;

    public FastInput()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;

    }
}
public class RottanOranges {
    public static void printq(Queue<Pair> q) {
        for (int i = 0; i < q.size(); i++) {
            Pair a = q.poll();
            // System.out.print("("+a.row+","+a.col+") ");
            q.add(a);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        FastInput s  = new FastInput();
        int row = s.nextInt(), col = s.nextInt();
        int[][] mat = new int[row][col];
        HashMap<String,Boolean> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = s.nextInt();
                if(mat[i][j]==2) q.add(new Pair(i,j));
                if(mat[i][j]==1) map.put(i+""+j,true);
            }
        }
        q.add(new Pair(-1,-1));
        printq(q);
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.poll().col;
            // System.out.println();
            // System.out.println(r+"   "+c);
            if(r==-1){
                // printq(q);
                // for (int i = 0; i < row; i++) {
                //     for (int j = 0; j < col; j++) {
                //         System.out.print(mat[i][j]+" ");
                //     }
                //     System.out.println();
                // }
                if(q.isEmpty()) break;
                q.add(new Pair(-1,-1));
                count++;                
            }else{
                if(r-1>=0 && mat[r-1][c]==1){
                    mat[r-1][c] = 2;
                    if(map.containsKey((r-1)+""+c)) map.remove((r-1)+""+c);
                    q.add(new Pair(r-1,c)); 
                }
                if(r+1<row && mat[r+1][c]==1){
                    mat[r+1][c] = 2;
                    if(map.containsKey((r+1)+""+c)) map.remove((r+1)+""+c);

                    q.add(new Pair(r+1,c)); 
                }
                if(c-1>=0 && mat[r][c-1]==1){
                    mat[r][c-1] = 2;
                    if(map.containsKey(r+""+(c-1))) map.remove(r+""+(c-1));
                    q.add(new Pair(r,c-1)); 
                }
                if(c+1<col && mat[r][c+1]==1){
                    if(map.containsKey(r+""+(c+1))) map.remove(r+""+(c+1));
                    mat[r][c+1] = 2;
                    q.add(new Pair(r,c+1)); 
                }
            }
        }
        if(map.size()==0) System.out.println(count);
        else System.out.println("-1");        
    }
}
