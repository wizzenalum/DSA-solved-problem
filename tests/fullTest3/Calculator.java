package fullTest3;

import java.util.Scanner;
import java.util.Stack;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class Calculator {
    public static int solvePrt(Stack<String> st){
        int ans = 0,num = 0;
        while(!st.empty()){
            if(st.peek().charAt(0)>47 && st.peek().charAt(0)<59){
                num = Integer.parseInt(st.pop());
                if(st.empty()) return ans+num;
                if(st.peek().equals("+")) st.pop();
                if(st.peek().equals("-")){
                    num = -1*num;
                    st.pop();
                }
                if(!st.empty() && st.peek().equals("(")){
                    st.pop();
                    return ans+num;
                }
            }
            ans +=num;
        }
        return ans;
    }
    public static int solve(String exp) {
        int ans = 0;
        Stack<String> st = new Stack<>();
        for(int i = 0;i<exp.length();i++){
            if(exp.charAt(i)!=')'){
                if(!(exp.charAt(i)>47 && exp.charAt(i)<59)){
                    st.push(exp.substring(i,i+1));
                }
                else{
                    int end = i+1;
                    while(end<exp.length()&&exp.charAt(end)>47 && exp.charAt(end)<59) end++;
                    st.push(exp.substring(i, end));
                    i = end-1;
                }  
            }
            else{
                int temp = solvePrt(st);
                st.push(temp+"");
            }
        }
        if(!st.empty()){
            ans = solvePrt(st);
        }
        // System.out.println(st.subList(0, st.size()));
        // System.out.println(st.pop()+" "+st.pop()+" "+Integer.parseInt(st.pop()));
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        System.out.println(solve(str));
        // System.out.println((int)('0')+" "+ (int)'9'+ " "+" "+Integer.parseInt("+345"));

        // System.out.println((int)('0')+" "+ (int)'9'+ " ");

    }    
}
