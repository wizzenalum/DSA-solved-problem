import java.util.Arrays;
import java.util.Scanner;
public class largestPalindrome{					

	public static void main(String[] args){
		// Scanner scan = new Scanner(System.in);
		// String str = scan.nextLine();
		// int posibleChange = scan.nextInt();
		String str = "90000";
		int posibleChange = 2;
		char[] arr = str.toCharArray();
		int needOfChange = 0;
		for(int i=0,j=arr.length-1;i<j;i++,j--){
			if(arr[i]!=arr[j]) needOfChange++;
			
		}
		System.out.println(needOfChange);
		if(needOfChange>posibleChange){
			System.out.print("NOT POSSIBLE");
			return;
		}
		for(int i=0,j=arr.length-1;i<=j;i++,j--){
			if(arr[i]==arr[j]){
				if(posibleChange-needOfChange>1){
					if(arr[i]=='9'||arr[j]=='9') posibleChange+=2;
					arr[i]=arr[j] = '9';
				    posibleChange-=2;
				}
			}else{
				if(posibleChange-needOfChange>0){
					if(arr[i]=='9'||arr[j]=='9') posibleChange++;
					arr[i]=arr[j] = '9';
					posibleChange-=2;
					needOfChange--;
				}else{
					if(arr[i]>arr[j]) arr[j]=arr[i];
					else arr[i]=arr[j];
				}
			}
		}
		if(posibleChange==1&&arr.length%2==1) {
			arr[arr.length/2]='9';
			posibleChange--;
		}
        for(char a:arr) System.out.print(a);	
	}
	// public static void main(String[] args){
	// 	// Scanner scan = new Scanner(System.in);
	// 	// String str = scan.nextLine();
	// 	// int posibleChange = scan.nextInt();
	// 	String str = "32453";
	// 	int posibleChange = 2;
	// 	char[] arr = str.toCharArray();
	// 	char[] newArr = str.toCharArray();
	// 	int needOfChange = 0;
	// 	for(int i=0,j=newArr.length-1;i<=j;i++,j--){
	// 		if(newArr[i]==newArr[j]) continue;
	// 		else if(newArr[i]<newArr[j]) newArr[i]=newArr[j];
	// 		else newArr[j]=newArr[i];
	// 		needOfChange++;
	// 	}
	// 	// System.out.println(needOfChange);
	// 	if(needOfChange>posibleChange){
	// 		System.out.print("NOT POSSIBLE");
	// 		return;
	// 	}
	// 	int count = posibleChange-needOfChange;
	// 	for(int i=0,j=arr.length-1;i<j;i++,j--){
	// 		if(arr[i]==arr[i]&&count>1){
	// 			newArr[i] = newArr[j] = '9';
	// 			count-=2;
	// 		}else if(arr[i]!=arr[j] && count>1){
	// 			if(newArr[i]>newArr[j]){
	// 				newArr[j]=newArr[i]='9';
	// 				count--;
	// 			}
	// 		}else if(arr[i]!=arr[j] && count>0){
	// 			if(newArr[i]>newArr[j]){
	// 				newArr[j]=newArr[i];
	// 				count--;
	// 			}
	// 		}
	// 	}
	// 	if(count>0&&arr.length%2==1) {
	// 		newArr[newArr.length/2]='9';
	// 	}
 //        for(char a:newArr) System.out.print(a);	
	// }

}