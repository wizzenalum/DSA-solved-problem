import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

public class Plagiarism{
    
    public static void printDis(int[] arr, int n, int m) {
        boolean flag = true;
        int[] visit = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            visit[arr[i]]++;
        }
        for (int i = 0; i < visit.length; i++) {
            if(visit[i]>1 && i<=n){
                flag = false;
                System.out.print(i+" ");
            }

        }
        if(flag) System.out.println("0");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        int n = 0;
        int m = 0;
        int k = 0;
        for (int i = 0; i < tests; i++) {
            n = scan.nextInt();
            m = scan.nextInt();
            k = scan.nextInt();
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = scan.nextInt();
            }
            printDis(arr,n,m);
            System.out.println();
        }
        scan.close();
    }
}