/*############################################################################
 							      Highway Revenue

    We have a highway of K miles. You have to place billboards on that highway 
    such that the revenue is maximised. You can place the billboards on the 
    given possible sites only, which can be x1, x2, ...., xn, here, xi 
    represents positions in miles measured from one end of the road. By placing 
    a billboard on xi you will get a revenue of ri. There is a restriction that 
    no two billboards can be placed within m miles or less than it.

				completed false
 #############################################################################*/ 
 import java.util.Arrays;
 public class HighwayRevenue{
    // public static int maxRevenue(int k, int m, int[] position, int[] revenue,) {

    // }
 	public static int maxRevenue(int k, int m, int[] position, int[] revenue) {
        int len = position.length;
        if(len<=0) return 0;
        if(len==1) return revenue[0];
        int[] storage = new int[len];
        int i = position.length-1, maxRevenue = 0, temp = 0;
        storage[i] = revenue[i];
        for(i = i-1; i>=0;i--){
            if(position[i+1]-position[i]>m) maxRevenue = revenue[i]+storage[i+1];
            else{
                // if i choose to remove cuurent then max
                temp = storage[i+1];
                int j = i+2;
                while(j<len && position[j]-position[i]<=m) j++;
                if(j>=len) maxRevenue = revenue[i];
                else  maxRevenue = revenue[i]+storage[j];
                maxRevenue = Math.max(temp, maxRevenue);
            }
           storage[i] = maxRevenue; 
        }
        return storage[0];
    }

    public static void main(String[] args) {
        int[] position = {6,9,12,14};
        int[] revenue = {5,6,3,7};
        // int[] heights = {2,1,3,4,5};
        System.out.println(maxRevenue(15,2,position,revenue));
    }
 }