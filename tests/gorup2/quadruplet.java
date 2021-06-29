package gorup2;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.io.*;


public class quadruplet {
    public static List<Integer> sorted(int a,int b, int c, int d) {
        List<Integer> l = new ArrayList<>();
        int [] arr = {a,b,c,d};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            l.add(arr[i]);
        }
        return l;
    }
    static public List<List<Integer>> quadruplets(int[] nums, int x) 
    {
        HashMap<String,Boolean> map = new HashMap<>();

        List<List<Integer>> b = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) { 
            for (int j = i+1; j < nums.length-2; j++) {
                // if(nums[i]==nums[j]) continue;
                for (int j2 = j+1; j2 < nums.length-1; j2++) {
                    // if(nums[j2]==nums[j]||nums[j2]==nums[i]) continue;
                    for (int k = j2+1; k < nums.length; k++) {
                        // if(nums[j2]==nums[k]||nums[j]==nums[k]||nums[i]==nums[k]) continue;
                        System.out.println(nums[i]+" "+nums[j]+" "+nums[j2]+" "+nums[k]+" "+x);
                        if(nums[i]+nums[j]+nums[j2]+nums[k]==x){
                            List<Integer> a = sorted(nums[i],nums[j],nums[k],nums[j2]);
                            if(map.containsKey(a.toString())) continue;
                            else {
                                b.add(a);
                                map.put(a.toString(),true);
                            }
                        }
                    }
                }
            }

        }
        return b;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine().trim());

        int arr[] = new int[n];

        StringTokenizer tk = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int x = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> answer = quadruplets(arr, x);

        for (int p = 0; p < answer.size(); p++)
        {
            for (int q = 0; q < 4; q++)
            {
                System.out.print(answer.get(p).get(q) + " ");
            }
            System.out.println();
        }
    }
}
