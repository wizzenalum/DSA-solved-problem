import java.util.Scanner;
import java.util.Arrays;
public class learning{
	public static void main(String[] args){
	// creating string.
		// by litral and new key word.
	// 	String k = "hi this is it";
	// 	// jvm check string present or not then create or rference it.
	// 	String g = new String("hi this is it"); 
	// 	// it always create new string
	// //concatinating strings by concat and + sign.
	// 	String c1 = k.concat(g);// is only concate String object type data type.
	// 	System.out.println("c1 = "+c1);
	// 	int a =5;
	// 	String c2 = a+" "+g;
	// 	//+ can concate deferent type of data tyes.
	// 	System.out.println("c2 = "+c2);
		// System.out.println(g.concat(a)); 
		//error: incompatible types: int cannot be converted to String
	// equating to strings.
		// String b = "hi";
		// String c = "hi";
		// System.out.println(c.equals(b));   // true
		// System.out.println(c==b);    //true
		// String b = new String("hi");
		// String c = "hi";
		// System.out.println(c.equals(b)); //true
		// System.out.println(c==b);  // false
		// String b = new String("hi");
		// String c = new String("hi");
		// String d = new String("Hi");
		// System.out.println(c.equals(b));  //true
		// System.out.println(c.equalsIgnoreCase(d)); // true
		// System.out.println(c==b); // false 
		// // its answer lies in how array created and how  both eqatinfgs work.
		// String example = "This is the \"String\" class.";
		// System.out.println(example); //backspace used for esapicing.
		// // java strings are immutable
		// System.out.println(example.charAt(1));
		// System.out.println(example.codePointAt(4)); // return asscii value
	// compare to function.
		// String str1 = "Learn Java";
  //       String str2 = "Learn Javz"; 
		// int result = str1.compareTo(str2);
		// System.out.println("coompareto method = "+result);
		// System.out.println(str1.toLowerCase());	
		// char[] charr = str2.toCharArray();
		// System.out.println(Arrays.toString(charr));
		// System.out.println(str1.replace("Java","Python"));
		// System.out.println(str1.indexOf('a',4));
		// String vowels = "a+e+f+gs";
		// String[] strarr1 = vowels.split("\\+");
		// System.out.println(Arrays.toString(strarr1));
		// String[] strarr2 = vowels.split("\\+",2);
		// System.out.println(Arrays.toString(strarr2));
		// float f = 23.4f;
		// System.out.println(String.valueOf(f));
		// char ch[] = {'p', 'r', 'o', 'g', 'r', 'a', 'm'};
	 //    int offset = 2;
	 //    int length = 4;
	 //    String result;

	 //    // subarray {'o', 'g', 'r', 'm'} is converted to string
	 //    result = String.valueOf(ch, offset, length);
	 //    System.out.println(result);
		// String str = "hey abby, hey switheart, hey humingbird";
		// System.out.println(str.replace("hey","love you"));
		// System.out.println(str.replaceAll("hey","love you"));
		// System.out.println(str.replaceFirst("hey","love you"));
		String str = "abby";
		System.out.print(str.indexOf('b',0));

		// StringBuffer strb =  new StringBuffer("not");
		// System.out.print("abby"+strb);

		}


}