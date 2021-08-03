import java.util.Arrays;
public class StockSpan{
	public static int[] stockSpan(int[] price) {
		int [] arr = new int[price.length];
		arr[0] = 1;
		for(int i=1;i<price.length;i++){
			if(price[i-1]<price[i]){
				int count=1, k = i-1;
				while(k>=0&&price[k]<price[i]){
					count+=arr[k];
					k -= arr[k];
				}
				arr[i] = count;

			} 
			else{
				arr[i] = 1;
			}
		}
		return arr;	
	}
	
	public static void main(String[] args) {
		int[] stock = {100,80,60,70,60,75,85};
		System.out.println(Arrays.toString(stockSpan(stock)));

		
	}
}