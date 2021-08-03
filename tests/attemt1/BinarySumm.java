package attemt1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.io.IOException;
import jdk.internal.org.jline.utils.Diff;

public class BinarySumm {
    public static void printSum(String str1, String str2) {
        // System.out.println(str1+" "+str2);
        int hasil  = 0, digitSum = 0, i = str1.length()-1,j = str2.length()-1;
        int[] arr = new int[str1.length()];
        for (; j>=0 ;) {
            digitSum = str1.charAt(i--)+str2.charAt(j--)-2*'0'+hasil;
            // System.out.println(digitSum+"  ");
            if(digitSum<2){
                arr[i+1] = digitSum;
                hasil = 0;
            }else if(digitSum==2){
                arr[i+1] = 0;
                hasil = 1;
            }else{
                arr[i+1] = 1;
                hasil = 1;
            }
        }
        while(i>=0){
            digitSum = str1.charAt(i--)+hasil -'0';
            // System.out.println("inst1 "+digitSum);
            if(digitSum<2){
                arr[i+1] = digitSum;
                hasil = 0;
            }else if(digitSum==2){
                arr[i+1] = 0;
                hasil = 1;
            }
            if(hasil==0){
                break;
            }
        }
        if(hasil==0) System.out.print(str1.substring(0, i+1));
        if(hasil==1) System.out.print("1");
        for (int k = 0;k<arr.length; k++) {
            if(k>i)System.out.print(arr[k]);
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader((System.in))); 
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            if(str1.length()> str2.length()) printSum(str1, str2);
            else printSum(str2, str1);
            // System.out.println((int)'0'+" "+2*'1');
        }

    }
}
