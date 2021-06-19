import java.util.*;

public class batmanvsjoker {

    public static void main(String args[]) {
    	Stack<Integer> st = new Stack<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0, value = 0;
        for(int i = 0; i<n;i++){
            value = scan.nextInt();
            if(!st.isEmpty() && value>st.peek()){
                while(!st.isEmpty() && value>st.peek()){
                    st.pop();
                    sum = (sum+value)%1000000007; 
                }
            }
            st.push(value);
  
            
        }
        scan.close();
        System.out.println(st.toString());
        System.out.println(sum);
    }

}