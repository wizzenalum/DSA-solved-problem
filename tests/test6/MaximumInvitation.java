import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.HijrahEra;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// import org.graalvm.compiler.nodes.ReturnNode;

// import jdk.internal.vm.annotation.Hidden;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
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

public class MaximumInvitation  {
    public static int maxRectangle(int[][] mat) {
        int max_height = 0, max_width = 0;
        int[] arr = new int[mat[0].length]; 
        for (int i = 0; i < mat.length; i++) {
            // System.out.print("for loop i = "+i+" ");

            int height = 0, width = 0, h = 0, w = 0,top; // here perimeter = 2*height+2*width; that is why i didnt take peremeter varable
            arr = mat[i];
            Stack<Integer> st = new Stack<>();
            int j = 0;
            for (; j < arr.length; j++) {
                // System.out.print("inner "+j+" ");
                while(!st.isEmpty() && arr[st.peek()]>arr[j]){
                    top = st.pop();
                    h = arr[top];
                    w = st.isEmpty()?j:j-1-st.peek();
                    // System.out.print(" w "+top+" "+h+" "+w);
                    if(height+width< h+w){// compersion of perimeter/2 
                        height = h;
                        width = w;
                    }
                }st.push(j);
            }
            while(!st.isEmpty()){
                top = st.pop();
                h = arr[top];
                w = st.isEmpty()?j:j-1-st.peek();
                // System.out.print(" w "+top+" "+h+" "+w);
                if(h!=0&& w!=0&&height+width< h+w){// compersion of perimeter/2 
                    height = h;
                    width = w;
                }
            }
            // System.out.println(" "+height+" "+ width);
            if(height!=0 && width!= 0 && max_height+max_width<height+width){
                max_height = height;
                max_width = width;
            }
        }
        // System.out.println(max_height+" "+max_width);
        return 2*(max_height+max_width);
    }
    public static void main(String[] args) {
        // Systemprintln("love");
        FastReader input = new FastReader();
        int r = input.nextInt();
        int c = input.nextInt();
        String[] mat = new String[r];
        for (int i = 0; i < mat.length; i++) mat[i] = input.nextLine();
        // creating histogram form matrix;
        int[][] histMat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(mat[i].charAt(j)=='.'){
                    if(i!=0) histMat[i][j] = histMat[i-1][j]+1;
                    else histMat[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < histMat.length; i++) {
            System.out.println(Arrays.toString(histMat[i]));
        }

        int maxPerimeter = maxRectangle(histMat);
        System.out.println(maxPerimeter-1);
    }
}
