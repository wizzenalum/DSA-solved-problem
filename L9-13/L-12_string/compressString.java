import java.util.Arrays;
import java.util.Scanner;
public class compressString{

	public static String getCompressedString(String str) {
		String output = str.substring(0,1);
		int repeatStart =0, i;
		for(i=1;i<str.length();i++){
			if(str.charAt(i)!=str.charAt(repeatStart)){
				if(i-repeatStart>1) output+= i-repeatStart;
				output+=str.charAt(i);
				repeatStart=i;
			}
		}if(i-repeatStart>1) output+= i-repeatStart;

		return output;
	}
	public static void main(String[] args){
		String str = "aaaabbbbbyyyyyyyyyyy";
		System.out.println(getCompressedString(str));
	}

}