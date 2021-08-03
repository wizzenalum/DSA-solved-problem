import java.util.Scanner;
public class ArthmaticOperaton{
	public static void main(String[] args){
		int a = 20;
		float b =30f;
		// what is result of following
		double c = 20/30;
		c = 3+2/5;
		System.out.println(c);
		Scanner s = new Scanner(System.in);
		a = s.nextInt();
		b = s.nextFloat();
		c = a+b;
		System.out.println(c);
		String str = s.next();
		System.out.println(str);
		String l = s.nextLine();
		System.out.println(l);

	}
}
