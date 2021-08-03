/*############################################################################
                                Number of pushes
    You are currently on a floor "s" of a building, where you see an elevator. 
    Upon entering the elevator, you see that there are only two button "up u" 
    and "down d". The up button takes the elevator "u" floors up(if there aren't 
    enough floors, pressing the up does nothing), while the down button takes 
    the elevator "d" floors down(or none if there aren't enough).
    
    The building has a total of "f" floors and you have to reach floor "g".
    You have to find the number of pushes required to reach from floor "s" 
    to "g" as soon as possible. If it is not possible to reach using elevator, 
    return -1.
        
    Input Format:
        The input contains a single line having f, s, g, u, d separated by 
        space. (Floors are 1 indexed i.i 5 floors means [1:5])

    Output Format:
        The output line contains the minimum numbers of pushes that you must 
        make in order to get from "s" to "g" else -1 if it is impossible to reach 
        using the elevator.

    Constraints:
        1 <= s, g <= f <= 10^6
        0 <= u, d <= 10^6

    Sample Input :
        10 1 8 2 1

    Sample Output:
        5
  						    
					completed true;
  #############################################################################*/ 

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileStore;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;


public class NumberOfPushes{
    public static int f;
    public static int g;
    public static int u;
    public static int d;
    public static int count;
    public static Queue<Integer> queue;
    public static HashMap<Integer,Integer> visited;
    public static HashMap<Integer,NextMove> map;

    public static void addChildsToQueue(int s){
        if(!visited.containsKey(s-d) && s-d>0){
            visited.put(s-d, s);
            // System.out.print(" added "+(s-d));
            queue.add(s-d);
        }
        if(!visited.containsKey(s+u) && s+u<=f){
            visited.put(s+u, s);
            // System.out.print(" added "+(s+u));
            queue.add(s+u);
        }
    }
    public static int shortestPath(int s) {
        // here path creation is hppening simuteniosly
        // stack over flow is become problem
        if(s==g){
            count++;
            return s;
        }
        // if(terminate(s)) return -1;
        
        addChildsToQueue(s);
        if(!queue.isEmpty()){
            int retValue = shortestPath(queue.poll());
            if(retValue!=-1){
                if(visited.get(retValue)==s){
                    count++;
                    // System.out.println(s);
                    return s;
                }
                else return retValue;
            }

        }
        return -1;
    }
   
    // public static void shortestPath2(int s) {
    //     // making sbig blunded
    //     count = -1;
    //     if(s==g){
    //         count = 0;
    //         return;
    //     }
    //     Stack<Integer> sourceStack = new Stack<>();       
    //     while(true){
    //         // System.out.print("\nstart"+s+" ");
    //         if(s==g){
    //             count=1;
    //             System.out.println(s);
    //             s = visited.get(s);
    //             break;
    //         } 
    //         sourceStack.add(s);
    //         addChildsToQueue(s);
    //         if(queue.isEmpty()){
    //             // System.out.println(" end");
    //             return;
    //         }
    //         s = queue.poll();
    //     }
    //     while(!sourceStack.isEmpty()){
    //         // System.out.println("\nstack in "+sourceStack.peek()+" "+s);
    //         if(visited.get(s)==sourceStack.peek()){
    //             count++;
    //             System.out.println(s);
    //             // System.out.print(count+",");
    //             s = sourceStack.pop();
    //         }else sourceStack.pop();
    //     }
    //     // System.out.println();
    // }
    public static void shortestPath2(int s) {
        // making upper recursion to a sequancial algo
        count = -1;
        if(s==g){
            count = 0;
            return;
        }
        Stack<Integer> sourceStack = new Stack<>();       
        while(true){
            // System.out.print("\nstart"+s+" ");
            if(s==g){
                count=1;
                System.out.println(s);
                s = visited.get(s);
                break;
            } 
            sourceStack.add(s);
            addChildsToQueue(s);
            if(queue.isEmpty()){
                // System.out.println(" end");
                return;
            }
            s = queue.poll();
        }
        while(sourceStack.size()>1){
            // System.out.println("\nstack in "+sourceStack.peek()+" "+s);
            if(s==sourceStack.peek()){
                count++;
                System.out.println(s);
                // System.out.print(count+",");
                s = visited.get(sourceStack.pop());
            }else sourceStack.pop();
        }
        // System.out.println();
    }
// method 3 and 4 both correct but her wrongly implemented.
    static class NextMove{
    Integer first;
    Integer second;
    NextMove(Integer first, Integer second){
        this.first = first;
        this.second = second;
    }
}
    public static void createGraph(int s, HashMap<Integer,NextMove> map) {
        if(s<=0 ||s>f) return;
        if(visited.containsKey(s)) return;
        if(s-d>0) map.put(s,new NextMove(s-d,null));
        if(s+u<=f){
            if(map.containsKey(s)) map.get(s).second = s+u;
            else map.put(s,new NextMove(null,s+u));
        }
        visited.put(s,s);
        createGraph(s-d, map);
        createGraph(s+u, map);
    }
    public static void printGraph(int s, HashMap<Integer,NextMove> map) {
        if(s<=0 ||s>f) return;
        if(visited.containsKey(s)) return;
        NextMove temp = map.get(s);
        System.out.println(s+"->"+temp.first+","+temp.second);
        visited.put(s,s);
        printGraph(s-d, map);
        printGraph(s+u, map);
    }
    public static int shortestPath3(int s) {
        if(s==g){
            count++;
            return s;
        }
        if(map.containsKey(s)){
            NextMove temp = map.get(s);
            if(temp.first!=null && !visited.containsKey(temp.first)){
                queue.add(temp.first);
                visited.put(temp.first,s);
            }
            if(temp.second!=null && !visited.containsKey(temp.second)){
                queue.add(temp.second);
                visited.put(temp.second,s);
            }
        }
        if(!queue.isEmpty()){
            int retValue = shortestPath3(queue.poll());
            if(retValue!=-1){
                if(visited.get(retValue)!=s) return retValue;
                else{
                    count++;
                    return s;
                }
            }
        }
        return -1;
    }
    public static void shortestPath4(int s) {
        count = -1;
        Stack<Integer> sourceStack = new Stack<>();       
        while(true){
            // System.out.print("\nstart"+s+" ");
            if(s==g){
                s=visited.get(s);
                count=1;
                break;
            } 
            sourceStack.add(s);
            if(map.containsKey(s)){
                NextMove temp = map.get(s);
                if(temp.first!=null && !visited.containsKey(temp.first)){
                    queue.add(temp.first);
                    visited.put(temp.first,s);
                }
                if(temp.second!=null && !visited.containsKey(temp.second)){
                    queue.add(temp.second);
                    visited.put(temp.second,s);
                }
            }
            if(queue.isEmpty()){
                // System.out.println(" end");
              count = -1;
                return;
            } 
            s = queue.poll();
        }
        while(!sourceStack.isEmpty()){
            // System.out.println("\nstack in "+sourceStack.peek()+" "+s);
            if(visited.get(s)==sourceStack.peek()){
                count++;
                // System.out.print(count+",");
                s = sourceStack.pop();
            }else sourceStack.pop();
        }
        // System.out.println();
    }
    public static void main(String[] args) throws IOException {
        // InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/graph-smple-text.txt");
        Scanner scan = new Scanner(r);
        f = scan.nextInt(); // total floars
        int s = scan.nextInt(); // start floar
        g = scan.nextInt(); // destination floar
        u = scan.nextInt(); // number of upward move in one push
        d = scan.nextInt(); // number of downward move in one push
        scan.close();
        r.close();
        // System.out.println(f+" "+s+" "+g+" "+u+" "+d);
        queue = new LinkedList<Integer>();
        visited = new HashMap<>();
        count = -1;        
        // shortestPath(s);
        shortestPath2(s);
        System.out.println(count);
        // if(count == 0) System.out.println("-1");
        // else System.out.println(count);   
        
        // method three first create graph then search for minimum path.
        visited.clear();
        map = new HashMap<>();
        // createGraph(s,map);
        visited.clear();
        // printGraph(s, map);
        // visited.clear();
        // map.clear();
        // count = -1;
        // shortestPath3(s);
        visited.clear();
        map.clear();
        count = -1;
        // shortestPath4(s);
        // System.out.println(count);
    }
}
