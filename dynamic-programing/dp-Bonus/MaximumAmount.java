/*############################################################################
 							 Maximum Amount
	You are given N coins placed in a row with values C1, C2,...,CN. You 
	have to play a game with your friend.
	In each turn a player has to select a coin, either the last or the first 
	one from the row and then removes it from the row, and keeps the coin 
	to himself.
	You have to find the maximum possible value of coin that you can win if 
	you go first.

				completed true
 #############################################################################*/ 
 public class MaximumAmount{
 	public static int winAmount(int[] arr,int start, int end) {
 		// here other player is not playing smamrtly or he is just helping me to get max value
 		// that why it is wrong i have to make other player smart too.
 		if(arr.length<=start||arr.length<=end) return 0;
 		if(start==end) return arr[start];
 		if(end<start) return 0;
 		int max =0, max1=0,max2=0,temp1=0,temp2=0;
 		// if i chose to play now from start then other player can play any one move.
 		// from 2 moves and i will left with following 2 cases to further play. 
 		temp1 = winAmount(arr,start+2,end); // he play from from start.
 		temp2 = winAmount(arr,start+1,end-1); // he play from end.
 		max1 = Math.max(temp1,temp2)+arr[start];
 		// if i chose to play now from end then other player can play any one move.
 		// from 2 moves and i will left with following 2 cases to further play. 
 		// temp1 = winAmount(arr,start+1,end-1); // he play from from start.
 		temp1 = temp2;
 		temp2 = winAmount(arr,start+1,end-2); // he play from end.
 		max2 = Math.max(temp1,temp2)+arr[end];
 		max = Math.max(max1,max2);
 		return max;
    }
    static class Pair{
    	int move;// move = -1 means both move can be done.
    	int maxAmount;
    	Pair(int move, int maxAmount){
    		this.move = move;
    		this.maxAmount = maxAmount;
    	}
    }
    public static Pair winAmount1(int[] arr,int start, int end) {
    	// terminatating conditions.
    	System.out.println(start+" "+end);
 		if(arr.length<=start||arr.length<=end||end<start){
 			System.out.println("r0r -1 0");
 			return new Pair(-1,0);
 		}
 		if(start==end){
 			System.out.println("r1r "+start+" "+arr[start]);
 			return new Pair(start,arr[start]);	
 		}
 		int max =0, max1=0,max2=0,temp1=0,temp2=0,move=0;
 		if(start+1==end){
 			move = start;
 			max = arr[end];
 			if(arr[start]>arr[end]) max = arr[start];	
 			if(arr[start]<arr[end]) move = end;	
 			if(arr[start]==arr[end]) move = -1;
 			System.out.println("r2r "+move+" "+max);
 			return new Pair(move,max);
 		}
 		// variables to be used
 		Pair opo1, opo2;
 		// if i chose to play now from start then other player can play any one move from 2 moves opo1,opo2.
 		opo1 = winAmount1(arr,start+1,end);
 		if(opo1.move == start+1||opo1.move==-1){
	 		temp1 = winAmount1(arr,start+2,end).maxAmount; // he play from from start.
 		}
 		if(opo1.move == end||opo1.move==-1){
	 		temp2 = winAmount1(arr,start+1,end-1).maxAmount; // he play from end.
 		}
 		max1 = Math.max(temp1,temp2)+arr[start];
 		// second move by the oponent;
 		temp1=0;
 		temp2=0;
 		opo2 = winAmount1(arr,start,end-1);
 		if(opo2.move == start||opo2.move==-1){
	 		temp1 = winAmount1(arr,start+1,end-1).maxAmount; // he play from from start.
 		}
 		if(opo2.move == end-1||opo2.move==-1){
	 		temp2 = winAmount1(arr,start,end-2).maxAmount; // he play from end.
 		}
 		max2 = Math.max(temp1,temp2)+arr[end];

 		if(max1>max2) move = start;
 		if(max1<max2) move = end;
 		if(max1==max2) move = -1;
 		max = Math.max(max1,max2);
		System.out.println("r3r "+move+" "+max);
 		return new Pair(move,max);
    }

    public static Pair winAmount1(int[] arr,int start, int end, Pair[][] storage) {
    	// terminatating conditions.
    	// System.out.println(start+" "+end);
 		if(arr.length<=start||arr.length<=end||end<start){
 			// System.out.println("r0r -1 0");
 			return new Pair(-1,0);
 		}
 		if(start==end){
 			// System.out.println("r1r "+start+" "+arr[start]);
 			return new Pair(start,arr[start]);	
 		}
 		if(storage[start][end]!=null){
 			System.out.println("storage");
 			return storage[start][end];
 		}
 		// variables to be used
 		int max =0, max1=0,max2=0,temp1=0,temp2=0,move=0;
 		Pair opo1, opo2;
 		// if i chose to play now from start then other player can play any one move from 2 moves opo1,opo2.
 		opo1 = winAmount1(arr,start+1,end,storage);
 		if(opo1.move == start+1||opo1.move==-1){
	 		temp1 = winAmount1(arr,start+2,end,storage).maxAmount; // he play from from start.
 		}
 		if(opo1.move == end||opo1.move==-1){
	 		temp2 = winAmount1(arr,start+1,end-1,storage).maxAmount; // he play from end.
 		}
 		max1 = Math.max(temp1,temp2)+arr[start];
 		// second move by the oponent;
 		temp1=0;
 		temp2=0;
 		opo2 = winAmount1(arr,start,end-1,storage);
 		if(opo2.move == start||opo2.move==-1){
	 		temp1 = winAmount1(arr,start+1,end-1,storage).maxAmount; // he play from from start.
 		}
 		if(opo2.move == end-1||opo2.move==-1){
	 		temp2 = winAmount1(arr,start,end-2,storage).maxAmount; // he play from end.
 		}
 		max2 = Math.max(temp1,temp2)+arr[end];

 		if(max1>max2) move = start;
 		if(max1<max2) move = end;
 		if(max1==max2) move = -1;
 		max = Math.max(max1,max2);
		// System.out.println("r3r "+move+" "+max);
		storage[start][end] = new Pair(move,max);
 		return storage[start][end];
    }
    public static int winAmount1(int[] arr,int start, int end, int[][] storage) {
    	// this is also same as prvious but here i am choosing the step at which me left with lesser amount.
    	// System.out.println(start+" "+end);
 		if(arr.length<=start||arr.length<=end||end<start){
 			// System.out.println("r0r -1");
 			return -1;
 		}
 		if(start==end){
 			// System.out.println("r1r "+arr[start]);
 			return arr[start];	
 		}
 		if(storage[start][end]!=-1){
 			System.out.println("storage");
 			return storage[start][end];
 		}
 		// variables to be used
 		int max =0, min1=0,min2=0,temp1=0,temp2=0,move=0;
 		// if i chose to play now from start then other player can play any one move from 2.
 		// and i left with following two moves.
 		temp1 = winAmount1(arr,start+2,end,storage); 
 		temp2 = winAmount1(arr,start+1,end-1,storage);
 		if(temp1!=-1&&temp2!=-1){
	 		min1 = Math.min(temp1,temp2);
 		}
 		if(temp1!=-1&&temp2==-1){
	 		min1 = temp1;
 		}
 		if(temp1==-1&&temp2!=-1){
	 		min1 = temp2;
 		}
 		min1 += arr[start];
 		// second move by the oponent;
 		
 		temp1 = winAmount1(arr,start+1,end-1,storage); // he play from from start.
 		temp2 = winAmount1(arr,start,end-2,storage); // he play from end.
 		if(temp1!=-1&&temp2!=-1){
	 		min2 = Math.min(temp1,temp2);
 		}
 		if(temp1!=-1&&temp2==-1){
	 		min2 = temp1;
 		}
 		if(temp1==-1&&temp2!=-1){
	 		min2 = temp2;
 		}
 		min2 += arr[end];

 		max = Math.max(min1,min2);
 		storage[start][end] = max;
 		// System.out.println("r3r "+max);
 		return max;
    }
 	// public static int winAmount(int[] arr) {
 	// 	// according to me this dont have iterative because i dont know where to end.
 	// 	int size = arr.length;
 	// 	if(size<=0) return 0;
  //   	Pair[][] storage = new Pair[size][size];
		
		// int i =(size/2)-1, max1 =0, max2 = 0, max = 0, index =0;
		// if(size%2==0) {
		// 	max = Math.max(arr[size/2],arr[(length/2)-1]);
		// 	storage[size/2] = max;
		// 	storage[(size/2)-1] = max;
		// 	i--;
		// }
		// while(i>=0){
		// 	max1 = storage[i+1];
		// 	max2 = storage[size-i-2];
		// 	max = Math.max(max1,max2);
		// 	storage[i] = max + arr[i];
		// 	storage[size-i-1] = max + arr[size-i-1];
		// 	i--;
		// }
		// max = Math.max(storage[0],storage[size-1]);
		// return max;

  //   }
 	

    public static void main(String[] args) {
    	int[] arr = {4, 6, 5,5,4,3,2}; // answer is 9;
    	// int[] arr = {9,16,4,8};
    	// int[] arr = {2,9};
    	// System.out.println(winAmount(arr,0,arr.length-1));
    	// System.out.println(winAmount1(arr,0,arr.length-1).maxAmount);
    	Pair[][] storage = new Pair[arr.length][arr.length];
    	System.out.println(winAmount1(arr,0,arr.length-1,storage).maxAmount);

    	int[][] storage1 = new int[arr.length][arr.length];
    	for(int i =0;i<arr.length;i++){
    		for(int j = 0;j<arr.length;j++) storage1[i][j] = -1;
    	}
    	System.out.println(winAmount1(arr,0,arr.length-1,storage1));
    }
 }