import java.util.Scanner;

// public class codeExercise{
// 	public static void main(String[] args) {

/* ####################################################################################################################  
                                                   	LECTURE-4 conditionals and loops 
 ####################################################################################################################*/        		
 
//***find Character case*********************************************************************************************************************
		// Scanner scan = new Scanner(System.in);
		// String a =  scan.next();
		// char b = a.charAt(0);
		// int i = b;

		// if(64 < i && i< 91){
		// 	System.out.println("1");
		// }else if(96<i && i<123){
		// 	System.out.println("0");
		// }else{
		// 	System.out.println("-1");
		// }
		
//***Fahrenhite to celsius table*********************************************************************************************************************

		// Scanner scan = new Scanner(System.in);
		// int S = scan.nextInt();
		// int E = scan.nextInt();
		// int W = scan.nextInt();
		
		// int c;

		
		// while(S<=E){
		// 	c = 5*(S-32)/9;
		// 	System.out.printf("\n%s\t%s",S,c);
		// 	// System.out.println();
		// 	S +=W;
		// }

/* ####################################################################################################################  
                                                   	LECTURE-5  pattern 1
 ####################################################################################################################*/        		
 
//***   Square Pattern  **********************************************************************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=0;i<n;i++){
   //          for(int j=0;j<n;j++){
   //              System.out.print(n);
   //          }
   //          System.out.println();
   //      }
//***   Interesting Pattern  **********************************************************************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=1;i<=n;i++){
   //          for(int j=1;j<=i;j++){
   //              System.out.print((char)(n-i+j+64));
   //          }
   //      	System.out.println();
   //      }
//*** Triangular star pattern**************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=0;i<n;i++){
   //          for(int j=0;j<=i;j++){
   //              System.out.print('*');
   //          }
   //          System.out.println();
   //      }
//*** Triangular number pattern**************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=0;i<n;i++){
   //          for(int j=0;j<=i;j++){
   //              System.out.print(i+1);
   //          }
   //          System.out.println();
   //      }
//*** Reverse number pattern**************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=0;i<n;i++){
   //          for(int j=i+1;j>0;j--){
   //              System.out.print(j);
   //          }
   //          System.out.println();
   //      }
//*** Alpha pattern**************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=0;i<n;i++){
   //          for(int j=i+1;j>0;j--){
   //              System.out.print((char)(i+65));
   //          }
   //          System.out.println();
   //      }
//*** Character pattern**************************************
 		// Scanner scan = new Scanner(System.in);
   //      int n = scan.nextInt();
   //      for(int i=1;i<=n;i++){
   //          for(int j=1;j<=i;j++){
   //              System.out.print((char)(i+j+63));
   //          }
   //      	System.out.println();
   //      }

/* ####################################################################################################################  
                                                   	LECTURE-6-pattern 2  
 ####################################################################################################################*/        		
 //***Mirror image number pattern*********************************
 		// Scanner scan = new Scanner(System.in);
        // int n = scan.nextInt();
        // for(int i=1;i<=n;i++){
        //     for(int j=n;j>=1;j--){
        //     	if(i>=j){
        //     		System.out.print(i-j+1);
        //     	}else{
        //         	System.out.print(" ");
        //     	}
        //     }
        // 	System.out.println();
        // }
//*** Inverted number pattern *******************************************************************************
 		// Scanner scan = new Scanner(System.in);
 		// int n = scan.nextInt();
   //      for(int i=n;i>=1;i--){
   //          for(int j=i;j>=1;j--){
   //          	System.out.print(i);
   //          }
   //      	System.out.println();
   //      }
//*** Star pattern *******************************************************************************
 		// Scanner scan = new Scanner(System.in);
 		// int n = scan.nextInt();
   //      for(int i=1;i<=n;i++){
   //          for(int j=1;j<=n+i-1;j++){
   //          	if(n-i<j){
   //          		System.out.print('*');
   //          	}
   //          	else{
   //          		System.out.print(" ");
   //          	}
            	
   //          }
   //      	System.out.println();
   //      }
//*** Triangle of numbers *******************************************************************************
 		// Scanner scan = new Scanner(System.in);
 		// int n = scan.nextInt();
   //      for(int i=1;i<=n;i++){
   //      	int count = i;
   //          for(int j=1;j<=n+i-1;j++){
   //          	if(n-i<j && j<=n){
   //          		System.out.print(count);
   //          		count++;
   //          	}else if(n<j){
   //          		count--;
   //          		System.out.print(count-1);
   //          	}else{
   //          		System.out.print(" ");
   //          	}
            	
   //          }
   //      	System.out.println();
   //      }
//*** Diamonds ***************************************************  
	//	Scanner scan = new Scanner(System.in);
 	// 	int n = scan.nextInt();
 	// 	int middle = (n+1)/2, start = middle, end = middle;
 	// 	for(int i=1;i<=n;i++){
 	// 		for(int j=1;j<=end;j++){
 	// 			if(j<start){
 	// 				System.out.print(" ");
 	// 			}else{
 	// 				System.out.print("*");
 	// 			}
		// 	}if(middle>i){
		// 		start--;
		// 		end++;
		// 	}else{
		// 		start++;
		// 		end--;
		// 	}System.out.println();

 	// 	}
/*############################################################################
                Chapter 7
  #############################################################################*/
//****Nth Fibonacci Number *********************************************************************
      // Scanner scan = new Scanner(System.in);
      // int n = scan.nextInt();
      // // int n = 10;  
      // int a = 1;
      // int b = 1;
      // for (int i=3; i<=n; i++) {
      //   a = a+b;
      //   b = a-b;  

      // }
      // System.out.print(a);
//****All Prime Number *********************************************************************
    // Scanner scan = new Scanner(System.in);
    // int n = scan.nextInt();
    // if(n>2) System.out.print("2\n3\n");
    // else if(n>1) System.out.println("2");
    // if(n>3){
    //  for (int i=4; i<=n; i++) {
    //    boolean isPrime = i%2==0||i%3==0 ? false : true;
      //  for (int j=5; j*j<=i; j=j+6) {
      //    if(i%j==0 || i%(j+2)==0) {
      //      isPrime=false;
      //      break;
      //    }
      //  }
      //  if(isPrime) System.out.println(i);
    //  }
    // }
/*############################################################################
              Lecture 8 Function & Scope
#############################################################################*/
//**** calculate ncr *********************************************************************
  //   Scanner scan = new Scanner(System.in);
  //   int n = scan.nextInt(); 
  //   int r = scan.nextInt();
  //   int factn=1,factr=1,fact=1;
  //   for (int i=1; i<=n; i++) {
  //     factn*=i;
  //   }
		// for (int i=1; i<=r; i++) {
  //     factr*=i;
  //   }
  //   for (int i=1; i<=n-r; i++) {
  //     fact*=i;
  //   }
  //   System.out.print(factn/(fact*factr));
    



// 	}
// }
//****fibonacci Function *********************************************************************
public class codeExercise{

  // public static boolean func(int var){
  //   int a=0,b=1;
  //   boolean check = false;
  //   while(a<=var) {
  //     if(var==a) return true;
  //     a = a+b;
  //     b = a-b;
  //   }
  //   return false;
  // }

  // public static void main(String[] args) {
  //   System.out.print(func(5));
  // }
}