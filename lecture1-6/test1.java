import java.util.Scanner;

public class test1 {
	// public static void main(String args[]){

//***  palindrome number  ****************************************************************************

		// Scanner scan = new Scanner(System.in);
  //       int number = scan.nextInt();
  //       int newnumber=0,var=number;
  //       do{
  //           newnumber = var%10 + newnumber*10;
  //           var = (var - var%10)/10;
            
  //       }
  //       while(var>0);
  //       if(number==newnumber){
  //           System.out.print("true");
  //       }else{
  //           System.out.print("false");
  //       }
//***  Check Arthematic progration  ****************************************************************************
		// Scanner scan = new Scanner(System.in);
  //       int number = scan.nextInt();
  //       if(number==0 || number ==1){
  //           System.out.print("true");
            
  //       }else{
  //           double ap = scan.nextDouble();
  //           double ac = scan.nextDouble();
  //           double diff = ac-ap;
  //           ap=ac;
  //           boolean flag = true;
  //           for(int i=0;i<number-2;i++){
  //               ac = scan.nextDouble();
  //               if(diff!=ac-ap){
  //                   System.out.print("false");
  //                   flag=false;
  //                   break;
  //               }     
  //           }
  //           if(flag){
  //               System.out.print("true");
  //           }
  //       }


//***  number star pattern  ****************************************************************************

		// Scanner scan = new Scanner(System.in);
  //       int number = scan.nextInt();
  //       for(int i=1;i<=number;i++){
  //           for(int j=number;j>=1;j--){
  //               if(i==j){
  //                   System.out.print("*") ;                
  //               }else{
  //                   System.out.print(j);                 
  //               }                
  //           }
  //           System.out.println();
  //       }
/*############################################################################
              TEST -2
#############################################################################*/ 

// public static int fact(int var){
//   int x=1;
//   for(int i=1;i<=var;i++){
//     x *=i;
//   }
//   return x;
// }

// public static int ncr(int n,int r){
//   int ncr = fact(n)/(fact(r)*fact(n-r));
//   return ncr;
// }

// public static int probability(int n,int x){
//   return((ncr(4, x)*ncr(4, n-x))*100/ncr(8,n));
// }



  public static void main(String args[]){
    
//****Number star pattern *********************************************************************

    // int n =5;
    // Scanner scan = new Scanner(System.in);
    // int n = scan.nextInt();
    // for (int i =1; i<=n; i++) {
    //   for (int j=1; j<=n; j++) {
    //     if(j<=n-i+1) System.out.print(j);
    //     else System.out.print("*");
    //   }
    //   for (int j=n; j>=1; j--) {
    //     if(j<=n-i+1) System.out.print(j);
    //     else System.out.print("*");
    //   }

    //   System.out.println();
    // }
//****probability *********************************************************************
      // System.out.print(probability(6,3));// just see the function that i created named as ncr,probability, fact.

//****Maximum number *********************************************************************
    // int n = 5438;
    // int first = n%1000, fourth = n/10;
    // int second = (n/1000)*100 + n%100;
    // int third = (n/100)*10 + (n%10);
    // int b = first>second?first:second;
    // int c = third>fourth?third:fourth;
    // System.out.print(b>c?b:c);
    

	}
}