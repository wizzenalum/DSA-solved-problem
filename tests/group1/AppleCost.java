import java.util.*;

public class AppleCost {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++) arr[i] = scan.nextInt();
        Arrays.sort(arr);
        int index = n-3, cost = 0;
        while(index>=0){
            cost += arr[index+1]+arr[index+2];
            index -= 3;
        }
        index = index+2;
        if(index>0) cost+=arr[1]+arr[0];
        else if(index==0) cost += arr[0];
        
        scan.close();
        System.out.println(Arrays.toString(arr));
        System.out.println(cost);
    }

}