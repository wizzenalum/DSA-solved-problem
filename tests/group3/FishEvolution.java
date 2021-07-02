package group3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
/*  Fish Evolution
Send Feedback
Namita has magical fishes. Her fishes has the capability to evolve to become bigger fish. So, if the smaller fish touches a bigger or equivalent fish, then the bigger or equivalent fish disappears into water and the smaller fish evolves to become as large as the larger fish. Therefore, to avoid stray evolutions, she has kept her fishes in separate cells, arranged in a linear order. Now, she wants to evolve only one fish and she wants to choose the fish which will evolve maximum number of times. She wants your help in this. To make it more interesting, she has added signs of evolution with the fish cells. A cell assigned with +1 can only evolve with fishes on its right side and a cell assigned with -1 can only evolve with fishes on its left side. Can you complete this challenge?
Remember that the fishes are mindlessly evolving. This means that they evolve with the first big fish that comes in their way. Consider the following case. Here, Fish with size 5 can evolve in right direction.
5 12 10 11 13
Fish with size 5 will evolve 2 times like 5 -> 12 -> 13 and not 3 times like 5->10->11->13.
Note: If there is more than one fish which can evolve the maximum number of times, select the one with the greater size.
Input Format:

First line of input contains an integer t, representing the number of test cases.
For each test case, the first line contains an integer n, representing the number of fishes.
Second line of each case contains n space separated integers, representing the size of fishes.
Third line of each test case contains n space separated integers, being +1 or -1, representing the signs of evolution.

Constraints:

1 <= t <= 150
1 <= n <= 10^4
1 <= arr[i] <= 10^4
directions[i] = -1 or 1
Time Limit : 1 second

Output Format:

For each test case, you have to print the size of fish which will evolve maximum number of times, along with the direction it is going to evolve in. (Left for -1 and Right for +1)

Sample Input 1:

1
10
5 1 4 12 10 8 11 9 18 88
1 1 -1 -1 1 -1 1 -1 -1 -1

Sample Output 1:

1 Right

Explanation:

1 can evolve 4 times with 4, 12, 18, 88

Sample Input 2:

1
12
30 20 5 2 4 12 10 8 11 3 18 88
1 1 1 1 -1 -1 1 1 1 -1 -1 -1

Sample Output 2:

3 Left

Explanation:

2 can evolve 4 times with 4 -> 12 -> 18 -> 88
3 can also evolve 4 times with 11 -> 12 -> 20 -> 30
3 is greater than 2, hence the answer is 3 Left.

 */

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
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class FishEvolution {
    public static void main(String[] args) {
        FastInput s = new FastInput();
        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[] fish = new int[n];
            int[] dir = new int[n];
            for (int j = 0; j < n; j++) fish[j] = s.nextInt();
            for (int j = 0; j < n; j++) dir[j] = s.nextInt();
            // System.out.println(Arrays.toString(dir));
            Stack<Pair> st = new Stack<>();
            int maxValue = 0; int num = 0, fishNum = -1;
            boolean directionLeft = true;
            for(int j = 0; j < n; j++) {
                // System.out.println(j);
                if(dir[j]==-1){
                    // System.out.print(j+" start ");
                    if(!st.isEmpty()&& st.peek().first< fish[j]){
                        if(st.size()>num){
                            fishNum = st.peek().first;
                            num = st.size();
                            maxValue = st.peek().second;
                        }else if(st.size()==num && st.peek().second>maxValue){

                            fishNum = st.peek().first;
                            maxValue = st.peek().second;
                        }
                        while(!st.isEmpty() && st.peek().first<fish[j]) st.pop();
                    }
                    if(st.isEmpty()) st.add(new Pair(fish[j],fish[j]));
                    else{
                        st.add(new Pair(fish[j],st.peek().second));
                    }
                    // System.out.print(st.peek().first+" "+st.peek().second+" "+num+" "+maxValue+" "+fishNum);
                    
                }
            }
            if(!st.isEmpty()){
                if(st.size()>num){
                    fishNum = st.peek().first;
                    num = st.size();
                    maxValue = st.peek().second;
                }else if(st.size()==num && st.peek().second>maxValue){
                    fishNum = st.peek().first;
                    maxValue = st.peek().second;
                }
            }
            st.clear();

            for (int j = n-1; j < 0; j--) {
                if(dir[j]==1){
                    if(!st.isEmpty()&& st.peek().first< fish[j]){
                        if(st.size()>num){
                            directionLeft = false;

                            fishNum = st.peek().first;
                            num = st.size();
                            maxValue = st.peek().second;
                        }else if(st.size()==num && st.peek().second>maxValue){
                            directionLeft = false;
                            fishNum = st.peek().first;
                            maxValue = st.peek().second;
                        }
                        while(!st.isEmpty() && st.peek().first<fish[j]) st.pop();
                    }
                    if(st.isEmpty()) st.add(new Pair(fish[j],fish[j]));
                    else{
                        st.add(new Pair(fish[j],st.peek().second));
                    }
                }
            }
            if(!st.isEmpty()){
                if(st.size()>num){
                    fishNum = st.peek().first;
                    num = st.size();
                    maxValue = st.peek().second;
                }else if(st.size()==num && st.peek().second>maxValue){
                    fishNum = st.peek().first;
                    maxValue = st.peek().second;
                }
            }
            st.clear();

            if(!directionLeft) System.out.println(fishNum+" Right");
            System.out.println(fishNum+" Left");
        
        }
    }
}
