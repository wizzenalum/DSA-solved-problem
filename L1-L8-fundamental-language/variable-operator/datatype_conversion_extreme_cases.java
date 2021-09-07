//**** litrals and data Type *********************************************************************
/*############################################################################
        aim:- to know in which data types calculation ocuures. 
        aim:- type casting from char to int of others.
        aim:- effects of max values
#############################################################################*/

public class datatype_conversion_extreme_cases{
	public static void main(String[] args) {
//test 1 checking what happens in int and char conversion and operator use.
		// int num1 = 97,num2 = 100;
		// char char1 = 'A',char2 = 'Z';  // ascii values 65 and 90
	//1. equating character variable to the integer variable.
		// char1 = num1;  
		// System.out.print(cahr1);
	// error int to char conversion 
	// 	char1 = (char) num1;
	// 	System.out.println(char1);//no error
	// // means we just need to type cast expicitly the problem was storage size.
	//2. equating integer variable to character variable.
		// num1 = char1; 
		// System.out.print(num1);
	// converts the character to ascii value to integer.
	//3. adding characters ans integers
		// char1 = char2+num1; // error of int to char conversionn
		// char1 = char2 + char1; // error of int to char conversion
		// System.out.print(char1);
		// num1 = char1+char2;
		// System.out.print(num1);
//test2 if we use short insted of int than this conversion porblem may not be there.
		short num1 = 97,num2 = 100;
		char char1 = 'A',char2 = 'Z';
	//1. equating character variable to the short variable.
		char1 = num1;//error short to char conversion even both have same space. 
		char1 = (char)num1;  // NO Error
		System.out.print(char1);
	
	//2. equating integer variable to character variable.
		// num1 = char1; 
		// System.out.print(num1);
	// error: incompatible types: possible lossy conversion from char to short
	//3. adding characters ans integers
		// char1 = char2+num1; // error of int to char conversionn
		// char1 = char2 + char1; // error of int to char conversion
		// System.out.print(char1);
		// num1 = char1+char2; //error: incompatible types: possible lossy conversion from int to shor
		// System.out.print(num1);	
		// num1 = num1+num2;//error: incompatible types: possible lossy conversion from int to short
		// System.out.print(num1);
//test3 all data types to char and boolean conversion. to know is it spce probelme or somehing else.
		// int num1 = 97;
		// char char1 = 'A';
		// char1 = num1; //error: incompatible types: possible lossy conversion from byte/int/double/long/float/boolean/short to char.
		// char1 = 97;

		// System.out.print(char1);
//test4 what happens at extreme values
	// what happens if we add max. value with int/byte/double/float/
		// char unicode = 65536;
		// int unicode = 0x007F;
		// System.out.print(unicode);
//****test 5extreme ends *********************************************************************
	// 1. what happens if we assign big number in byte,int,float,etc.
		int maxint = Integer.MAX_VALUE;
		// int big = 2147483648;//error: integer number too large
	//because number is bigger.
		// byte big = 2147483648; //error: integer number too large
	// nuber is big, this message prove that number litral is integer.
		// byte big = 214748364;//error: incompatible types: possible lossy conversion from int to byte
	// number litral can fit into integer bu cant fit into byte when we assigning.
		// long big = 2147483648; //error: integer number too large
	//  number litral can fit in long but it is not going to fit number litral. so use L at the end.`
		// long big = 2147483648L; //NO Error
		long maxlong  =Long.MAX_VALUE;
		// long big =9223372036854775808L; // error: integer number too large
	// never gonna say litral is long type always says integer litrals
		// float big= 5040.50;//error: incompatible types: possible lossy conversion from double to float
	// because litral in double and we converting it to float.
	//you can convert litral into float by adding f or use type casting.
		float maxfloat = Float.MAX_VALUE;
		// float big = 3.4028235E39f; //error: floating point number too larg
		// System.out.print(big);
	//2. what happen when we play wiht operators.
		// byte bigb = Byte.MAX_VALUE +1;//error: incompatible types: possible lossy conversion from int to byte
		// short bigs = Short.MAX_VALUE+1;//error: incompatible types: possible lossy conversion from int to short
		int bigi = Integer.MAX_VALUE+2147483647;// No error
	//it start cycling the value of int from +ve to -ve.
		long bigl = Long.MAX_VALUE +1;//no error it also start looping.
		
		float bigf = Float.MAX_VALUE+3.4028235E30f;// upto thisnumber no error
	//after increase one more power its return infinite not any error.
		double bigd = Double.MAX_VALUE +3.4028235E291;// error upto this point
	// as we increase one more power return infinity.
		System.out.print(bigd);

/*############################################################################
									CONCLUSION
		1. char stored in from of unicode that can be converted to integer, if 0<=number<65535. because after
			it shows some short of sorogate phinomena or character bomb. but reverse not possible.
		2. boolean can't convert in any other datatype and not even any litrals.
		3. when we aply operators then each litral use its default types numbers are int, decimals are double,
			char is char, 
		4. we can'nt assign bigger numbers what a data type can't hold, but during the operations expression give bigger 
			number then int, long start cycle through it.
		5. float and double give infinity as they reachs it s thresolds.
		#############################################################################*/		
// what is meaning of returning the infinity
// question nuber litral is assmed to be int as we see it when we convert boolean i = 97;execute. then why this integer litral converts to char.
	}
}