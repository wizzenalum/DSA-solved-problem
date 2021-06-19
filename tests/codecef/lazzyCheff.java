import java.util.Scanner;

public class lazzyCheff{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tests = scan.nextInt();
        int x = 0;
        int m = 0;
        int d = 0;
        int temp = 0;
        for (int i = 0; i < tests; i++) {
            x = scan.nextInt();
            m = scan.nextInt();
            d = scan.nextInt();
            temp = x*m;
            if(temp-x<=d) System.out.println(temp);
            else System.out.println(d+x);
        }
    }
}