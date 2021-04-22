 /*############################################################################
 							 Edit Distance

	You are given two strings S and T of lengths M and N, respectively. Find 
	the 'Edit Distance' between the strings.
	Edit Distance of two strings is the minimum number of steps required to 
	make one string equal to the other. In order to do so, you can perform the 
	following three operations:

		1. Delete a character
		2. Replace a character with another one
		3. Insert a character


			completed true
 #############################################################################*/ 
public class EditDistance{
	// recursion 
	public static int distance(String s, String t, int indexS, int indexT){
		// System.out.print(indexS+" "+indexT+" ");
		if(s.length()<=indexS&&t.length()<=indexT){
			// System.out.println("r0 ");
			return 0;

		}
		if(s.length()<=indexS){
			// System.out.println("r1 "+(t.length()-indexT));
			return t.length()-indexT;
		} 
		if(t.length()<=indexT){
			// System.out.println("r2 "+(s.length()-indexS));
			return s.length()-indexS;
		}

		int min = 0;
		if(s.charAt(indexS)==t.charAt(indexT)){
			min = distance(s,t,indexS+1, indexT+1);
			// System.out.println("r3 "+min);
			return min;
		}
		min = distance(s,t,indexS+1,indexT+1);// it is for replaceing the character
		min = Math.min(min,distance(s,t,indexS+1,indexT));
		min = Math.min(min,distance(s,t,indexS,indexT+1));

		// System.out.println("r4 "+(min+1)+" ");
		return min+1;
	}
	// memoization
	public static int distance(String s, String t, int indexS, int indexT, int[][] storage){
		// System.out.print(indexS+" "+indexT+" ");
		if(s.length()<=indexS&&t.length()<=indexT){
			// System.out.println("r0 ");
			return 0;
		}
		if(s.length()<=indexS){
			// System.out.println("r1 "+(t.length()-indexT));
			return t.length()-indexT;
		} 
		if(t.length()<=indexT){
			// System.out.println("r2 "+(s.length()-indexS));
			return s.length()-indexS;
		}
		if(storage[indexS][indexT]!=-1){
			// System.out.print("used storage");
			return storage[indexS][indexT];
		} 

		int min = 0;
		if(s.charAt(indexS)==t.charAt(indexT)){
			min = distance(s,t,indexS+1, indexT+1,storage);
			storage[indexS][indexT] = min;
			// System.out.println("r3 "+min);
			return min;
		}
		min = distance(s,t,indexS+1,indexT+1,storage);// it is for replaceing the character
		min = Math.min(min,distance(s,t,indexS+1,indexT,storage));
		min = Math.min(min,distance(s,t,indexS,indexT+1,storage));

		// System.out.println("r4 "+(min+1)+" ");
		storage[indexS][indexT] = min+1;
		return min+1;
	}
	// ittrative DP
	public static int editDistance(String s, String t) {
		int indexS = s.length()-1, indexT=t.length()-1, min = 0;
		int[][] storage = new int[s.length()+1][t.length()+1];
		storage[s.length()][t.length()] = 0;		
		for(int i=0;i<s.length();i++){
			storage[i][t.length()] = s.length()-i;
		}
		for(int i=0;i<t.length();i++){
			storage[s.length()][i] = t.length()-i;
		}

		while(indexS>=0&&indexT>=0){
			System.out.println(indexS+" "+indexT);
			if(s.charAt(indexS)==t.charAt(indexT)){
				min = storage[indexS+1][indexT+1];
			}else{
				min = storage[indexS+1][indexT+1];
				min = Math.min(min,storage[indexS+1][indexT]);
				min = Math.min(min,storage[indexS][indexT+1]);
				min = min+1;
			}
			storage[indexS][indexT] = min;

			if(indexS>0){
				indexS--;
			}else{
				indexS = s.length()-1;
				indexT--;
			}
		}
		return storage[0][0];
    }
	public static void main(String[] args) {
		String s = "abcsf", t = "adc";
		System.out.println(distance(s,t,0,0));
		int[][] storage = new int[s.length()][t.length()];
		for(int i=0;i<s.length();i++){
			for(int j=0;j<t.length();j++) storage[i][j] = -1;
		}
		System.out.println(distance(s,t,0,0,storage));
		System.out.println(editDistance(s,t));
	}
}