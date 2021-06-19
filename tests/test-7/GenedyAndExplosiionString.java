import java.util.Scanner;
import java.util.Stack;


public class GenedyAndExplosiionString {
    static class Pair{
        int i;
        char c;
        Pair(int i, char c){
            this.i = i;
            this.c = c;
        }
    }
	
	public static void main(String[] args) {
		String  str = "5612a5712a12abb122ab";
        String exp = "12ab";
        Stack<Pair> st = new Stack<>();
        String current = "", temp = "";
        if(exp.length()<=0){
            System.out.println(str);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // System.out.print("start "+ str.charAt(i)+" "+ st.isEmpty());
            if(!st.isEmpty() && exp.charAt(st.peek().i+1)==str.charAt(i)){
                if(st.peek().i+1==exp.length()-1){ 
                    for (int j = 0; j < exp.length()-1; j++) st.pop();
                    // if(!st.isEmpty()) System.out.print(" poping the  "+st.peek());
                }
                else{
                    st.push(new Pair(st.peek().i+1,str.charAt(i)));
                    // System.out.print(" st add other "+(st.peek().i+1));
                }
            }else if(str.charAt(i)==exp.charAt(0)){
                if(exp.length()!=1){
                    st.push(new Pair(0,str.charAt(i)));
                    // System.out.print(" st add first ");
                }
            }else{
                while(!st.isEmpty()){
                    temp = st.pop().c+temp;
                }
                current = current+temp+str.charAt(i);
                // System.out.print(" current add  " + current);
                temp = "";
            }
            // System.out.println();
        }
        temp = "";
        while(!st.isEmpty()){
            temp = st.pop().c+temp;
        }
        current = current +temp;
        if(current.equals("")) System.out.println("FRULA");
        else System.out.println(current);

	}                                                                                                                           

}