/*############################################################################
 							Magic Grid

	You are given a magic grid A with R rows and C columns. In the cells of 
	the grid, you will either get magic juice, which increases your strength 
	by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. 
	If at any point of the journey, the strength points become less than or equal 
	to zero, then you will die.
	You have to start from the top-left corner cell (1,1) and reach at the 
	bottom-right corner cell (R,C). From a cell (i,j), you can only move either 
	one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not 
	move outside the magic grid. You have to find the minimum number of strength 
	points with which you will be able to reach the destination cell.

				completed true
				
 #############################################################################*/ 
 public class MagicGrid{
 	
 	public static int getStrength(int[][] grid) {
 		// this is wrong answer but give you health by which you can survive but it wont be least
 		int[][] storage = new int[grid.length+1][grid[0].length+1];
 		int i=0, j=0, min=0, temp=0;

 		for(i=grid.length;i>=0;i--){
 			storage[i][grid[0].length]=Integer.MAX_VALUE;
 		}
		for(j = grid[0].length;j>=0;j--){
			storage[grid.length][j]=Integer.MAX_VALUE;
		}
		// for(int[] arr:storage){
		// 	for(int ele:arr) System.out.print(ele+" ");
		// 	System.out.println();
		// }
 		for(i=grid.length-1;i>=0;i--){
 			for(j = grid[0].length-1;j>=0;j--){
 				temp = storage[i+1][j];
 				min = Math.min(temp,storage[i][j+1]);
 				if(min==Integer.MAX_VALUE){
 					storage[i][j] = 0;
 					continue;
 				}
 				if(min==0) min++;
 				if(grid[i][j]<0){
 					min = min+Math.abs(grid[i][j]);
 				}
 				System.out.println(min);
 				storage[i][j] = min;
 			}
 		} 
 		for(int[] arr:storage){
			for(int ele:arr) System.out.print(ele+" ");
			System.out.println();
		}
 		return storage[0][0];

    }
    public static int getMinimumStrength(int[][] grid,int i, int j, int money) {
 		// for same path choose minimum and for other path choose maximum.
    	System.out.println(i+" "+j+" "+money);
 		if(i>=grid.length-1 && j>=grid[0].length-1){
 			System.out.println("r0  "+money);
 			return money;
 		}
 		int current = money+grid[i][j], min1 = 0, min2 = 0;
 		if(i+1<grid.length){
	 		min1 = getMinimumStrength(grid,i+1,j,money+grid[i][j]);
 		}
 		if(min1>current) min1=current;
		if(j+1<grid[0].length){
			min2 = getMinimumStrength(grid,i,j+1,money+grid[i][j]);
		}
 		if(min2>current) min2 = current;
 		int max = Math.max(min1,min2);
 		System.out.println("r1   "+max);
 		return max;
 	}

 	public static int getMinimumStrength(int[][] grid,int i, int j, int money, int[][] storage) {
 		// for same path choose minimum and for other path choose maximum.
    	// System.out.println(i+" "+j+" "+money);
 		if(i>=grid.length-1 && j>=grid[0].length-1){
 			// System.out.println("r0  "+money);
 			return money;
 		}
 		if(storage[i][j]>=money){
 			// System.out.println("used from storage");
 			return storage[i][j];
 		}
 		int current = money+grid[i][j], min1 = 0, min2 = 0;
 		if(i+1<grid.length){
	 		min1 = getMinimumStrength(grid,i+1,j,money+grid[i][j],storage);
 		}
 		if(min1>current) min1=current;
		if(j+1<grid[0].length){
			min2 = getMinimumStrength(grid,i,j+1,money+grid[i][j],storage);
		}
 		if(min2>current) min2 = current;
 		int max = Math.max(min1,min2);
 		// System.out.println("r1   "+max);
 		storage[i][j] = max;
 		return storage[i][j];
 	}
/////////////////////////############  did same mistake  by passing the money ####///////
 // it can be done by just asking what it is need to start from next one.
 	public static int getMinimumStrength(int[][] grid,int i, int j) {
 		if(i>=grid.length-1 && j>=grid[0].length-1) return 1;
 		int health=0, health1 = Integer.MAX_VALUE, health2 =Integer.MAX_VALUE;// this show needed heasth from current cell.
 		if(i+1<grid.length){
	 		health1 = getMinimumStrength(grid,i+1,j);
	 		health1 = health1-grid[i+1][j]; // needed health from i+1,j paht starting from i,j
 		}
 		if(j+1<grid[0].length){
	 		health2 = getMinimumStrength(grid,i,j+1);
	 		health2 = health2-grid[i][j+1]; // needed health from i,j+1 paht starting from i,j
 		}
 		health = Math.min(health2,health1);
 		if(health<=0) health = 1;
 		//health2, health1 show needed health if we move from next steps.

 		return health;
 	}

 	public static int getMinimumStrength(int[][] grid) {
 		if(grid.length<=0) return 1;
 		int[][] storage = new int[grid.length][grid[0].length];
		storage[grid.length-1][grid[0].length-1] = 1;

 		int health=0, health1 = Integer.MAX_VALUE, health2 =Integer.MAX_VALUE;// this show needed heasth from current cell.
 		int i = grid.length-1, j = grid[0].length-2;
 		while(i>=0&&j>=0){
 			health1 = Integer.MAX_VALUE; 
 			health2 =Integer.MAX_VALUE;
	 		if(i+1<grid.length){
		 		health1 = storage[i+1][j];
		 		health1 = health1-grid[i+1][j]; // needed health from i+1,j paht starting from i,j
	 		}
	 		if(j+1<grid[0].length){
		 		health2 = storage[i][j+1];
		 		health2 = health2-grid[i][j+1]; // needed health from i,j+1 paht starting from i,j
	 		}
	 		health = Math.min(health2,health1);
	 		if(health<=0) health = 1;
	 		// System.out.println("ittration "+i+" "+j+" "+health);
	 		storage[i][j] = health;
	 		if(j>0) j--;
	 		else{
	 			j = grid[0].length-1;
	 			i--;
	 		}
 		}
 	// 	for(int[] arr:storage){
		// 	for(int ele:arr) System.out.print(ele+" ");
		// 	System.out.println();
		// }
 		return storage[0][0];
 	}

    public static void main(String[] args) {
    	// int[][] grid = {{0, 2 ,-4},
					// 	{2, -2, 0}};
    	// int[][] grid = {
					// 	{2, 2},
					// 	{0, 1},
					// 	{2, 0}};
    	// int[][] grid = {{0 ,-2, -3, 1},
					// 	{-1, 4, 0 ,-2},
					// 	{1 ,-2, -3, 0}};
		// int[][] grid = {
		// 				{0, 1 ,-3},
		// 				{1, -2, 0}};
		int[][] grid = {{0 ,-2, -3, 1},
						{-1, 4, 0 ,-2},
						{1 ,1, 1, 0}};
    	// System.out.println(getStrength(grid));
    	int MAX = Integer.MAX_VALUE/2,min =0;
		// min = getMinimumStrength(grid,0,0,MAX);
		if(min>=MAX) min = 1;
		else min = MAX -min + 1;

    	// System.out.println(min);
		// int[][] storage = new int[grid.length][grid[0].length];
		// min = getMinimumStrength(grid,0,0,MAX,storage);
		// if(min>=MAX) min = 1;
		// else min = MAX -min + 1;
  //   	System.out.println(min);
    	System.out.println(getMinimumStrength(grid,0,0));
    	System.out.println(getMinimumStrength(grid));



    }
 }