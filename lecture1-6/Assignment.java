import java.util.Scanner;
public class Assignment{
	public static void main(String[] args) {
		
/* ####################################################################################################################  
                                                   	LECTURE-4   
 ####################################################################################################################*/        		
//****  TOTAL SALARY****************************************************************************
		// Scanner scan = new Scanner(System.in);
		// double basic = scan.nextInt();
		// String grad = scan.next();
		// char grade = grad.charAt(0);

		// double ts,allow, hra = basic*20/100, da = basic/2,pf = basic*11/100;
		// if (grade == 'A'){
		// 	allow = 1700;
		// }else if(grade =='B'){
		// 	allow = 1500;
		// }else{
		// 	allow = 1300;
		// }
		// ts = basic+hra+da+allow-pf;
		// if(ts%1>.5){
		// 	System.out.println((int)ts+1);
		// }
		// else{
		// 	System.out.print((int)ts);
		// }		
//****  Multiplication Table  ****************************************************************************

		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		
		// int i = 1;
		// while(i<11){
		// 	System.out.println(n*i);
		// 	i +=1;
		// }
//***  Multiplication Table  ****************************************************************************

		// Scanner scan = new Scanner(System.in);
		// double n = scan.nextInt();
		// int evensum = 0, oddsum = 0;

		// while((n/10) >=.1){
		// 	if((n%10)%2==0){
		// 		evensum += n%10;
		// 	}else{
		// 		oddsum += n%10;
		// 	}
		// 	n = (int)(n/10);
			
		// }
		// System.out.printf("\n%s %s",evensum,oddsum);
//***  Factors  ****************************************************************************

		// Scanner scan = new Scanner(System.in);
		// double n = scan.nextInt();
		// int i =2;

		// while(i<n){
		// 	if(n%i==0){
		// 		System.out.print(i);
		// 		System.out.print(' ');
		// 	}
		// 	i+=1;
		// }
/* ####################################################################################################################  
                                                   	LECTURE-6  
 ####################################################################################################################*/        		
//*** Half Diamonds ***************************************************  
	// Scanner scan = new Scanner(System.in);
 	// 	int n = scan.nextInt();
 	// 	int middle_of_row = 1;
 	// 	System.out.println("*");
 	// 	for(int j=1;j<=n*2-1;j++){
 	// 		System.out.print("*");
 	// 		int print_number = 1;
 	// 		for(int i=1;i<=middle_of_row*2-1;i++){
 	// 			if(i<=middle_of_row){
 	// 				System.out.print(print_number);
 	// 				print_number++;
 	// 			}else{
 	// 				print_number--;
 	// 				System.out.print(print_number-1);
 	// 			}
 	// 		}
 	// 		System.out.print("*");
 	// 		if(j<n){
 	// 			middle_of_row++;
 	// 		}else{
 	// 			middle_of_row--;
 	// 		}
 	// 		System.out.println("");	
 	// 	}
 	// 	System.out.println("*");	
 		
//*** Parallelogram Pattern **********************************************
 		// Scanner scan = new Scanner(System.in);
 		// int n = scan.nextInt();
 		// for(int i=0;i<n;i++){
 		// 	for(int j=0;j<i+n;j++){
 		// 		if (j>=i){
 		// 			System.out.print("*");
 		// 		}else{
 		// 			System.out.print(" ");
 		// 		}
 		// 	}
 		// 	System.out.println();
 		// }
//*** Sum Pattern **********************************************
 		// Scanner scan = new Scanner(System.in);
 		// int n = scan.nextInt();
 		
 		// for(int i=1;i<=n;i++){
 		// 	int sum = 0;
 		// 	for(int j=1;j<=i;j++){
 		// 		if(j==i){
 		// 			System.out.print(j+"=");
 		// 		}else{
 		// 			System.out.print(j+"+");
 		// 		}
 		// 		sum +=j;
 		// 	}

 		// 	System.out.println(sum);
 		// }
//*** Odd Square**************************************************************
	// Scanner scan = new Scanner(System.in);
 	// 	int n = scan.nextInt(); 
 	// 	for(int i=0;i<2*n;i+=2){
 	// 		for(int j=1;j<2*n;j+=2){
 	// 			if(i+j<2*n){
 	// 				System.out.print(i+j);
 	// 			}else{
 	// 				System.out.print(i+j-2*n);
 	// 			}
 	// 		}
 	// 		System.out.println();
 	// 	}
/*############################################################################
							LECTURE-7 OPERATORS &FOR LOOP
#############################################################################*/	
//****sum and product *********************************************************************
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();	
		// int c = scan.nextInt();	
		// // int n = 5, c=2;
		// if(c==1){
		// 	int sum = 0;
		// 	for(int i=1;i<=n;i++){
		// 		sum +=i;
		// 	}System.out.print(sum);
		// }else if(c==2){
		// 	int product = 1;
		// 	for (int i=1; i<=n; i++) {
		// 		product*=i;	
		// 	}System.out.print(product);
		// }else System.out.print("-1");
//****Terms of AP *********************************************************************
		// Scanner scan = new Scanner(System.in);
		// int x = scan.nextInt();	
		// // int  x= 6;
		// int k = 1;
		// for (int i=1; k<=x; i++) {
		// 	if(!((3*i+2)%4==0)){
		// 		System.out.printf("%s ",3*i+2);
		// 		k++;
		// 	}
		// } 
//****Reverse of a number.   *********************************************************************
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		// // int n = 123666000;
		// int newNumber = 0, updated = n;
		// do{
		// 	newNumber = updated%10 + newNumber*10;
		// 	updated = updated/10;
		// }while(updated >0);
		// System.out.print(newNumber);
//****Binary to decimal *********************************************************************
		// Scanner scan = new Scanner(System.in);
		// long n = scan.nextLong();
		// // int n = 111;
		// long i, newNumber = 0, updated=n;
		// for (i=1; updated/10>0; i*=2) {
		// 	newNumber = newNumber+updated%10*i;
		// 	updated = updated/10;
		// }
		// System.out.print(newNumber+updated%10*i);


//****Decimal to Binary *********************************************************************
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		// int n = 151;
		// long binary = 0, zeros = 1;
		// for(int i=n;i>0;i=i/2){
		// 	binary = (i%2)*zeros + binary;
		// 	zeros*=10;
		// }System.out.print(binary);	
//****Square Root(integral) *********************************************************************
			// int n = 1;
			// Scanner scan = new Scanner(System.in);
			// int i, n = scan.nextInt();
			
			// for(i=2;i*i<=n;i++){
			// }
			// if(n==0) System.out.print("0");
			// else System.out.print(i-1);
//****check number sequence *********************************************************************
//solution 1
		// Scanner scan = new Scanner(System.in);
		// int i=1,n = scan.nextInt();
		// int preNumber = scan.nextInt(),cNumber=scan.nextInt();
		// for (i=3; preNumber>cNumber && i<=n; i++) {
		// 	preNumber=cNumber;
		// 	cNumber=scan.nextInt();
		// }
		// for (i=i;preNumber<cNumber&&i<=n;i++){
		// 	preNumber=cNumber;
		// 	cNumber=scan.nextInt();
		// }
		// if (i-1==n) System.out.print("true");
		// else System.out.print("false");
// solution 2
		 Scanner scan = new Scanner(System.in);
		int i=1,n = scan.nextInt();
		int preNumber = scan.nextInt(),cNumber=scan.nextInt();
		boolean decreasing = true;


		if(decreasing){
			for (i=3; preNumber>cNumber && i<=n; i++) {

				preNumber=cNumber;
				cNumber=scan.nextInt();
			}
			decreasing = false;
		}
		else{  // why else doesent worked here.
			for (;preNumber<cNumber&&i<=n;i++){
				
				preNumber=cNumber;
				cNumber=scan.nextInt();
			}
		}
		if (i-1==n) System.out.print("true\n");
		else System.out.print("false\n");






	}
}