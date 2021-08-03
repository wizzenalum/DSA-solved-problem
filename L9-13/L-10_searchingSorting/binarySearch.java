public class binarySearch{
// only work when array is sorted.
	public static int binarySearch(int[] arr, int x) {
    	int start = 0,end=arr.length-1,send=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==x){
                send = mid;
                break;
            }
            else if(arr[mid]<x) start = mid+1;
            else end=mid-1;
        }
        return send;
    }

	public static int binarySearch(int[] arr, int n, int start, int end){
		
		int mid = (end+start)/2;
		if(arr[mid]==n) return mid;
		else if(arr[mid]<n) return binarySearch(arr,n,mid+1,end);
		return binarySearch(arr,n,start,mid);
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		System.out.print(search.binarySearch(arr,5)); 
	}

}