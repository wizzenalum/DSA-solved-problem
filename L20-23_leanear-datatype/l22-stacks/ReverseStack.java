import java.util.Stack;
public class ReverseStack{
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		int size= input.size();
		for(int i =size;i>1;i--){
			int temp  = input.pop();
			for(int j =1;j<i;j++){
				extra.push(input.pop());								
			}
			input.push(temp);
			for(int j =1;j<i;j++){
				input.push(extra.pop());								
			}
		}
	}
	public static void reverseStack1(Stack<Integer> input, Stack<Integer> extra) {
		// System.out.println(input.empty()+" hi");
		if(input.empty())return;
		while(!input.isEmpty()){
			extra.push(input.pop());
		}
		int temp = extra.pop();
		while(!extra.empty()){
			input.push(extra.pop());
		}
		reverseStack1(input,extra);
		input.push(temp);
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Stack<Integer> e = new Stack<>();
		int[] arr = {1,2,3,4,6};
		for(int i=0;i<arr.length;i++){
			s.push(arr[i]);
		}
		System.out.println(s.size());
		// for(int i=0;i<arr.length;i++){
		// 	System.out.println(s.pop());
		// }
		reverseStack1(s,e); 
		System.out.println("afrter ");
		for(int i=0;i<arr.length;i++){
			System.out.println(s.pop());
		}
	}
}