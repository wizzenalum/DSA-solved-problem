import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
public class Cafetaria{
/*############################################################################
		question related
	1. removeRange is protected so we cant use it then why they listed it inside methods for users?
	2. what is the use of clone method if we can't apply any method on it?

#############################################################################*/
	public static void main(String[] args){
		//searching, sorting, insertion, manipulation, and deletion.
	// ***********ArrayList*************
		//creation of array list
		ArrayList<String> sarr = new ArrayList<>();//current capacity is 10
		ArrayList<Integer> narr = new ArrayList<>(50); // current capacity is 50
		// insertion 
		System.out.println("add   "+sarr.add("first"));  // append at the last
		sarr.add(0,"zeroth"); // add at the index
		System.out.println(sarr.addAll(sarr)); //append the collection(ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet)
		System.out.println(sarr.addAll(1,sarr));//add the collection from index 1
		// int[] arr = {3,4,5,6,6}; 
		// narr.addAll(arr);//error: incompatible types: int[] cannot be converted to Collection<? extends Integer>
		narr.add(4);
		System.out.println("********************************************************************");
		//manipulation
		sarr.set(2,"second");
		sarr.ensureCapacity(30);//check that arr size is minimum as this.
		System.out.println(sarr.get(3));//get 3rd element.
		System.out.println("indexof  "+sarr.indexOf("first"));
		System.out.println(sarr.lastIndexOf("first"));
		System.out.println("isempty  "+narr.isEmpty());
		System.out.println(sarr.contains("third"));
		System.out.println("size  "+sarr.size());
		System.out.println(Arrays.toString(sarr.toArray())); // convert to array.
		System.out.println("********************************************************************");

		sarr.forEach(n -> sarr.set(sarr.indexOf(n),n+"45")); // here i add 45 to all the elements.
		sarr.forEach(n -> System.out.println(n));
		// remove
		System.out.println(sarr.remove(0));// remove 0th index return element.
		System.out.println(sarr.remove("zeroth")); // remove first occureance return true or false.
		System.out.println(sarr.removeIf(n -> n.charAt(0)=='s'));
		// sarr.removeRange(0,1);// remove 0th element protected
		System.out.println("********************************************************************");

		Iterator i = sarr.iterator();
      	while(i.hasNext()) {
	        Object obj = i.next();
	        System.out.print(obj + " ");
        }
        System.out.println();
		//deletion
		Object s2arr = sarr.clone();// clone this instance to Obejct arraylist. but no operation will apply.
		// System.out.print(s2arr.get(1));//no symbol found
		System.out.println(s2arr.getClass().getName());
		System.out.println((sarr.subList(0,sarr.size())));//create a list of 0to7 elements.
		List<String> a = sarr.subList(0,3);
		sarr.clear();
		System.out.println((sarr.subList(0,sarr.size())));//create a list of 0to7 elements.
		

	}
}