/* *********          Good Strings              *********************************
    A good string s is the one which:

    1. contains only these letters of the set: [a,b,c]
    2. s[i] != s[i+1] for all i=1 to s.length-1 (assuming the string is 1-indexed)

    For example, strings "abc", "ac", "b" and "abcbabcbcb" are all good strings and 
    strings "aa", "baa" and "ababbc" are not good strings.
    Given n and k, consider all good string of length n in lexicographical order.
    Print the kth string in the lexicographical order or empty string if there are 
    less than k good strings of length n.

        Input format:
            The first and only line of input contains two space separated integers. 
            These integers denote the value of n and k. 

        Constraints:
            1 <= n <= 10
            1 <= k <= 100
            Time Limit: 1 second

        Output format:
            The first and only line of output prints the kth string in the lexicographical 
            order or empty string if there are less than k good strings of length n. 

        Sample Input 1:
            1 3

        Sample Output 1:
            c

        Explanation:
            There are three good strings of length one: ["a", "b", "c"].

        Sample Input 2:
            1 4

        Sample Output 2:
            [Blank String]

        Explanation:
            There are three good strings of length one: ["a", "b", "c"]. Since, k is 
            four, so, we will print blank string.

        Sample Input 3:
            3 9

        Sample Output 3:
            cab

        Explanation:
            There are 12 good strings of length three: ["aba", "abc", "aca", "acb", "bab", 
            "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. Ninth good string is "cab".

 */

package test9;

import java.util.Arrays;
import java.util.Scanner;

public class GoodString {
    static int count;
    static int k;
    static int[] result;

    public static void countS(int[] arr, int index) {
        if(count==k){
            result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i];
            }
            return ;
        }
        if(index==arr.length){
            count++;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if(index>0 && arr[index-1]==i) continue;
            if(count==k) return;
            arr[index] = i;
            countS(arr,index+1);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        k = s.nextInt();
        s.close();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if(i%2==1) arr[i] = 1;
            //here is assumed 0 as a, 1 as b, 2 as c. 
        }
        count = 0;
        countS(arr, 0);
        if(k==count){
            for (int i = 0; i < arr.length; i++) {
                System.out.print((char)('a'+arr[i]));
            }
        }
        
        // System.out.println(Arrays.toString(arr));
    }
}
