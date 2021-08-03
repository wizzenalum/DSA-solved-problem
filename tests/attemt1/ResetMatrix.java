package attemt1;

public class ResetMatrix {

    // public static void push(int[] arr, int k) {
    //     check = true;
    //     for()
    // }

    public static void makeRowsCols0(int [][]input) {
		int[] row = new int[input.length];
        int[] col = new int[input[0].length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if(input[i][j]==0){
                    row[i]++;
                    col[j]++; 
                }
            }
        }
        for (int i = 0; i <row.length; i++) {
            if(row[i]>0){
                for (int j = 0; j < col.length; j++) {
                    input[i][j] = 0;
                }
            }
        }
        for (int i = 0; i <col.length; i++) {
            if(col[i]>0){
                for (int j = 0; j < row.length; j++) {
                    input[j][i] = 0;
                }
            }
        }
	}
    public static void main(String[] args) {
        
    }
}
