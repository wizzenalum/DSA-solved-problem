import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

public class CorrectSentence{
    public static boolean wordCheck(String str) {
        if(str.charAt(0)-'a'<13 && str.charAt(0)-'a'>=0 ){
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i)-'a'>=13 || str.charAt(i)-'a'<0) return false;
            }
        }else if(str.charAt(0)-'N'<13 && str.charAt(0)-'N'>=0 ){
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i)-'N'>=13 || str.charAt(i)-'N'<0) return false;
            }
        }else return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        for (int i = 0; i < tests; i++) {
            int k = scan.nextInt();
            boolean flag = true;
            System.out.println("first "+i+" "+tests+" "+k);
            for (int j = 0; j < k; j++) {
                String str = scan.next();
                System.out.println("second "+j+" "+str);
                boolean check = wordCheck(str);
                if(!check){
                    System.out.println("NO");
                    j = 0;
                    flag = false;
                    break;
                }                
            }
            if(flag)System.out.println("YES");
        }
        scan.close();
    }
}