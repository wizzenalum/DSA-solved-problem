package attemt1;
import java.util.Scanner;
public class PyramidNumberPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n<=0) return;
        for (int i = 1; i < (n+1); i++) {
            for (int j = n; j>=1; j--) {
                if(j<=i) System.out.print(j);
                else System.out.print(" ");
            }
            for(int j = 2;j<i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
