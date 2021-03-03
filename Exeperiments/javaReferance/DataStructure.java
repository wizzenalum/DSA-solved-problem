public class DataStructure{
	private final static int SIZE = 15;
	private int [] arr = new int[SIZE];
	//constructor
	DataStructure(){
		for(int i =0;i<SIZE;i++){
				this.arr[i] = i;
		}
	}
	void printEven(){
		DataStructureInterator iter = new DataStructureInterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	class DataStructureInterator{
		private int nextIndex = 0;
		boolean hasNext(){
			return nextIndex<SIZE;
		}
		Integer next(){
			Integer retValue = Integer.valueOf(arr[nextIndex]);
			this.nextIndex+=2;
			return retValue;
		} 
	}
	public static void main(String[] args){
		DataStructure ds = new DataStructure();
		ds.printEven();
	}


}