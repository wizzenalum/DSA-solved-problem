package fullTest3;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCost {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int cost = 0,i=n-1;
        while(i >=2) {
            // System.out.println("in  "+i);
            cost += arr[i]+arr[i-1];
            i-=3;
        }
        if(i==1){
            cost+=arr[0]+arr[1];
        }else if(i==0) cost+= arr[0];
        System.out.println(cost);
    }
}
