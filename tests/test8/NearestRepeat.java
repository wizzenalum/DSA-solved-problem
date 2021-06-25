import java.util.*;
public class NearestRepeat {
    static class Pair{
        int first;
        int second;
        Pair(int a,int b){
            first = a;
            second = b;
        }
    }
    public static int minDistance(int[] arr){
        // wrong because look at this {5,47,5,4,6,5,5} i will never compare 5th and 6th same element.
        HashMap<Integer,Pair> map = new HashMap<>();
        int min = arr.length, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i+" s "+arr[i]+" ");
            if(!map.containsKey(arr[i])){
                System.out.print(" first ");
                map.put(arr[i],new Pair(i,-1));
            } 
            else if(map.get(arr[i]).second==-1){
                System.out.print(" second ");
                map.get(arr[i]).second = i;}
            else{
                Pair a = map.get(arr[i]);
                if(a.second-a.first>i-a.second){
                    System.out.print(" update ");
                    a.first = a.second;
                    a.second=i;
                }
            }System.out.println();
        }
        System.out.println("printing map");
        for (int key:map.keySet()) {
            if(map.get(key).second!=-1){
                System.out.println(key+" "+map.get(key).first+" "+map.get(key).second);
            }
        }
        for (int key:map.keySet()) {
            if(map.get(key).second!=-1){
                temp = map.get(key).second-map.get(key).first;
                if(min>temp) min = temp;
            }
        }
        return min;
	}
    public static int minDistanceUpdate(int[] arr){
        // new code with my technique
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int min = arr.length;
        for (int i = 0; i < arr.length; i++) {
            // System.out.print(i+" s "+arr[i]+" ");
            if(!map.containsKey(arr[i])){
                // System.out.print(" first ");
                map.put(arr[i],new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        // System.out.println("printing map");
        // for (int key:map.keySet()) {
        //     ArrayList<Integer> list = map.get(key);
        //     System.out.print(key+" -> ");
        //     for(int i = 0;i<list.size();i++){
        //         System.out.print(list.get(i)+",");
        //     }
        //     System.out.println();
        // }
        for (int key:map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            if(list.size()>1){
                for (int i = 0; i <list.size(); i++) {
                    for (int j = i+1; j < list.size(); j++) {
                       if(j-i<min) min = j-i; 
                    }
                }
            }
        }
        return min;
	}
    // bruit force approach
    public static int minDistance1(int[] arr){
        int min = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
               if(arr[i]==arr[j] && j-i<min) min = j-i; 
            }
        }
        return min;
    }
    public static void main(String[] args) {
        // int[] arr = {1,3,1,5,4,3};
        // int[] arr = {1,2,3,1,2,1,4,4};
        int[] arr = {5,47,5,4,6,5,5};
        // int[] arr = {1,2,5,4,1,2,3,2,5,4,7,8,9,4,5,6,2,1,3,2,1,1,1,1,1,1,2,1,4,5,1,2};
        System.out.println(minDistanceUpdate(arr));
        // System.out.println(minDistance(arr));
        // System.out.println(minDistance1(arr));
        
    }
}
