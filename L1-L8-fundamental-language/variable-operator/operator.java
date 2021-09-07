public class operator{
	public static void main(String[] args) {
	// arthmatics for except integers.
		// byte num = 15;
		// num = num+num;
		// System.out.println(num);
		// //error: incompatible types: possible lossy conversion from int to byte
		// short num = 15;
		// num = num-num;
		// System.out.println(num);
		// //error: incompatible types: possible lossy conversion from int to short
		// long num = 15;
		// num = num*num;
		// System.out.println(num);// work fine
		// float num = 15;
		// num = num-num+2.3;  //error: incompatible types: possible lossy conversion from double to float
		// System.out.println(num);

		// int big = Integer.MAX_VALUE;
		// System.out.println("value "+ big+" in binary form"+Integer.toString(big,2));	
		// big = big<<2;
		// System.out.println("value "+ big+" in binary form"+Integer.toString(big,2));	
		// int num= 0b0101;

		










		



		int num = 0b101;
		int num1  = 5;
		System.out.println("value "+ num+" in binary form"+Integer.toString(num,2));
		System.out.println("value "+ num1+" in binary form"+Integer.toString(num1,2));	
		num = ~num;
		num1  = ~num1;
		System.out.println("value "+ num+" in binary form"+Integer.toString(num,2));
		System.out.println("value "+ num1+" in binary form"+Integer.toString(num1,2));






		// int kim = (num++)+5+(num);
		// System.out.print(kim+" "+num);
		// float a = 522450.20f;
		// float b = sqrt(a);
		// System.out.println(b);
		// System.out.print(b*b);

	}
}