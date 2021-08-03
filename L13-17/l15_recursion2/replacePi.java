import java.util.Arrays;
import java.util.Scanner;
public class replacePi{
	public static String replacepi(String str){
		int len = str.length();
		if(len<=1) return str;
		String check = str.substring(0,2);
		String send = str.substring(2,len);
		if(check.equals("pi")) return 3.14+replacepi(send);
		return str.charAt(0)+ replacepi(str.substring(1,len));		
	}
	public static void main(String[] args){
		String str = "here is Pi = pi thats why pi not pi344";
		System.out.println(replacepi(str));
	}

}