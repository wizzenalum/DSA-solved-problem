import java.util.Scanner;
public class BracketBalance{
	public static boolean isBalanced(String expression) {
        int stack = 0;
        for(int i =0;i<expression.length();i++){
        	if(expression.charAt(i)=='(') stack++;
        	else if(expression.charAt(i)==')' && stack>0) stack--; 
        	else return false; 
        }if(stack == 0) return true;
        return false;
    }
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String str = scan.nextLine();
    	System.out.print(isBalanced(str));

    }
}