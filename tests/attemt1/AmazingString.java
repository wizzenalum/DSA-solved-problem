package attemt1;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.io.IOException;
public class AmazingString {
    public static String amazingStrings(String first, String second,String third) {
		int[] arr = new int[26];
        for (int i = 0; i < first.length(); i++) {
            arr[first.charAt(i)-'A']++;
        }
        for (int i = 0; i < second.length(); i++) {
            arr[second.charAt(i)-'A']++;
        }
        for (int i = 0; i < third.length(); i++) {
            arr[third.charAt(i)-'A']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0) return "NO";
        }
        return "YES";
	}
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in))); 
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String[] strs = br.readLine().split(" ");
            System.out.println(amazingStrings(strs[0],strs[1],strs[2]));
        }


    }
}
