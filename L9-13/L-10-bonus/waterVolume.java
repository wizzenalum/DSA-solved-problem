import java.util.Scanner;
public class waterVolume{
	public static int volume(int[] arr, int start, int end,int level){
		int sum = 0;
		for(int i=start+1; arr[start]<arr[end] && i<end;i++){
			if(arr[i]<arr[start]){
				if(arr[i]>level) sum +=arr[start]-arr[i];
				else sum += arr[start]-level;
			} 
		}
		for(int i=end-1; arr[start]>arr[end] && i>start;i--){
			if(arr[i]<=arr[end]){
				if(arr[i]>level) sum +=arr[end]-arr[i];
				else sum += arr[end]-level;
			}
		}return sum;
	}

	public static int waterVolume(int[] arr,int n){
		int start=0, end=n-1, volume = 0, level=0;
		boolean flags = false, flage = false;
		while(start<end){
			if(flags || flage){
				if(flags){
					if(arr[start]>level) flags=false;
					else start++;
				}else{
					if(arr[end]>level) flage = false;
					else end--;
				}
			}else{
				if(arr[start]<arr[end]){
					volume += volume(arr,start,end,level);
					level = arr[start];
					flags = true;
					start++;
				}else{
					volume+=volume(arr,start,end,level);
					level = arr[end];
					flage = true;
					end--;
				}
			}
		}return volume;
	}
		
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i] = scanner.nextInt();
		System.out.print(waterVolume(arr,n));

	}
}