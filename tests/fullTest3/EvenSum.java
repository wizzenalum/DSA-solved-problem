package fullTest3;

import java.util.Scanner;

public class EvenSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int evenCount = 0,oddCount = 0, sum = 0, num = 0;
        for(int i=0;i<n;i++){
            num = s.nextInt();
            if(num%2 == 0) evenCount++;
            else oddCount++;
            sum += num;
        }
        if(sum%2 == 0) System.out.println(evenCount);
        else System.out.println(oddCount);
        s.close();
        
    }
}
