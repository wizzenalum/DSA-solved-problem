/*############################################################################
			implementation of hash mape with seprate chaining
		here i will implements the hashmap which use String keys and hash fuction based on number base 'p' 
		and for collision handling i will gonna use seprate chainging that also called 
		closed hashing.

#############################################################################*/
// node where  data of map will be stored
import java.util.ArrayList;// used to quickly access the nodes.

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

class HashMap<K,V>{
	private ArrayList<MapNode<K,V>> buckets;
	private int bucketSize;
	private int mapSize;
	private double loadFactor;
	// load factor is ratio of p/n where n = bucketSize and p = map size. probabilistcally 
	// to make sure length of list stored in bucket is approx 1 load factor should less then .7;

	public HashMap(){
		this(20,.7);
	}
	public HashMap(int bucketSize){
		this(bucketSize, .7);
	}
	public HashMap(int bucketSize, double loadFactor){
		this.bucketSize = bucketSize;
		this.loadFactor = loadFactor;
		this.mapSize = 0;
		this.buckets = new ArrayList<>(this.bucketSize);
		for(int i = 0; i<this.bucketSize;i++){
			this.buckets.add(null);
		}

	}

	public int HashFunction(K key){
		//it will return integer by creating hashcode and then compressing it.
		int hashCode = key.hashCode();
		return hashCode%this.bucketSize; // compression.
	}
	public void insert(K key, V value){
		//this fucntion will insert the values
		int index = HashFunction(key);
		MapNode<K,V> node = new MapNode<K,V>(key,value);

		//if bucket is empty.
		if(this.buckets.get(index)==null) buckets.set(index,node);
		else{ // bucket not empty.
			// if key is already present in the map;
			MapNode<K,V> temp = this.buckets.get(index);
			while(temp!=null){
				if(temp.key.equals(key)){
					temp.value = value;
					return;
				}
				temp = temp.next;
			}
			
			// if key not present in the list
			node.next = buckets.get(index);
			buckets.set(index,node);

		}
		this.mapSize++;
		if((double)this.mapSize/(double)this.bucketSize>this.loadFactor) rehash();
	}
// remove node from the map.  
	public boolean remove(K key){
		int index = HashFunction(key);
		if(this.buckets.get(index)!=null){
			MapNode<K,V> temp = this.buckets.get(index);
			MapNode<K,V> prev = null;
			while(temp!=null){
				if(temp.key.equals(key)){
					if(prev==null) this.buckets.set(index,null);
					else{
						prev.next = temp.next;
						temp.next = null;
					}
					mapSize--;
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}

// get value from the map;
	public V getValue(K key){
		int index = HashFunction(key);
		if(this.buckets.get(index)!=null){
			MapNode<K,V> temp = this.buckets.get(index);
			while(temp!=null){
				if(temp.key.equals(key)){
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	// return the number of the node in the map.
	public int size(){
		return this.mapSize;
	}

	// rehash the map as the the load factor become higher to the the given load factor.
	public void rehash(){
		ArrayList<MapNode<K,V>> tempBucket = this.buckets; // here multipling  factor 2;

		this.buckets = new ArrayList<>(this.bucketSize*2);
		this.bucketSize = this.bucketSize*2;
		for(int i = 0; i<this.bucketSize;i++){
			this.buckets.add(null);
		}
		mapSize= 0;
		for(int i = 0; i<this.bucketSize/2;i++){
			MapNode<K,V> temp = tempBucket.get(i);
			while(temp!=null){
				insert(temp.key, temp.value);
				temp = temp.next;	
			}

		}

	}

	void data(){
		System.out.println("loadFactor = "+loadFactor+"  mapSize = "+mapSize+" bucketSize = "+bucketSize);
	}

	void print(){
		// print the map
		for(int i = 0; i<bucketSize;i++){
			if(buckets.get(i)!=null){
				System.out.print(i+" ");
				MapNode<K,V> node = buckets.get(i);
				while(node!=null){
					if(node.next==null) System.out.print("["+node.key+"->"+node.value+"]");
					else System.out.print("["+node.key+"->"+node.value+"]   --->>  ");
					node = node.next;
				}
				System.out.println();

			}
		}
	}


}

// i will check the class.
public class HashMapClosedWithOverload{
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		// arr.add(30,30); // not possible so i have to initialize arraylist first.
		// System.out.println(arr.get(30));
		HashMap<Integer,Character> map = new HashMap<Integer,Character>(10,.5);
		map.insert(1,'a');
		map.insert(21,'a');
		map.insert(23,'b');
		map.insert(61,'c');
		map.insert(1,'d');
		map.data();
		map.insert(253,'e'); 
		map.insert(233,'f');
		map.data();
		map.insert(61343,'u');
		System.out.println();
		map.print();
		map.insert(14,'z');
		System.out.println();
		map.print();
		// System.out.println(map.remove(253));
		// map.insert(253,'e');
		// System.out.println("size =  "+map.size());
		// System.out.println(map.remove(253));
		// System.out.println(map.getValue(14));
		// System.out.println(map.getValue(21));
		// System.out.println(map.getValue(61));
		// System.out.println("size =  "+map.size());
	
		// Integer k = 1;
		// for(Integer i =0; i<1000;i++){
		// 	System.out.println(i.hashCode());
		// 	if(k.hashCode()== i.hashCode()) System.out.println(i);
		// }
	}
}

