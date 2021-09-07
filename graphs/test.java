import java.util.HashMap;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;


public class test {
    public static void print(HashMap<Integer,ArrayList<Integer>> graph){
        for(int i : graph.keySet()){
            System.out.print(i+"--> ");
            ArrayList<Integer> arr = graph.get(i);
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j)+", ");
            }
            System.out.println();
        }
    }
    public static int terminate;
    public static boolean dfs( HashMap<Integer,ArrayList<Integer>> graph,
                            HashMap<Integer,Boolean> localvisit, 
                            HashMap<Integer,Boolean> visited, int index ) {
        System.out.println("call to func"+visited.keySet()+" "+index+" ");
        if(index>terminate) return false;
        localvisit.put(index,true);
        visited.put(index,true);
        System.out.println("added index to visited  "+visited.keySet()+" check condiont "+ graph.containsKey(index));

        if(graph.containsKey(index)){
            ArrayList<Integer> connectedTo = graph.get(index);
            System.out.println(connectedTo.subList(0, connectedTo.size()));
            for (int i = 0; i < connectedTo.size(); i++) {
                System.out.println("looping for "+index+" "+connectedTo.get(i));
                if(!localvisit.containsKey(connectedTo.get(i))){
                    if(dfs(graph, localvisit, visited, connectedTo.get(i))) return true;
                }else return true;
            }
        }
        return false;
    }
    public static boolean dfsConnected(HashMap<Integer,ArrayList<Integer>> graph) {
        HashMap<Integer,Boolean> visited = new HashMap<>();
        for (Integer i  : graph.keySet()) {
            if(!visited.containsKey(i)){
                if(dfs(graph, new HashMap<>(), visited, i)) return true;
            }         
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        // int totalNumber = Integer.parseInt(bf.readLine().trim());
        // int n = Integer.parseInt(bf.readLine().trim());
        // String[] prr = bf.readLine().trim().split(" ");
        int n = 5;
        terminate = 6;
        // String[] prr = { "1", "2", "1", "5", "2", "3", "4", "1"};
        String[] prr = {"1","2","1","3","3","2","2","4","2","5"};
        // String[] prr = { "1", "2", "1", "2", "2", "3", "3", "0"};
        // System.out.println(totalNumber+" "+n+" "+prr);
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 2*n; i+=2) {
            if(!graph.containsKey(Integer.parseInt(prr[i]))){
                graph.put(Integer.parseInt(prr[i]), new ArrayList<>());
            }
            boolean notRepeating = true;
            ArrayList<Integer> arr = graph.get(Integer.parseInt(prr[i]));
            for(int j = 0; j<arr.size();j++){
                if(Integer.parseInt(prr[i+1])==arr.get(j)){
                    notRepeating = false;
                    break;
                }
            }
            if(notRepeating) arr.add(Integer.parseInt(prr[i+1]));
        }
        print(graph);
        if(dfsConnected(graph)) System.out.print("0");
        else System.out.print("1");
    }
}
