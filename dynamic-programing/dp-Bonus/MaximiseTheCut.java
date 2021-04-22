/*############################################################################
 							  Maximise the cut
	You are given a line segment of length L. You have to cut this line 
	segment in such a manner that the total number of segments of length 
	a, b, c are maximised.
	
	Note: The segments can only be of length a, b and c.

				completed true
 #############################################################################*/ 
 import java.util.Arrays;
 public class MaximiseTheCut{
 	// recursively oslve this.
 	 public static int maxSegments(int L, int a, int b, int c) {
 	 	// System.out.println(L);
        if(L==Math.min(a,Math.min(b,c))) return 1;
        if(L<a && L<b && L<c) return -1;
        int countSegment =0;
        countSegment = maxSegments(L-a,a,b,c);
        // System.out.println(countSegment);
        countSegment = Math.max(countSegment,maxSegments(L-b,a,b,c));
        countSegment = Math.max(countSegment,maxSegments(L-c,a,b,c));
        if(countSegment == -1) return -1;
        return countSegment+1;
    }
// dp itterative

    public static int maxSegments1(int L, int a, int b, int c) {
    	int[] storage = new int[L+1];
    	int minCut = Math.min(a,Math.min(b,c)), max=0;
    	storage[minCut] = 1;
    	for(int i=0;i<minCut;i++) storage[i] = -1;
    	int countSegment1 =0,countSegment2 =0,countSegment3 =0;
 		for(int i =minCut+1; i<=L;i++){
 			countSegment1 = -1; 
 			countSegment2 = -1;
 			countSegment3 = -1;
 			if(i-a>0) countSegment1 = storage[i-a];
 			if(i-b>0) countSegment2 = storage[i-b];
 			if(i-c>0) countSegment3 = storage[i-c];
 			max = Math.max(countSegment1,Math.max(countSegment2,countSegment3));
 			if(max == -1) storage[i] = -1;
 			else storage[i] = 1+max;
 		}
        if(storage[L] == -1) return -1;
        System.out.println(Arrays.toString(storage));
        return storage[L];
    }
    
    public static void main(String[] args) {
    	int L = 4;
    	int a =2,b=3,c=4;
 		L = 11;
		a= 10; b= 5; c= 21;

    	System.out.println(maxSegments(L,a,b,c));
    	System.out.println(maxSegments1(L,a,b,c));
    }
 }