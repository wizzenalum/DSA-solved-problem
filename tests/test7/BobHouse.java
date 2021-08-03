import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Stack;
import java.io.IOException;

// import jdk.incubator.jpackage.main.CommandLine.Tokenizer;
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
class Hold{
    int cnt;//countCol;
    int v; //preLeftCell;
    int h; //histPreLeftCell;
    long ms; // last cont
    Hold(int countCol, int preLeftCell, int histPreLeftCell,long ms){
        this.cnt = countCol;
        this.v=preLeftCell;
        this.h=histPreLeftCell;
        this.ms = ms;
    }
}
public class BobHouse {
    public static void main(String[] args) {
        FastInput scan = new FastInput();
        int n = scan.nextInt(), m = scan.nextInt();
        int[][] hf = new int[n][m], hist = new int[n][m];
        for (int i = 0; i < n; ++i) { 
            for (int j = 0; j < m; j++) {
                hf[i][j] = scan.nextInt();
            }
        }
        long ans = 0;
        // here solution starts
        for (int i = 0; i < n; i++) {
            Stack<Hold> st = new Stack<>();
            st.push(new Hold(0,-1,0,0));
            for (int j = 0; j < m; j++) {
                hist[i][j] = 1;
                if(i>0&& hf[i-1][j] == hf[i][j]) hist[i][j] += hist[i-1][j];
                
                int colSum = 1;
                while(st.peek().v == hf[i][j] && st.peek().h>= hist[i][j]){
                    colSum+=st.pop().cnt;
                }
                long my_s = colSum*(long)hist[i][j];
                System.out.print(my_s+"  "+colSum+" "+hist[i][j]+" || ");
                if(st.peek().v == hf[i][j]) my_s+= st.peek().ms;
                ans += my_s;
                // if(i==1 && j == 1){
                //     // System.out.println("get in");
                //     for (int k = 0; k < n; k++) {
                //         System.out.println(Arrays.toString(hist[k]));
                //     }
                // }
                st.push(new Hold(colSum,hf[i][j],hist[i][j],my_s));

            }
            System.out.println();
            
        }
        System.out.println(ans);
    }
}
