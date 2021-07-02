package fulltest1;

import java.time.chrono.IsoEra;
import java.util.*;
public class JumnpingNumbers {

    public static void createNumber(int i, int x,Queue<Integer> q) {
        if(i>x) return;
        int num1 = (i*10)+(i%10)+1;
        int num2 = (i*10)+(i%10)-1;
        // System.out.print("  '"+i+"' ");
        if(i%10<9 && num1<=x){
            System.out.print(num1+" ");
            q.add(num1);
        }
        if(i%10>0&& num2<=x){
            System.out.print(num2+" ");
            q.add(num2);
        }
        if(!q.isEmpty()) createNumber(q.poll(), x, q);    

    }


    public static void showJumpingNos(int x) {
		System.out.print("0 ");
        for (int i =1 ; i < 10; i++) {
            Queue<Integer> q = new LinkedList<>();

            System.out.print(i+ " ");
            createNumber(i,x,q);
        }
	}
    public static void main(String[] args) {
        showJumpingNos(1550);
    }
}
