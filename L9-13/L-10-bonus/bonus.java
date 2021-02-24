import java.util.Scanner;
public class bonus {

	public static int random(int i,int j,int k){
		// return the biggest defference from givven three numbers.
		return i>=j?j>=k?i-k:i>=k?i-j:k-j:i>k?j-k:j>k?j-i:k-i;
	}
	public static void main(String[] args) {

		System.out.print(random(2,2,5));
	}
}