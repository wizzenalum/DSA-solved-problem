/*############################################################################
						    N-digit number with given sum

	You are given an integral value n and a sum value, you have to find all 
	those n digit numbers whose digit sum is equal to the given sum.

				completed true;
#############################################################################*/	

class NdigitNumberForSum{

	public static void findHelper(int[] arr,int sum, int presum, int index){
		if(arr.length<=index){
			if(sum==presum){
				for(int ele:arr) System.out.print(ele);
				System.out.print(" ");
			}
			return;
		}
		if(presum>sum) return;
		for(int i = arr[index];i<10;i++){
			arr[index] = i;
			findHelper(arr,sum,presum+i,index+1);
		}
		arr[index] = 0;
	}

	public static void find(int digits, int sum) {
		if(digits<1) return;
		if(sum<1) {
			// System.out.print("0"); 
			return;
		}
		int[] arr = new int[digits];
		arr[0] = 1;
		findHelper(arr,sum,0,0);
	}
			
	public static void main(String[] args) {
		find(6,2);
	}
}