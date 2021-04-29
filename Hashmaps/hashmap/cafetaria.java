import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.Iterator;
public class cafetaria {
	public static void main(String[] args) {
		// my tree map created using BST.
		TreeMap map = new TreeMap();
		map.insert("arti",20);
		System.out.println(map.getValue("arti"));
		map.insert("arti",50);
		System.out.println(map.getValue("arti")+" "+map.size());
		map.insert("art",20);
		map.insert("ar",50);
		map.insert("a",20);
		map.insert("artisg",50);
		map.delete("arti");
		System.out.println(map.getValue("arti")+" "+map.size());
		// built in hash map
		HashMap<String,Integer>  hashmap = new HashMap<String,Integer>(50,.3f);
		hashmap.put("a", 20);
		hashmap.put("a", 50);
		hashmap.putIfAbsent("a", 20);
		hashmap.putIfAbsent("b", 20);
		hashmap.putIfAbsent("c", 20);
		hashmap.putIfAbsent("d", 20);
		hashmap.putIfAbsent("e", 20);
		System.out.println(hashmap.entrySet());
		Set<String> set = hashmap.keySet();
		Iterator<String> i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}

		for(String a:set){
			System.out.println(a);
		}

		System.out.println(hashmap.values());
		hashmap.forEach((k,v)-> System.out.println(k+" "+v));
		String amit = "amit";
		System.out.println(('a'+'m'+'i'+'t')/0);

	}
}