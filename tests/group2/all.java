package group2;

public class all {
    static int count;
    public static void allWay(int x, int n,int i,int sum) {
       System.out.println(x+" "+n+" "+i+" "+sum);
        
        if(sum==x){
            count++;
            return;
        }

        double num = Math.pow(n,i);
        if(num/n>x||sum>x) return;
        allWay(x, n, i+1, sum);
        sum += num;
        allWay(x, n, i+1, sum);
    }
    public static int allWays(int x, int n) {
       count = 0;
        allWay(x,n,1, 0);
        return count;
    }
    public static void main(String[] args) {
       System.out.println(allWays(25,2));
    }
}
