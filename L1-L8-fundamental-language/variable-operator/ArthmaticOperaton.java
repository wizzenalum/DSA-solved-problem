import java.util.Scanner;

public class ArthmaticOperaton{
	public static void main(String[] args){
	// 5 math matical operators +,-,*,/,%
		int operand1 = 20, operand2 = 250;
		int sum = operand2+operand1;
		int substract =operand2-operand1;
		int multiple =operand2*operand1;
		int devidend =operand2/operand1;
		int remainder =  operand2/operand1;
		System.out.println("sum "+sum+" substract "+substract+" multiple "+multiple+" devidend "+devidend+" remainder "+remainder);
	// division in case of floating points.
		float operand3 = 20, operand4 = 250;
		// and why 1/10+2/10!=3/10
		System.out.println("float devidend = "+(operand4/operand3)+" 1/10 + 2/10   = "+(1.0/10.0+2.0/10.0)+"  3/10 "+(3.0/10.0));
		// int a = 20;
		// float b =30f;
		// // what is result of following
		// double c = 20/30;
		// c = 3+2/5;
		// System.out.println(c);

	}
}
