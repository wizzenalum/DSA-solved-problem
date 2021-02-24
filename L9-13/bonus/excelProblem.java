import java.util.Arrays;
import java.util.Scanner;
public class excelProblem{
	public static int alphabetToNumeralPattern(String alphabetPattern){
		int base = 1, output = 0;
		for(int i=alphabetPattern.length()-1; i>=0;i--){
			output+=(alphabetPattern.charAt(i)-64)*base;
			base *=26;
		}return output;
	}

	public static String numeraltoAlphabetPattern(int numeralPattern){
		String send = "";
		int digit =0;
		while(numeralPattern!=0){
			digit = numeralPattern%26==0?26:numeralPattern%26;
			send = (char)(digit+64)+send;
			numeralPattern /=26;
		}
		return send;
	}
	

	public static void main(String[] args){
		Scanner scan =  new Scanner(System.in);
		System.out.println("enter any excel sequance like AA,AAAAZZ etc");
		String str = scan.next();
		System.out.println("column no. =" + alphabetToNumeralPattern(str));
		System.out.println("enter column number");
		int n = scan.nextInt();
		String output = numeraltoAlphabetPattern(n);
		System.out.println("excel sequance is = "+ output);

	
	}

}