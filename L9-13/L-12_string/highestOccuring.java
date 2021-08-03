import java.util.Arrays;
import java.util.Scanner;
public class highestOccuring{
	public static char highestOccuringChar(String str) {
		int[] frequancy = new int[256];
		for(int i =0;i<str.length();i++) frequancy[str.codePointAt(i)]++;
		int max =0;
		for(int i =0;i<frequancy.length;i++){
			if(frequancy[i]>frequancy[max]) max = i;
		}return (char)max;
		
	}
	public static void main(String[] args){
		String str = " aabbyyyyyaby";
		System.out.println(highestOccuringChar(str));
	}

}