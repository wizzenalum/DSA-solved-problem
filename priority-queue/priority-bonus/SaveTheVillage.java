
/*#####################################################################################
                                 Save the village
    There is a small village present near the city, which is causing a lot of problems 
    to the people present in the city. So, the committee head (Shyam) of the city, wants 
    to destroy the village himself. Ram is the head of the village, so, he ordered his 
    soldiers to fight for the village.
    But Ram is confused whether they should confront Shyam or evacuate the villagers 
    including the soldiers. So, you have to help him out in this decision.

    Shyam has a strength of Z and is confident that he will succeed. Ram has N soldiers 
    under his command numbered 1 through N. Power of i-th soldier is denoted by Ai. 
    When a soldier attacks Shyam, his strength gets reduced by the corresponding power 
    of the soldier. However, every action has a reaction so the power of the soldier 
    also gets halved i.e. Ai changes to [Ai/2]. Each soldier may attack any number of 
    times (including 0).Shyam is defeated if his strength is reduced to 0 or less.
    Find the minimum number of times the soldiers need to attack so that the village 
    is saved.
    
    Input Format:
        The first line of input contains two space separated integers  N, Z.
        The second line contains N space-separated integers A1,A2,…,AN.

    Output Format:
        If Shyam cannot be defeated, this line should contain the string "Evacuate" 
        (without quotes). Otherwise, it should contain the minimum number of times the 
        soldiers need to attack.

    Constraints:
        1≤N≤105
        1≤Z≤108
        0≤Ai≤104
    
    Sample Input:
        6 30
        1 20 3 4 2 10

    Sample Output:
        2
                    completed: true;
#####################################################################################*/
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.BufferedReader;
public class SaveTheVillage {
    public static int compare(int a, int b){
		return a-b; // for max hipify;
		// return b-a; // for min hipify;
	}
	public static void swap(int[] arr, int index1, int index2){
		int swap = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = swap;
	}
	public static void downHipify(int[] arr, int element, int end){		
		if(end-element<1) return;
		int child = 0, child2 = 0, swap=0;
		while(element<end){
			// swap++;
		// System.out.println("insert" + element);
			child = element*2 +1;
			child2 = element*2 +2;
			if(child>=end || (child2>=end && compare(arr[element], arr[child])>=0)) return;
			if(child2>=end){
				swap(arr,child,element);
				return;
			}
			if((compare(arr[element],arr[child2])>=0 && compare(arr[element], arr[child])>=0)) return;
			if(compare(arr[element],arr[child2])<0 || compare(arr[element], arr[child])<0){
				if(compare(arr[child],arr[child2])>0){
					swap(arr, child, element);
					element = child;
				}
				else{
					swap(arr,child2,element);
					element = child2;
				}
			}

		}
	}
	

	public static void heapSort(int[] arr){
		// create heap first
			// downHipify(arr, 0, arr.length);
		for(int i = arr.length/2 - 1; i>=0;i--){
			downHipify(arr, i, arr.length);
		}

		// now sort the array.
		for(int i = arr.length-1;i>0;i--){
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			downHipify(arr,0,i);
		}
	}     
    public static void main(String[] args) throws IOException {
        FileReader is = new FileReader("/home/dipak/Bit_by_bit/DSA.learn/careercamp/priority-queue/priority-bonus/sampleTest.txt");
        // InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String[] str1 = br.readLine().trim().split(" ");
        String[] str2 = br.readLine().trim().split(" ");
        br.close();
        is.close();
        int n = Integer.parseInt(str1[0]);
        int z = Integer.parseInt(str1[1]);
    // method 1
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str2[i]);
        // creating heap
        for(int i = arr.length/2 - 1; i>=0;i--){
			downHipify(arr, i, arr.length);
		}

        int count = 0;
        while(true){
            if(arr[0]==0){
                System.out.println("Evacuate");
                return;
            }
            if(z-arr[0]<=0){  // shayam is defeated.
                count++;
                break;
            }
            else{
                z-= arr[0];
                count++;
                arr[0] = arr[0]/2; // this change done just only int logn time but in useing of priority queue it will take 2*logn
                downHipify(arr, 0, arr.length);
            }
        } 
        System.out.println(count);   
    } 
}
    