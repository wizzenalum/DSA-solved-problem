/*############################################################################
 							     Total Gifts

    A man is giving gifts to some kids. The kids are standing in a row on 
    stairs, at different heights. Each kid should receive at least one gift. 
    If two adjacent kids are at different heights, then the kid that is higher 
    should receive one more gift than that is lower down. If two kids are at 
    same height, then their gifts relative to each other doesn't matter. You 
    are given number of kids and the heights of kids in order, then find the 
    minimum number of gifts man has to bring to distribute between those kids.

				completed ture
 #############################################################################*/ 
 import java.util.Arrays;
 public class TotalGifts{
 	public static int minGifts(int[] heights) {
        if(heights.length<=0) return 0;
        if(heights.length==1) return 1;
        int[] giftArr = new int[heights.length];
        giftArr[0] = 1;
        for(int i = 1; i<giftArr.length;i++){
            if(heights[i]>heights[i-1]) giftArr[i] = 1+giftArr[i-1];
            else giftArr[i] = 1;
        }
        for(int i = giftArr.length-2;i>=0;i--){
            System.out.println(i);
            if(heights[i]>heights[i+1]&&giftArr[i]<=giftArr[i+1]) giftArr[i] = 1+giftArr[i+1];
        }
        int count = 0;
        for(int i = 0; i<giftArr.length;i++) count += giftArr[i];
        System.out.println(Arrays.toString(giftArr));
        return count;
    }

    public static void main(String[] args) {
        int[] heights = {2,5,4,7,3,2};
        // int[] heights = {2,1,3,4,5};
        System.out.println(minGifts(heights));
    }
 }