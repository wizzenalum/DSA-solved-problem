import java.util.*;

public class HappyNumber {

    public static boolean findHappyNumber(int n) {
		if(n == 2||n==3||n==4||n==5||n==6||n==8||n==9||n==0) return false;
        if(n==1||n==7) return true;
        int nn = 0;
        while(n!=0){
            nn += (n%10)*(n%10);
            // System.out.print(n%10+"*"+n%10+" ");
            n = n/10; 
        }
        return findHappyNumber(nn);

	}
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        System.out.println(findHappyNumber(49));
        
        // for(int j = 10;j<100;j++){
        //     int n = j;
        //     System.out.print("start for "+n+"   --> ");
        //     for(int i = 0; i<20;i++){
        //         int a = n;
        //         int sum = 0;
        //         while(a!=0){
        //             sum += (a%10)*(a%10);
        //             System.out.print(a%10+"*"+a%10+" ");
        //             a = a/10; 
        //         }
        //         System.out.println("="+sum);
        //         n = sum;
        //         if(n/10==0) break;
                
        //     }
        // }
        // for(int i = 0; i<20;i++){
        //     int a = n;
        //     int sum = 0;
        //     while(a!=0){
        //         sum += (a%10)*(a%10);
        //         System.out.print(a%10+"*"+a%10+" ");
        //         a = a/10;
                
        //     }
        //     System.out.println("="+sum);
        //     n = sum;
            
        // }
        scan.close();
    }

}