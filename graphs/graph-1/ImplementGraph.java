/*############################################################################
						here i am going to implement tree way of graphs.
		user will enter vertices and then adjacent vertices or edges to create graph.

			1. edge list.
			2. adjacency list.
			3. adjacency matrix.
						
						completed true.

#############################################################################*/
import java.util.ArrayList;
import java.util.HashMap;
class GraphEL<V>{
	private class Edge<V>{
		V first;
		V second;
		Edge(V first, V second){
			this. first = first;
			this.second = second;
		}
	}

	private ArrayList<V> vertices;
	private ArrayList<Edge<V>> edges;
	int vSize = 0;
	int eSize = 0;

	GraphEL(){
		this.vertices = new ArrayList<>();
		this.edges = new ArrayList<>();
	}
	
	public void addVertex(V vertex){
		this.vertices.add(vertex);
		this.vSize++;
	} 
	public void addEdge(V vertex1, V vertex2){
		this.edges.add(new Edge<V>(vertex1,vertex2));
		this.eSize++;
	} 
	public void print(){
		System.out.print("vertices are    ");
		System.out.println(this.vertices.subList(0,vSize));
		System.out.print("edges are   ");
		System.out.print("[");
		for(int i = 0; i<this.eSize;i++){
			System.out.print("("+ this.edges.get(i).first+","+this.edges.get(i).second +"),");
		}
		System.out.println("]");

	}
}

class GraphAL<V>{
	private class AdjacencyList<V>{
		V vertex;
		ArrayList<V> adjacent;
		AdjacencyList(V vertex){
			this. vertex = vertex;
			this.adjacent = new ArrayList<>();
		}
	}

	private HashMap<V,AdjacencyList<V>> graph;
	int vSize = 0;

	GraphAL(){
		this.graph = new HashMap<>();
	}
	
	public void addVertex(V vertex){
		if(!graph.containsKey(vertex)){
			vSize++;
			graph.put(vertex,new AdjacencyList<V>(vertex));
		}
	} 
	public void addEdge(V vertex1, V vertex2){
		if(!graph.containsKey(vertex1) && !graph.containsKey(vertex2)){
			graph.put(vertex1,new AdjacencyList<V>(vertex1));
			graph.put(vertex2,new AdjacencyList<V>(vertex2));
			vSize+=2;
		}
		if(!graph.containsKey(vertex1)) {
			graph.put(vertex1,new AdjacencyList<V>(vertex1));
			vSize++;
		}
		if(!graph.containsKey(vertex1)) {
			graph.put(vertex2,new AdjacencyList<V>(vertex2));
			vSize++;
		}
		graph.get(vertex1).adjacent.add(vertex2);
		graph.get(vertex2).adjacent.add(vertex1);
	} 
	public void print(){
		for(V key:graph.keySet()){
			System.out.print(key+" :--");
			graph.get(key).adjacent.forEach((n) -> System.out.print(n+","));
			System.out.println();
		}

	}
}

class GraphAM<V>{
	// this wont store two directional edges i will only store smaller to bigger edges
	HashMap<V,HashMap<V,Boolean>> graphMatrix;
	int vSize;
	int eSize;

	GraphAM(){
		this.graphMatrix = new HashMap<>();
		this.vSize = 0;
		this.eSize = 0;
	}
	void addVertex(V vertex){
		if(!this.graphMatrix.containsKey(vertex)){
			HashMap<V,Boolean> list = new HashMap<>();
			this.graphMatrix.put(vertex,list);
			vSize++;
		}
	}
	void addEdge(V vertex1, V vertex2){
		if(vertex2.hashCode()<vertex1.hashCode()){
			V swap = vertex1;
			vertex1 = vertex2;
			vertex2 = swap;
		}
		if(!this.graphMatrix.containsKey(vertex1)){
			HashMap<V,Boolean> list = new HashMap<>();
			this.graphMatrix.put(vertex1,list);
		}
		if(this.graphMatrix.get(vertex1).containsKey(vertex2)){
			return;
		}
		this.graphMatrix.get(vertex1).put(vertex2,true);
		eSize++;
	}

	void print(){
		for(V vertex:this.graphMatrix.keySet()){
			System.out.print(vertex+" :--  ");
			HashMap<V,Boolean> edgeMap = this.graphMatrix.get(vertex);
			for(V edge: edgeMap.keySet()){
				System.out.print(edge+", ");
			}
			System.out.println();
		}
	}
}
public class ImplementGraph{
	public static void main(String[] args) {
		// create graph by edge list
		// int n = scan.nextInt();
		// int E = scan.nextInt();
		// GraphEL<String> graph = new GraphEL<>();
		// graph.addVertex("1");
		// graph.addVertex("2");
		// graph.addVertex("3");
		// graph.addEdge("1","2");
		// graph.print();
		// GraphAL<String> graph1 = new GraphAL<>();
		// graph1.addVertex("1");
		// graph1.addVertex("2");
		// graph1.addVertex("3");
		// graph1.addEdge("1","2");
		// graph1.print();
		GraphAM<String> graph2 = new GraphAM<>();
		graph2.addVertex("1");
		graph2.addVertex("2");
		graph2.addVertex("3");
		graph2.addEdge("1","2");
		graph2.print();
	}
	
}