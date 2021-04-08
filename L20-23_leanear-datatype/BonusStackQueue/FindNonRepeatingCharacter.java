
import java.util.*;

class FindNonRepeatingCharacter {
    public static void nonrep(String str) {
        int[] arr = new int[26];
        Queue<Character> queue = new LinkedList<>();
        char currentChar = str.charAt(0);
        queue.add(currentChar);
        int prev=currentChar;
        arr[prev-'a']++;

        System.out.print((char)prev);
        for(int i = 1; i<str.length();i++){
            currentChar = str.charAt(i);
            if(arr[currentChar-'a'] >1 && !queue.isEmpty() && queue.peek()==currentChar) queue.poll();
        	if(prev !=-1){
        		if(currentChar!=prev){
                    System.out.print((char)prev);
                    if(arr[currentChar-'a'] ==0) queue.add(currentChar);
                } 
        		else{
                    queue.poll();
                    if(queue.isEmpty()){
            			System.out.print(-1);
        			     prev = -1;
                    }else{
                        while(!queue.isEmpty() && arr[queue.peek().charValue()-'a']==1){
                            queue.poll();
                        }
                        System.out.print(queue.peek());
                        prev = queue.peek();
                    }
        		}
        	}else{
        		if(arr[currentChar-'a']!=0) System.out.print(-1);
        		else{
                    queue.add(currentChar);
        			System.out.print(currentChar);
        			prev = currentChar;
        		}
        	}
        	arr[currentChar-'a']++; 
        }
    }

    public static void nonrep1(String str) {
        int[] arr = new int[26];
        Queue<Character> queue = new LinkedList<>();
        char currentChar = '1';

        for(int i = 0; i<str.length();i++){
            currentChar = str.charAt(i);
            if(arr[currentChar-'a']==0) queue.add(currentChar);
            arr[currentChar-'a']++;

            while((!queue.isEmpty()) && arr[queue.peek()-'a']>1) queue.poll();
            if(queue.isEmpty()) System.out.print("-1");
            else System.out.print(queue.peek());
            
        }
    }
    public static void main(String[] args) {
    	nonrep1("aaabbcdefced");
    }
}