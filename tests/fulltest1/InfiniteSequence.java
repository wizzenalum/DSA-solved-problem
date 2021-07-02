package fulltest1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Triplet{
    int first;
    int second;
    Triplet(int f){
        this.first = f;
        this.second = -1;
    }
    Triplet(int f, int s){
        this.first = f;
        this.second = s;
    }
}

public class InfiniteSequence {
    public static int ans(int n) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Triplet> map = new HashMap<>();
        list.add(0);
        list.add(0);
        map.put(0,new Triplet(1,2));
        int next = 0, prev=0;
        for (int i = 3; i <= n; i++) {
            prev = list.get(i-2);
            if(map.get(prev).second==-1) next = 0;
            else next = map.get(prev).second - map.get(prev).first;
            list.add(next);
            if(map.containsKey(next)){
                if(map.get(next).second==-1) map.get(next).second = i;
                else{
                    map.get(next).first = map.get(next).second;
                    map.get(next).second = i;
                }
            }else map.put(next,new Triplet(i));
        }
        int num  = list.get(n-1);
        for (int i = 0; i < n; i++) {
            if(list.get(i)==num) res++;
        }
        return res;
        
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        System.out.println(ans(n));
    }
}
