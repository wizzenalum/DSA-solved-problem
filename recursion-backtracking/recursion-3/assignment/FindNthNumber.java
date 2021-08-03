/*############################################################################
 							     Find the nth number

    You have a sequence 1,2,3,4,5,6,8,9,10,12,15,.....showing first 11 ugly 
    numbers. Ugly numbers are the numbers whose only prime factors are 2,3 or 5. 
    1 is also considered as an ugly number. Now, your task is to find the nth 
    ugly of the sequence if n is given to you.

				completed true
 #############################################################################*/ 
 import java.util.Arrays;
 public class FindNthNumber{
    public static boolean isUgly(int[]storage, int key, int start, int end){
        if(end<start) return false;
        
        int mid = (start+end)/2;
        if(storage[mid] == key) return true;
        if(key<storage[mid]) return isUgly(storage,key,start,mid-1);
        return isUgly(storage,key,mid+1,end);
    }

 	public static int uglyNumber(int n) {
        // time complexity O(n*Integer.MAX_VALUE);
        if(n<7) return n;
        int[] storage = new int[n+1];
        int i =7, nextNumber = 7;
        for(i = 0; i<7;i++) storage[i] = i;
        while(n>=i){
            // System.out.print(i);
            boolean check = true;
            while(check){
                if(nextNumber%2==0 && isUgly(storage,nextNumber/2,0,i-1)){
                    check = false;
                    continue;
                }
                if(nextNumber%3==0 && isUgly(storage,nextNumber/3,0,i-1)){
                    check = false;
                    continue;
                }
                if(nextNumber%5==0 && isUgly(storage, nextNumber/5,0,i-1)){
                    check = false;
                    continue;
                }
                nextNumber++;
            }
            storage[i] = nextNumber;
            nextNumber++;
            i++;
        }
        System.out.println(Arrays.toString(storage));
        return storage[n];

    }
// // little better one 
//     // instead making it fast it makes it slow;
//     public static boolean isUgly(int[]storage, Boolean[] storageUgly, int key, int start, int end){
//         // storing the this recursion so time complexity can be decresed
//         if(storageUgly[key]!=null){
//             // System.out.println("usde storage");
//             return storageUgly[key];
//         }
//         if(end<start) return false;
        
//         int mid = (start+end)/2;
//         if(storage[mid] == key){
//             storageUgly[key] = true;
//             return true;
//         }
//         if(key<storage[mid]){
//             storageUgly[key] = isUgly(storage,storageUgly ,key,start,mid-1);
//             return storageUgly[key];
//         }
//         storageUgly[key] = isUgly(storage,storageUgly ,key,mid+1,end);
//         return storageUgly[key];
//     }
//     public static int uglyNumber1(int n) {
//         if(n<7) return n;
//         int[] storage = new int[n+1];
//         System.out.println("start building");
//         Boolean[] storageUgly = new Boolean[Integer.MAX_VALUE/10];
//         System.out.println("end building");
//         int i =7, nextNumber = 7;
//         for(i = 0; i<7;i++) storage[i] = i;
//         while(n>=i){
//             // System.out.print(i);
//             boolean check = true;
//             while(check){
//                 if(nextNumber%2==0 && isUgly(storage, storageUgly, nextNumber/2,0,i-1)){
//                     check = false;
//                     continue;
//                 }
//                 if(nextNumber%3==0 && isUgly(storage, storageUgly, nextNumber/3,0,i-1)){
//                     check = false;
//                     continue;
//                 }
//                 if(nextNumber%5==0 && isUgly(storage, storageUgly,  nextNumber/5,0,i-1)){
//                     check = false;
//                     continue;
//                 }
//                 nextNumber++;
//             }
//             storage[i] = nextNumber;
//             nextNumber++;
//             i++;
//         }
//         // System.out.println(Arrays.toString(storage));
//         return storage[n];

//     }
    public static int uglyNumber2(int n) {
        // time complexity O(n*n); worked man
        if(n<7) return n;
        int[] storage = new int[n+1];
        int i =7, nextNumber = 7;
        for(i = 0; i<7;i++) storage[i] = i;
        int ithNumber = Integer.MAX_VALUE, temp = 0;
        while(n>=i){
            ithNumber = Integer.MAX_VALUE;
            for(int j = 2;j<i;j++){
                // if(2*storage[j]>ithNumber) break;
                if(storage[j]*2>storage[i-1]) temp = storage[j]*2;
                else if(storage[j]*3>storage[i-1]) temp = storage[j]*3;
                else if(storage[j]*5>storage[i-1]) temp = storage[j]*5;
                if(temp<ithNumber) ithNumber = temp;
            }
            storage[i] = ithNumber;
            i++;
        }
        System.out.println(Arrays.toString(storage));
        return storage[n];

    }
    public static void main(String[] args) {
        int n = 110;
        System.out.println(uglyNumber(n));
        // System.out.println(uglyNumber1(n));
        System.out.println(uglyNumber2(n));
        // System.out.println((1500*1500)+" "+ Integer.MAX_VALUE);
    }
 }
// 859963392
// 859963392