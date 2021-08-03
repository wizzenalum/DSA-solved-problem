package fulltest1;

import java.util.HashMap;

public class CheckSubsetProblem {
    public static boolean CheckSubset(int[] arr1, int n1, int[] arr2, int n2) {
		if(n2 == 0) return true;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i])) map.replace(arr2[i], map.get(arr2[i])+1);
            else map.put(arr2[i],1);
        }
        for (int i = 0; i < arr1.length;i++) {
            if(map.isEmpty()) return true;
            if(map.containsKey(arr1[i])){
                if(map.get(arr1[i])==1){
                    map.remove(arr1[i]);
                }
                else map.replace(arr1[i], map.get(arr1[i])-1);
            }
        }
        // System.out.println(map.entrySet());

        return false;
	}
    public static void main(String[] args) {
        int[] arr1 = {3,6,5,8,15,1,14,18,7,9,14,9,3,12,8};
        int[] arr2 = {18,14,14,14,8};
        System.out.println(CheckSubset(arr1, arr1.length, arr2, arr2.length));
    }
}
