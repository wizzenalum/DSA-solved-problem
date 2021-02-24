import java.util.Scanner;

public class successorProblem {


	
	public static int findNext(int var){
		int n = var, i =10;
		while(n>0){
			int check = n%10;
			int m = n/10, j =10;
			while(m>0){
				int digit = m%10;
				if(digit<check){

					n = (var/(i*j))*i*j+(check*i*j)/10+((n/10)%(j/10))*i+ digit*(i/10)+var%(i/10);
					m = firstOne(n%((i*j)/10));
					return (n/(i*j/10))*((i*j)/10) + m;
					// return (var/(i*j*100))*i*j*100+(check*i*j*100)/10+digit*i+ var%i;

				}
				m/=10;
				j *=10;
			}
			i*=10;
			n = n/10;
		}return -1;
	}
	public static int firstOne(int var){
		int send = 0,n=var;
		while(n>0){
			send = n%10 + send*10;
			n = n/10;
		}return send;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		int n = 265410;

		if(findNext(n)==-1) System.out.print(firstOne(n));
		else System.out.print(findNext(n));
	}
}