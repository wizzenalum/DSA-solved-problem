import java.util.Arrays;
import java.util.Scanner;
public class towerHanoi{
	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		if(disks==1) {
			System.out.println(source+" "+destination);
			return;
		}
        if(disks<=0) return;
		// System.out.print(disks);
		towerOfHanoi(disks-1,source,destination,auxiliary);
		System.out.println(source+" "+destination);
		towerOfHanoi(disks-1,auxiliary,source,destination);
	}
	public static void main(String[] args){
		int n = 2;
		towerOfHanoi(n,'a','b','c');
	}

}