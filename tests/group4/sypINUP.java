/*  Spy Among Us
Send Feedback
The Director of RAW (Research and Analysis Wing) has uncovered intel that one of the agents under him is actually a mole (spy for the competitor).
Ninja is the most trusted agent under him. He assigns Ninja the task of figuring out who the mole is.
Ninja is an excellent detective who has figured out a simple algorithm to find out who the mole is. The mole will be a person who trusts nobody in the team, yet is trusted by everyone else. He gives each agent a code-name from 1 to N.
Find out the mole and return his code-name. If not found, return -1.
Input Format:

First line of input contains two space separated integers representing total number of agents (N), and the number of trust relationships (T)
Next T lines contain two space separated integers x and y, representing that x has complete faith over y.

Constraints:

1 <= N <= 1000
1 <= T <= 10000

Output Format:

Code-name of the mole.

Sample Input:

4 5
1 3
1 4
2 3
2 4
4 3

Sample Output:

3

 */
package group4;
import java.util.*;
import java.io.*;
public class sypINUP {
    
    static public int findMole(int N, int[][] trust) {
        int mole = -1;
        boolean[] check = new boolean[N+1];
        check[0] = true;
        for (int i = 0; i < trust.length; i++) {
            check[trust[i][0]] = true;
        }
        for (int i = 0; i < check.length; i++) {
            if(check[i]==false) mole = i;
        }

        
        return mole;
        // Write your code here
    
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[] strNums = br.readLine().trim().split(" ");
        int N = Integer.parseInt(strNums[0]);
        int T = Integer.parseInt(strNums[1]);

        int[][] trust = new int[T][2];

        for (int i = 0; i < T; i++)
        {
            String[] strNums1 = br.readLine().trim().split(" ");
            int x = Integer.parseInt(strNums1[0]);
            int y = Integer.parseInt(strNums1[1]);
            trust[i][0] = x;
            trust[i][1] = y;
        }

        System.out.println(findMole(N, trust));
    }

}
