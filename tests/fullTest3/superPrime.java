import java.util.HashMap;

public class superPrime {
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
                if(map.containsKey(spi)||map.get(spi)<=n){
                    System.out.print(map.get(spi)+" ");
                    supePrimeIndex++;
                }
            }
            index++;
        }
        if(map.containsKey(supePrimeIndex)){
            int spi = map.get(supePrimeIndex);
            if(map.containsKey(spi)||map.get(spi)<=n){
                System.out.print(map.get(spi)+" ");
                supePrimeIndex++;
            }
        }   
    }
    // public static void printSuperPrime(HashMap<Integer,Integer> map, int n) {
    //     int index = 1, supePrimeIndex = 0;
    //     while(true){
    //         supePrimeIndex = map.get(index);
    //         if(!map.containsKey(supePrimeIndex)||map.get(supePrimeIndex)>n) break;
    //         System.out.print(map.get(supePrimeIndex)+" ");
    //         index++;
    //     }
        
    // }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = 17;
        map.put(1, 2);
        map.put(2,3);
        createMap(map,n);
        // printSuperPrime(map, n);
        // System.out.println(map.entrySet()+"\n"+map.size());
    }
}
