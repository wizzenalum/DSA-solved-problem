/* ***********************      Number of groups      *************************
    You are given an array A of strings.
    An operation on string S is defined as swapping of any two even indexed 
    characters of S, or any two odd indexed characters of S.
    Two strings S and T are called compatible with each other, if by performing 
    any number of operations on S, S can be made equal to T.
    For example, S="noddy" and T="ddnoy" are compatible to each other because 
    we make following operations "noddy" -> "dondy" -> "ddnoy" that swaps S[0] 
    with S[2] and then S[1] with S[3].
    Now, a group of compatible strings from A is a non empty subset of A such that:
        1. Each pair of strings in the group are compatible. 
        2. The group is the largest size possible (i.e. there is no other string in 
            the array, which is compatible with all the stings of the group)
    You have to return the number of such groups in the array A.
    
        Input Format:
            The first line of input contains an integer, that denotes the size of 
            the array. Let it be denoted by the symbol n.
            Each of the following n lines contains a strings, that constitute array A.

        Constraints:
            1 <= A.length <= 1000
            1 <= A[i].length <= 20
            All A[i] have the same length.
            All A[i] consist of only lowercase letters.
            Time Limit: 1 second

        Output format:
            The first and only line of output contains count of groups of compatible strings in A.

        Sample Input 1:
            6
            pqrs 
            rqps 
            psrq 
            noddy 
            ddnoy 
            nydod

        Sample Output 1:
            3

        Explanation:
            One group is ["pqrs", "rqps", "psrq"], as all are pairwise compatible. 
            The other two groups are ["noddy", "ddnoy"] and ["nydod"].  
            Note that in particular, "nydod" is not compatible to "noddy".

        Sample Input 2:
            6
            abc
            acb
            cba
            cab
            bac
            bca

        Sample Output 2:
            3
 */

package test9;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;


public class NumberOfGroups {
    public static boolean test(String str1, String str2){
        // wrong method to do this problem.
        if(str1.length()!=str2.length()) return false;
        boolean[] check = new boolean[str1.length()];
        for (int i = 0; i < check.length; i++) {
            boolean flag = true;
            if(str1.charAt(i)!=str2.charAt(i) && !check[i]){
                for (int j = i+1; j < check.length; j++) {
                    if(!check[j]){
                        if( str1.charAt(i)==str2.charAt(j)
                            && str1.charAt(j)==str2.charAt(i)
                            && i%2==j%2){ 
                                check[j] = true;
                                check[i] = true;
                                flag = false;
                                break;
                            }
                    }
                }
                if(flag){return false;}
            }
        }
        // System.out.println(Arrays.toString(check));
        return true;
    }
    public static void method1(String[] arr,int n) {
        ArrayList<String> group = new ArrayList<>();
        if(n>0)group.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            boolean inGroup = false;
            for (int j = 0; j < group.size(); j++) {
                if(test(group.get(j),arr[i])){ // test function condition
                    inGroup = true;
                }
            }
            if(!inGroup) group.add(arr[i]);
        }
        System.out.println(group.size());
    }

    // method 2
    public static boolean test1(String str1, String str2) {
        if(str1.length()!=str2.length()) return false;
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0; i<str1.length();i +=2){
            // System.out.println(Arrays.toString(arr)+Arrays.toString(arr2));
            System.out.println(str1.charAt(i)+" "+ str2.charAt(i));
            arr[str1.charAt(i)-'a']++;
            arr[str2.charAt(i)-'a']--;
            if(i+1<str1.length()){
                arr2[str1.charAt(i+1)-'a']++;
                arr2[str2.charAt(i+1)-'a']--;
            }
        }
        // System.out.println(Arrays.toString(arr)+Arrays.toString(arr2));
        for (int i = 0; i < 26; i++) {
            if(arr[i]!=0 || arr2[i]!=0) return false;
        }
        return true;  
    }
    public static void method2(String[] arr,int n) {
        ArrayList<String> group = new ArrayList<>();
        if(n>0)group.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            boolean inGroup = false;
            for (int j = 0; j < group.size(); j++) {
                if(test1(group.get(j),arr[i])){ // test function condition
                    inGroup = true;
                }
            }
            if(!inGroup) group.add(arr[i]);
        }
        System.out.println(group.size());
    }

    // another way with method 2
    public static void method3(String[] arr, int n){
        Set set = new HashSet<>();
        for(String s:arr){
            String even = "", odd = "";
            for (int i = 0; i < s.length(); i++) {
                if(i%2==0) even+=s.charAt(i);
                odd+=s.charAt(i);
            }
            char[] o = odd.toCharArray();
            char[] e = even.toCharArray();
            Arrays.sort(o);
            Arrays.sort(e);
            set.add(new String(o)+ new String(e));
        }
        System.out.println(set.size());
    }
    public static void main(String[] args)  throws IOException{
        // System.out.println(test1("noddy","ddnoy"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0;i<n;i++) arr[i] = br.readLine();
        br.close();
        // method1(arr,n);  // wrong method don't know where test fails
        // method2(arr,n);
        method3(arr,n);

    }
}
