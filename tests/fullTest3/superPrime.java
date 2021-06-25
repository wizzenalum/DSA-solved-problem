import java.util.ArrayList;
import java.util.HashMap;


// method will be 
// step 1 find array of primes.
// step 2 print super primes.
public class superPrime {

    // way 1 does'nt workked
    public static boolean checkPrime(HashMap<Integer,Integer> map,int newPrime) {
        for(int key: map.keySet()){
            if(newPrime%map.get(key)==0){
                return false;
            }
        }
        return true;
    }
    public static void createMap(HashMap<Integer,Integer> map, int n){
        int index = 1, newPrime = 0, mapIndex = 3;
        int supePrimeIndex = 1;
        boolean isPrime = false;
        while(newPrime<=n){
            newPrime = 6*index-1;
            isPrime = checkPrime(map, newPrime);
            if(isPrime){
                map.put(mapIndex++,newPrime);
            }
            newPrime = 6*index+1;
            isPrime = checkPrime(map, newPrime);
            if(isPrime){
                map.put(mapIndex++,newPrime);
            }
            if(map.containsKey(supePrimeIndex)){
                int spi = map.get(supePrimeIndex);
                if(map.containsKey(spi)&&map.get(spi)<=n){
                    // System.out.print(map.get(spi)+" ");
                    supePrimeIndex++;
                }
            }
            index++;
        }
        if(map.containsKey(supePrimeIndex)){
            int spi = map.get(supePrimeIndex);
            if(map.containsKey(spi)&&map.get(spi)<=n){
                // System.out.print(map.get(spi)+" ");
                supePrimeIndex++;
            }
        }   
    }
// second way don'nt worked
    public static ArrayList<Integer> primelist(int n) {
        if(n<2) return null;
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(2);
        if(n==2) return arrList;
        arrList.add(3);
        if(n==3) return arrList;
        int index=5 ,i = 1 ;
        while(index<=n){
            boolean check = true;
            for (int j = 0; j < arrList.size(); j++) {  
                if(index%arrList.get(j)==0){
                    check = false;
                    break;
                }
            }
            if(check) arrList.add(index);
            if((index+1)%6==0){
                index = 6*i+1;
                i++;
            }
            else index = 6*i-1;
        }
    
        return arrList;
    }

    // third way using aristotls sieves
    public static ArrayList<Integer> primeAristo(int n){
        boolean[] arr = new boolean[n+1];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = true;
        }
        for (int i = 2; i*i < arr.length; i++) {
            if(arr[i]){
                for (int j = 2; j*i < arr.length; j++) {
                    arr[i*j] = false;
                }
            }
        }
        // int count = 0;
        ArrayList<Integer> arrlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) arrlist.add(i);
            // if(arr[i]) count++;
        }
        // System.out.println(count);

        return arrlist;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = 10000000;
        map.put(1,2);
        map.put(2,3);
        // createMap(map,n);
        // System.out.println(count);
        // method use array instead of hash map.
        // ArrayList<Integer> arrlist = primelist(17);
        // System.out.println(arrlist.subList(0,arrlist.size()));
        // for (int i = 0; i < arrlist.size(); i++) {
        //     if(arrlist.get(i)<=arrlist.size()){
        //         System.out.print(arrlist.get(arrlist.get(i)-1)+" ");
        //     }
        // }

        // way 3
        ArrayList<Integer> arrlist = primeAristo(17);
        for (int i = 0; i < arrlist.size(); i++) {
            if(arrlist.get(i)<=arrlist.size()){
                System.out.print(arrlist.get(arrlist.get(i)-1)+" ");
            }
        }
        
    }
}
