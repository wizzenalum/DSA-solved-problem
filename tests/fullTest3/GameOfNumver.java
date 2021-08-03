/* ********************          Game of numbers             **********************       
    Given are two numbers X and Y. Starting from number X, we can perform two 
    functions on the number:
        Double: Multiply the number by 2, or
        Decrement: Subtract 1 from the number.
    Find the minimum number of operations required to convert X to Y.

    Input Format:
        First line contains two space separated integers X and Y.

    Output Format:
        Print the minimum number of operations required to get Y, starting from X.

    Constraints:
        1 <= X,Y <= 10^9

    Sample Input 1:
        2 3
    Sample Output 1:
        2

    Explanation:
        Use double operation and then decrement operation {2 -> 4 -> 3}.

    Sample Input 2:
        1024 1
    Sample Output 2:
        1023
    */


package fullTest3;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TooManyListenersException;

class Pair{
    int start;
    int step;
    Pair(int start, int step){
        this.start = start;
        this.step = step;
    }
}
public class GameOfNumver {
    static int end;
    static int stepCount;
    static Queue<Pair> queue;
    static HashMap<Integer,Boolean> map;
// method one here i try to reach start to end;
    public static void countSteps(int start,int step) {
        // failed stack over flow...
        if(start == end){
            stepCount = step;
            return;
        }
        map.put(start,true);
        if(!map.containsKey(start*2)) queue.add(new Pair(start*2,step+1));
        if(!map.containsKey(start-1)) queue.add(new Pair(start-1,step+1));
        if(queue.isEmpty() || stepCount!=-1) return;
        countSteps(queue.peek().start, queue.poll().step);
    }
    public static void countSteps1(int start,int end){
        // failed  for little higher values
        int stepCount=0, tempStart = start;
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer,Boolean> map = new HashMap<>();
        while(tempStart!=end){
            map.put(tempStart,true);
            if(!map.containsKey(tempStart*2)) queue.add(new Pair(tempStart*2,stepCount+1));
            if(!map.containsKey(tempStart-1)) queue.add(new Pair(tempStart-1,stepCount+1));
            if(queue.isEmpty()) break;
            tempStart = queue.peek().start;
            stepCount = queue.poll().step;
        }
        System.out.println(stepCount);
    }
// here i will reach end to start so instead of multipling i will devide and instead of substraction
// i willl add.  
public static void countSteps2(int start,int end){
    // working but time complexity O(max(start,end)) space compleixty O(max(start,end)) 
    int stepCount=0, tempEnd = end;
    Queue<Pair> queue = new LinkedList<>();
    HashMap<Integer,Boolean> map = new HashMap<>();
    while(tempEnd!=start){
        map.put(tempEnd,true);
        if(tempEnd%2!=1 && !map.containsKey(tempEnd/2)) queue.add(new Pair(tempEnd/2,stepCount+1));
        if(!map.containsKey(tempEnd+1)) queue.add(new Pair(tempEnd+1,stepCount+1));
        if(queue.isEmpty()) break;
        tempEnd = queue.peek().start;
        stepCount = queue.poll().step;
    }
    System.out.println(stepCount);
}
/*              method 3                  
    Solution Description: ​We will work backward in this problem. Instead ofmaking Y from X, 
    we would start from Y and work our way to reach X usingthe minimum number of steps.
    
    Instead of multiplying by 2 or subtracting 1 from X, we could divide by 2 (whenY is even) or add 1 to Y.
    
    Obviously,If Y <= X, we won't do Y / 2 anymore.We will increase Y until it equals to X
    So before that, while Y > X, we'll keep reducing Y, until it's smaller than X.●
    If Y is odd, we can do only Y = Y + 1, If Y is even, if we plus 1 to Y, then Y is odd, 
    we need to plus another 1.And because (Y + 1 + 1) / 2 = (Y / 2) + 1, 3 operations are 
    more than 2.We always choose Y / 2 if Y is even.
*/
public static void countSteps3(int start,int end){
    // worked and time O(max(starrt, end)) space O(1);
    int stepCount = 0,tempEnd = end ;
    while(tempEnd>start){
        if(tempEnd%2==1) tempEnd += 1;
        else tempEnd /= 2;
        System.out.println(tempEnd);
        stepCount++;
    }
    if(tempEnd<=start) stepCount += start - tempEnd;
    System.out.println(stepCount);
}

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int start = scan.nextInt();
        end= scan.nextInt();
        scan.close();
        stepCount = -1;
        queue = new LinkedList<>();
        map = new HashMap<>();
        // queue.add(new Pair(0,0));
    // way 1
        // countSteps(start,0);
        // System.out.println(stepCount);
    // way 2
        // countSteps1(start,end);
    // method 3
        // countSteps2(start,end);
    // method 4
        countSteps3(start,end);
    }
}
