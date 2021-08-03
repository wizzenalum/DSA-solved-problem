 /*############################################################################
 							LCS - Problem

	Given two strings, S and T with lengths M and N, find the length of the 
	'Longest Common Subsequence'.
	For a string 'str'(per se) of length K, the subsequences are the 
	strings containing characters in the same relative order as they are 
	present in 'str,' but not necessarily contiguous. Subsequences contain 
	all the strings of length varying from 0 to K.
			completed true true true true false for topdown dp itterative approach
 #############################################################################*/ 
public class LCSProblem{
// method 1 bruitforce method
	public static boolean check(char a, String str, String b){
		// here i am checking only first letter and rest is available here always
		// this is working for a!=str.charAt(0) case correct but fails if a = a, str = aabac
		// and b = daabaca & dabaaca. 
		int posA=-1, freq=0;
		if(a!=str.charAt(0)){
			for(int i = 0; i < b.length();i++){
				if(a==b.charAt(i)){
					posA = i;
				}
				if(str.charAt(0)==b.charAt(i)){
					System.out.println(i+" posA "+ posA);
					if(i>posA && posA!=-1) return true;
					return false;
				}
			}
		}else{
			freq = 1;
			while(str.charAt(freq-1)==a) freq++;
			for(int i =0;i<b.length();i++){
				if(a == b.charAt(i)) freq--;
				if(freq==0) return true;
			}
		}
		return false;
	}
	public static boolean check2(String strA, String tobeCompared, int indexA, int indexB){
		// it will check whether tobeCompared can be subsequence string of strA or not.
		if(tobeCompared.length()<=indexB) return true;
		if(strA.length()<=indexA) return false;
		if(strA.charAt(indexA)==tobeCompared.charAt(indexB)) return check2(strA, tobeCompared,indexA+1,indexB+1);
		return check2(strA, tobeCompared, indexA+1,indexB);
	}
	// only backward recursion for retruning vlae;
	public static int lcsHelper(String s, String t, int index, String toCompare){
		if(s.length()<=index){
			if(check2(t,toCompare,0,0)) return toCompare.length();
			else return 0;
		}
		int count1 = lcsHelper(s,t,index+1,toCompare+s.charAt(index));

		int count2 = lcsHelper(s,t,index+1,toCompare);
		return count1>count2?count1:count2;
	}
	// forward and backward retrun values.
	public static int lcsHelper(String s, String t, int index, String toCompare,int count){
		if(s.length()<=index){
			if(toCompare.length()<=count) return count;
			if(check2(t,toCompare,0,0)) return toCompare.length();
			else return count;
		}
		count = lcsHelper(s,t,index+1,toCompare+s.charAt(index),count);
		count = lcsHelper(s,t,index+1,toCompare,count);
		return count;
	}

// method 2
	// recursion way
	public static int lcsHelper(String s, String t, int indexS, int indexT){
		if(s.length()<=indexS || t.length()<=indexT) return 0;
		if(s.charAt(indexS)==t.charAt(indexT)) return 1+lcsHelper(s,t,indexS+1,indexT+1);
		int count1 = lcsHelper(s,t,indexS+1,indexT);
		int count2 = lcsHelper(s,t,indexS,indexT+1);
		return count1>count2?count1:count2;
	}
	// memoization way..

	public static int lcsHelperMemo(String s, String t, int indexS, int indexT, int[][] storage){
		if(s.length()<=indexS||t.length()<=indexT) return 0;
		if(storage[indexS][indexT]!=-1){
			// System.out.println("from storage");
			return storage[indexS][indexT];
		}
		if(s.charAt(indexS)==t.charAt(indexT)){
			storage[indexS][indexT] = 1+lcsHelperMemo(s,t,indexS+1,indexT+1,storage);
			return storage[indexS][indexT];
		}
		int count1 = lcsHelperMemo(s,t,indexS+1,indexT,storage);
		int count2 = lcsHelperMemo(s,t,indexS,indexT+1,storage);
		storage[indexS][indexT]=count1>count2?count1:count2;
		return storage[indexS][indexT];
	}

	// itrerative way with dp.

	public static int lcsHelperItterDP(String s, String t){
		// top down approach
		// but failling somewhere which i dont know.
		int[][] storage = new int[s.length()+2][t.length()+2];
		// System.out.println(storage.length+" "+storage[0].length);
		int indexS =2, indexT=2, preCount=0, count=0;
		while(indexS<s.length()+2&&indexT<t.length()+2){
			preCount = storage[indexS-1][indexT-1];
			preCount = Math.max(preCount, storage[indexS-2][indexT-1]);
			preCount = Math.max(preCount, storage[indexS-1][indexT-2]);
			if(s.charAt(indexS-2)==t.charAt(indexT-2)){
				if(preCount+1>count) count = preCount+1;
				storage[indexS][indexT]=preCount+1;
			} 
			else{
				if(preCount>count) count = preCount;
				storage[indexS][indexT] = preCount;
			}
			if(indexS+1<s.length()+2) indexS++;
			else{
				indexS  = 2;
				indexT++;
			}

		}
		// 	System.out.println(indexS+" "+indexT);
		for(int[] arr:storage){
			for(int ele:arr) System.out.print(ele+" ");
			System.out.println();
		} 
		return count;
	}
	
	public static int lcsHelperItterDP2(String s, String t){
		// bottom up approach approach
		int[][] storage = new int[s.length()+1][t.length()+1];
		int indexS =s.length()-1, indexT=t.length()-1, count=0;

		while(indexS>=0 &&indexT>=0){
			if(s.charAt(indexS)==t.charAt(indexT)){
				count = 1+ storage[indexS+1][indexT+1];
			}else{
			count = storage[indexS+1][indexT];
			count = Math.max(count,storage[indexS][indexT+1]);
			}
			storage[indexS][indexT]=count;
			if(indexS>0) indexS--;
			else{
				indexS  = s.length()-1;
				indexT--;
			}

		}
			System.out.println(indexS+" "+indexT);
		for(int[] arr:storage){
			for(int ele:arr) System.out.print(ele+" ");
			System.out.println();
		} 
		return storage[0][0];
	}
	
	public static int lcs(String s, String t) {
		// return lcsHelper(s,t,0,"");
		// return lcsHelper(s,t,0,"",0);
	// method2
		//recursion
		// return lcsHelper(s,t,0,0);
		//memoization
		int[][] storage = new int[s.length()][t.length()];
		for(int i=0;i<s.length();i++){
			for(int j=0;j<t.length();j++) storage[i][j] = -1;
		}
		// return lcsHelperMemo(s,t,0,0,storage);

		// iterative dp
		return lcsHelperItterDP(s,t);
		// return lcsHelperItterDP2(s,t);

    }
	

	public static void main(String[] args) {
		// System.out.println(check('a', "abc", "cabcad")); // fails here.
		// System.out.println(check2("cabcad","aabc",0,0));
		System.out.println(lcs("abcdgfghdfaawretaaababwfawfafafafsdfhgdsgrfgdhfsfgdhfreeghdwg","gacbssadfagaegvwfaffvasfafffdfdsgfdertyhjgsghghsgshfmgshfafhd"));
	}
}