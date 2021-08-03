import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

import javax.swing.text.StyledEditorKit.BoldAction;

import jdk.tools.jlink.resources.plugins;

/*############################################################################
  						    Convert one prime to other
    You are given with two four digit prime numbers, you have to find the shortest 
    path to convert the first prime number to the second prime number. You 
    can alter only one digit at a time such that every number formed after 
    altering the digit is also prime.
    
    Input Format:
        The only input line contains two four digit prime numbers separated 
        by space.

    Output Format:
        The output line contains the length of shortest path to convert one 
        prime number to other. If it is impossible to convert then return -1.

    Sample Input:
        1061  1747

    Sample Output:
        4

					completed false;
  #############################################################################*/ 

public class ConvertOnePrimeToOther{
    private static boolean isPrime(int n) {
        if(n<2) return false;
        if(n==2||n==3) return true;
        if(n==4) return false;
        if(n%2 ==0 || n%3==0) return false;
        if((n-1)%6!=0 && (n+1)%6!=0){
            return false;
        }
        int i = 1;
        while(n>=(6*i-1)*(6*i-1)){

            int num = 6*i-1;
            if(n%num==0) return false;
            if(n%(num+2)==0) return false;
            i++;
        }
        return true;
    }
    public static ArrayList<Integer> listOfPrime(int first, int last) {
        int i = first;
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        while(i<last){
            if(isPrime(i)) list.add(i);
            i++;
        }
        return list;
    }
    public static int[] seprateDigits(int number) {
        int[] first = new int[4];
        first[0] = number%10;
        number /=10;
        first[1] = number%10;
        number /=10;
        first[2] = number%10;
        number /=10;
        first[3] = number%10;
        // System.out.println(Arrays.toString(first));
        return first;
    }
    public static boolean isMovePossible(int a, int b) {
        int[] first = seprateDigits(a);
        int[] second = seprateDigits(b);
        if( (first[0]!=second[0]&&first[1]==second[1]&&first[2]==second[2]&&first[3]==second[3])||
            (first[0]==second[0]&&first[1]!=second[1]&&first[2]==second[2]&&first[3]==second[3])||
            (first[0]==second[0]&&first[1]==second[1]&&first[2]!=second[2]&&first[3]==second[3])||
            (first[0]==second[0]&&first[1]==second[1]&&first[2]==second[2]&&first[3]!=second[3])){
                // System.out.println("true");
                return true;
            }
        return false;
    }
    public static void createGraph(HashMap<Integer,ArrayList<Integer>> graph, ArrayList<Integer> primeList) {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < primeList.size(); i++) {
            num1 = primeList.get(i);
            for (int j = 0; j < primeList.size(); j++) {
                num2 = primeList.get(j);
                if(isMovePossible(num1, num2)){
                    if(!graph.containsKey(num1)) graph.put(num1,new ArrayList<>());
                    graph.get(num1).add(num2);
                }
            }
        }   
    }
    public static Queue<Integer> queue = new LinkedList<>();
    public static int  count = 0;
	public static int bftGetPath(HashMap<Integer,ArrayList<Integer>> graph, HashMap<Integer,Integer> visitMap,
                                    int source, int key){
		// System.out.println(source);
		if(source == key){
					// System.out.print("R1  ");
					// System.out.print(source+" ");
					return source; 
		}
        
		ArrayList<Integer> list = graph.get(source);

        for(int i = 0;list!=null && i<list.size();i++){
			// System.out.println("for");
			
			if(!visitMap.containsKey(list.get(i))){
				queue.add(list.get(i));
				visitMap.put(list.get(i),source);
			}
		}
		// System.out.println(queue);
		if(!queue.isEmpty()){ 
			int k = bftGetPath(graph, visitMap ,queue.poll(), key);
			if(k!=-1){
				if(visitMap.get(k)!=source){
				// System.out.println(source+"R2 " +k+" " +visitMap.entrySet());
					return k;	
				} 
				// System.out.print("R22 ");
				// System.out.print(source+" ");
                count++;
				return source;
			}

		}
			// System.out.println("R3  -1");
			return -1;
	}
    public static void main(String[] args) throws IOException {
        // System.out.println("love "+ isPrime(1015));
        // InputStreamReader r = new InputStreamReader(System.in);
        FileReader r = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/graphs/graph-bonus/graph-smple-text.txt");
        Scanner scan = new Scanner(r);
        int firstPrime = scan.nextInt();
        int secondPrime = scan.nextInt();
        // int firstPrime = 1013;
        // int secondPrime = 1009;
        scan.close();
        r.close();
        // System.out.println(firstPrime+" "+secondPrime);
        ArrayList<Integer> primeList = listOfPrime(1000, 10000);
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        createGraph(graph, primeList);

        // for(int key : graph.keySet()){
        //     ArrayList<Integer> list = graph.get(key);
        //     if(list==null) System.out.print("\n"+key);
        //     else{System.out.print("\n"+key+"-> ");
        //         for (int i = 0; i < list.size(); i++) {
        //             System.out.print(list.get(i)+",");
        //         }
        //     }
        // }
        // int i = 0;
        // for (i = 0; i < primeList.size(); i++) {
        //     System.out.print(primeList.get(i)+" ");   
        // }
        // System.out.println(i);
        count = 0;
        bftGetPath(graph, new HashMap<Integer,Integer>(),firstPrime,secondPrime );
        System.out.println(count);
        
    }
}
// 9293
// 293
// 2293
// 2297