import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;

public class GenedyAndExplosiionString {
    static class Pair{
        // this will help me to track on which location in explosion strng
        int i;
        char c;
        Pair(int i, char c){
            this.i = i;
            this.c = c;
        }
    }
	
	public static void main(String[] args) throws IOException{
		String  str = "5612a5712a12abb122ab";
        String exp = "12ab";
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // String str = bf.readLine();
        // String exp = bf.readLine();
        // Stack<Pair> st = new Stack<>();
        // String current = "", temp = "";
        // if(exp.length()<=0){
        //     System.out.println(str);
        //     return;
        // }
        // way one
        // for (int i = 0; i < str.length(); i++) {
        //     // System.out.print("start "+ str.charAt(i)+" "+ st.isEmpty());
        //     if(!st.isEmpty() && exp.charAt(st.peek().i+1)==str.charAt(i)){
        //         if(st.peek().i+1==exp.length()-1){ 
        //             for (int j = 0; j < exp.length()-1; j++) st.pop();
        //             // if(!st.isEmpty()) System.out.print(" poping the  "+st.peek());
        //         }
        //         else{
        //             st.push(new Pair(st.peek().i+1,str.charAt(i)));
        //             // System.out.print(" st add other "+(st.peek().i+1));
        //         }
        //     }else if(str.charAt(i)==exp.charAt(0)){
        //         if(exp.length()!=1){
        //             st.push(new Pair(0,str.charAt(i)));
        //             // System.out.print(" st add first ");
        //         }
        //     }else{
        //         while(!st.isEmpty()){
        //             temp = st.pop().c+temp;
        //         }
        //         current = current+temp+str.charAt(i);
        //         // System.out.print(" current add  " + current);
        //         temp = "";
        //     }
        //     // System.out.println();
        // }
        // temp = "";
        // while(!st.isEmpty()){
        //     temp = st.pop().c+temp;
        // }
        // current = current +temp;
        // if(current.equals("")) System.out.println("FRULA");
        // else System.out.println(current);

        // way 2
        Scanner scan = new Scanner(System.in);
        // String str = scan.next();
        // String exp = scan.next();
        scan.close();
        Stack<Character> stk = new Stack<>();
        for (int i = str.length()-1;i>=0; i--) {
           stk.push(str.charAt(i));
           int j = 0;
           if(stk.size()>=exp.length() && stk.peek()==exp.charAt(0)){
              for(j=1;j<exp.length();j++){
                  if(stk.get(stk.size()-j-1)!=exp.charAt(j)) break;
              } 
              if(j==exp.length()){
                  for(j=0;j<exp.length();j++) stk.pop();
              }
           }
        }
        if(stk.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        // way 1 to print string, this is'nt work because string cretion took so much time that time errrors are appear.
        // while(!stk.isEmpty()){
        //     temp = temp+stk.pop();
        // }
        // System.out.println(temp);
        //way 2 to print output
        while(!stk.isEmpty()) System.out.print(stk.pop());
	}                                                                                                                           

}








