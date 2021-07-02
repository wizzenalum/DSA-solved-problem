package fulltest1;

import java.util.Stack;

public class backspaceProblem {
    public static String backspace(String s){
        Stack<Character> st = new Stack<Character>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='#') st.push(s.charAt(i));
            else{
                if(!st.isEmpty()) st.pop();
            }
        }
        while(!st.isEmpty()){
            result = st.pop()+result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(backspace("abdfass#fga#sag##ga####"));
    }
}
