import java.util.ArrayList;
/*############################################################################
			implementation of hash mape with seprate chaining
		here i will implements the hashmap which use String keys and hash fuction based on number base 'p' 
		and for collision handling i will gonna use seprate chainging that also called 
		closed hashing.

#############################################################################*/

// class KeyNotFound extends Exception{
	// this handle the key not found key not found
// }
class List{
	String key;
	int value;
	List next;
	List(String key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
// this class is just for string key and integer values 
class HashMap{
	private List[] bucketArray;
	private int size;
	private int bucket;
	HashMap(){
		this(100);
	}
	HashMap(int bucket){
		this.bucketArray = new List[bucket];
		this.size = 0;
		this.bucket = bucket;
	}

	private static int hashFunction(String key, int bucket){
		// hash code for "abc" is a*p^0+b*p^1+c*p^2. and compression hash code%bucket;
		// but here i will do both simultaniously.
		int hash = 0;
		int base = 1;
		for(int i = 0; i<key.length();i++){
			hash +=key.charAt(i)*base;
			base *=3; // this is the base p which should always prime.
			hash = hash%bucket; // compression is runnig too. 
		}
		return hash;
	}
	public int hashCode(String key){
		return hashFunction(key,this.bucket);
	}

	public void insert(String key, int value){
		int index = hashFunction(key,this.bucket);
		List node = new List(key, value);
		if(this.bucketArray[index]==null){
			this.bucketArray[index] = node;
		}else{
			List temp = this.bucketArray[index];
			if(temp.key.equals(key)){
				temp.value = value;
				return;
			}
			while(temp.next!=null){
				if(temp.next.key.equals(key)){
					temp.next.value = value;
					return;
				}
				temp = temp.next;
			} 
			temp.next = node;
		}
		size++;
		
	}
	public int get(String key){
		// use error handling class for key not found.
		int index = hashFunction(key,this.bucket);
		Integer value = null;
		if(this.bucketArray[index]!=null){
			List temp = this.bucketArray[index];
			while(temp!=null&&value==null){
				if(temp.key.equals(key)) value = temp.value;
				temp = temp.next;
			}
		}
		if(value == null){
			// throw the eroor of key not found
		}	
		return value;
	}


	public boolean remove(String key){
		int index = hashFunction(key,this.bucket);
		boolean check = false;
		
		if(this.bucketArray[index]!=null){ // when key is first of the list;
			if(this.bucketArray[index].key.equals(key)){
				this.bucketArray[index] =  this.bucketArray[index].next;
				check = true;
			}else{	// when key is other then first node in list.
				List temp = this.bucketArray[index];
				while(temp.next!=null){
					if(temp.next.key.equals(key)){
						check = true;
						temp.next = temp.next.next;
						break;
					}
				}
			}
		}
		if(check) size--;
		return check;		
	}
	
	public int size(){
		return size;
	}
	void print(){
		for(List ele:this.bucketArray){
			if(ele!=null) System.out.println();
			while(ele!=null){
				System.out.print(ele.key+" -->  ["+ele.value+"]    ");
				ele = ele.next;
			}
		}
	}
}

// this class is generic one.
class MapNode<K,V>{
	K key;
	V value;
	MapNode<K,V> next;
	MapNode(K key, V value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
class HashMapGen<K,V>{
	private ArrayList<MapNode<K,V>> bucketArray;
	private int size;
	private int bucket;

	// constructor.
	HashMapGen(){
		this(100);
	}
	HashMapGen(int bucket){
		this.bucketArray = new ArrayList<MapNode<K,V>>(bucket);
		this.size = 0;
		this.bucket = bucket;
		for(int i = 0; i<bucket;i++){
			this.bucketArray.add(null);
		}
	}

	private static int hashFunction(String key, int bucket){
		// hash code for "abc" is a*p^0+b*p^1+c*p^2. and compression hash code%bucket;
		// but here i will do both simultaniously.
		int hash = 0;
		int base = 1;
		for(int i = 0; i<key.length();i++){
			hash +=key.charAt(i)*base;
			base *=3; // this is the base p which should always prime.
			hash = hash%bucket; // compression is runnig too. 
		}
		return hash;
	}
	private static int hashFunction(int key, int bucket){
		// as here key is integer so hash will be the key%bucket;
		int hash = key%bucket;
		return hash;
	}


	public int hashCode(K key){
		String k = ""+key;// this solve the problem of passing type of parameter but now my hash fuction always be string

		return hashFunction(k,this.bucket);
	}
// how to decide the parameters for the hash fuction becasue 
	public void insert(K key, V value){
		String k = ""+key;// this solve the problem of passing type of parameter but now my hash fuction always be string
		// even i made a seprate hash fucntion for integers.
		int index = hashFunction(k,this.bucket);
		
		MapNode<K,V> node = new MapNode<K,V>(key, value);
		if(this.bucketArray.get(index)==null){
			this.bucketArray.add(index,node);
		}else{
			MapNode<K,V> temp = this.bucketArray.get(index);
			if(temp.key.equals(key)){
					temp.value = value;
					return;
				}
			while(temp.next!=null){
				if(temp.next.key.equals(key)){
					temp.next.value = value;
					return;
				}
				temp = temp.next;	
			} 
			temp.next = node;
		}
		size++;
	}
	public V get(K key){
		// use error handling class for key not found.
		String k = ""+key;
		int index = hashFunction(k,this.bucket);
		V value = null;
		if(this.bucketArray.get(index)!=null){
			MapNode<K,V> temp = this.bucketArray.get(index);
			while(temp!=null&&value==null){
				if(temp.key.equals(key)) value = temp.value;
				temp = temp.next;
			}
		}
		if(value == null){
			// throw the eroor of key not found
		}	
		return value;
	}


	public boolean remove(K key){
		String k = ""+key;
		int index = hashFunction(k,this.bucket);
		
		boolean check = false;
		
		if(this.bucketArray.get(index)!=null){ // when key is first of the list;
			if(this.bucketArray.get(index).key.equals(key)){
				this.bucketArray.set(index, this.bucketArray.get(index).next);
				check = true;
			}else{	// when key is other then first node in list.
				MapNode<K,V> temp = this.bucketArray.get(index);
				while(temp.next!=null){
					if(temp.next.key.equals(key)){
						check = true;
						temp.next = temp.next.next;
						break;
					}
					temp = temp.next;
				}
			}
		}
		if(check) size--;
		return check;		
	}
	public int size(){
		return size;
	}
	void print(){
		for(MapNode<K,V> ele:this.bucketArray){
			if(ele!=null) System.out.println();
			while(ele!=null){
				System.out.print(ele.key+" -->  ["+ele.value+"]    ");
				ele = ele.next;
			}
		}
	}
}
public class HashMapClosed{
	public static void main(String[] args) {
	// first HashMap class.	
		// HashMap mapp = new HashMap();
		// mapp.insert("a", 8);
		// mapp.insert("abc", 3);
		// mapp.insert("ad", 1);
		// mapp.insert("ab", 4);
		// System.out.println(mapp.get("a"));
		// System.out.println(mapp.get("ad"));
		// System.out.println(mapp.remove("a"));
		// mapp.print();
		// System.out.println();
		// System.out.println();
		// System.out.println();
	// generic class;
		MapNode<Integer,Integer> node = new MapNode<Integer,Integer>(2,3);
		// System.out.println(node.key+" "+node.value);
		HashMapGen<Integer,String> map = new HashMapGen<>(30);
		map.insert(1,"b");
		map.insert(12,"gagb");
		map.insert(4,"bgf");
		map.insert(13,"bga");
		map.insert(42,"agb");
		map.insert(42,"bbbbbbbb");
		map.insert(71,"bga");
		map.insert(7,"agagab");
		map.insert(14,"gagb");
		// for(int i = 0;i<100;i++){
		// 	if(map.hashCode(4)==map.hashCode(i)) System.out.println("code for "+i+" "+map.hashCode(i));

		// }
		System.out.println("size 1   "+map.size());
		map.print();
		System.out.println(map.get(1));
		System.out.println(map.get(13));
		System.out.println(map.get(71));
		System.out.println(map.get(4344));

		System.out.println(map.remove(4));

		System.out.println(map.remove(13));
		System.out.println(map.remove(71));
		System.out.println(map.remove(4344));
		map.print();


// (4,13,42,71) 7,14, 12,1


	}
}