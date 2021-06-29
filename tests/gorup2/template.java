package gorup2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

public class template {
    public static void main(String[] args) {
        FastInput s = new FastInput();
        int n = s.nextInt();
        int[] arr = new int[n];
        String a = s.nextLine();
        for (int i = 0; i < n; i++) arr[i] = s.nextInt();
        System.out.println(Arrays.toString(arr));
    }
}
