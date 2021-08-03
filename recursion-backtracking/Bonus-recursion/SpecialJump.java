/*############################################################################
						      Special Jump

	In the jungle, Mother kangaroo is far away from his child kangaroo while 
	some jungli animal came tries to hurt him. So, mother kangaroo wants to 
	reach to his son as fast as possible. Help her to reach his son
	Mother and child kangaroo are on 1D line (x-axis from -infinity to +infinity). 
	Mother kangaroo is at origin(0) and child kangaroo is at some co-ordinate X. 
	Mother kangaroo has special jump. In ith jump, she can take i steps forward 
	or backward.
	Help her to reach his son in minimum possible steps.
	here X<30;

				completed method1 = true  method2=false

#############################################################################*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
// method 2 this class method will move at each step;
class Ways{
	int position;
	int steps;
	static int minSteps = -1;
	static Queue<Ways> queue = new LinkedList<>();

	Ways(int position, int steps){
		this.position = position;
		this.steps = steps;
		System.out.println(position+" "+steps+" "+queue.size()+" "+minSteps);
	}
	void move(){
		if(Ways.minSteps!=-1) return;
		if(this.steps>7) return;
		if(this.position==0){
			Ways.minSteps = steps;
			return;
		}
		this.steps = this.steps+1;
		Ways a = new Ways(this.position-this.steps,this.steps);
		Ways b = new Ways(this.position+this.steps,this.steps);
		Ways.queue.add(a);
		Ways.queue.add(b);
		a = queue.poll();
		a.move();
	}

}




public class SpecialJump{

	// method 1 this is working great for the problem given.	
	public static void minJumpCount(int position, int steps,int[] terminate){	
		// System.out.println(position+" "+steps+" "+ terminate[0]);
		if(terminate[0]!=0){
			if(steps>terminate[0]) return;
		}
		if(position==0){
			terminate[0] = steps;
			return;
		}
		if(position<terminate[1]*(-2)) return; // i terminating it forcefully for bigger numbers there may be .
		if(position>terminate[1]*(2)) return;// chance away from these bounderies.
		steps = steps+1;
		minJumpCount(position-steps,steps, terminate);
		minJumpCount(position+steps,steps, terminate);
	}

	public static void main(String[] args) {
	// method 1
		// Scanner scan = new Scanner(System.in);
		// int position = scan.nextInt();
		int position = 2;
		int[] terminate = {0,position};
		minJumpCount(position,0,terminate);
		System.out.println(terminate[0]);
		System.out.println();

	// method2 by class
		// int position = 2;
		Ways way = new Ways(position,0);
		way.move();

	}
}