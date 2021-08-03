class mat{
	int [][] matrix;
	
	mat(int [][] mat)
	{
		matrix=mat;
	}
		
	
	    static mat add(mat a,mat b)
	    {
            int rows = a.matrix.length;
            int columns = a.matrix[0].length;
            int[][] cmat = new int[rows][columns];
            mat c = new mat(cmat);
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    c.matrix[i][j] = a.matrix[i][j]+b.matrix[i][j];
                }
            }return c;
	    }
	    public static mat multiply(mat a,mat b)
	    {
	    	int l = a.matrix.length;
            int m = a.matrix[0].length;
            int n = b.matrix[0].length;
            System.out.println(l+" "+m+" "+n);
            int[][] cmat = new int[l][n];
            mat c = new mat(cmat);
            for(int i=0;i<l;i++){
                for(int j=0;j<n;j++){
                	int sum = 0;
                	for(int k=0;k<m;k++){
                		sum+= a.matrix[i][k]*b.matrix[k][j];
                	}
                	c.matrix[i][j] = sum;
                }
            }return c;
	       
	    }
	    public static mat transpose(mat a)
	    {
	    	int rows = a.matrix.length;
            int columns = a.matrix[0].length;
            int[][] cmat = new int[columns][rows];
            mat c = new mat(cmat);
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    c.matrix[j][i] = a.matrix[i][j];
                }
            }return c;
	    	
	    }
	    public static mat rotate(mat a)
	    {
	    	int rows = a.matrix.length;
            int columns = a.matrix[0].length;
            int[][] cmat = new int[columns][rows];
            mat c = new mat(cmat);
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    c.matrix[j][i] = a.matrix[i][j];
                }
            }
            int temp;
            for(int i=0;i<rows;i++){
                for(int j=0;j<(columns/2);j++){
                    temp = c.matrix[columns-j-1][i];
                    c.matrix[columns-j-1][i] = c.matrix[j][i];
                    c.matrix[j][i] = temp;
                }
            }

            return c;		
	    }
	   void print()
	    {
	        for(int i=0;i<matrix.length;i++)
	        {
	            for(int j=0;j<matrix[0].length;j++)
	            {
	                System.out.print(matrix[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
	 }
public class matrixClass{
	public static void main(String[] args) {
		int[][] amat ={{1,2},{2,3},{2,3}};
		int[][] bmat ={{1,2,3},{2,3,3}};
		mat a = new mat(amat);
		mat b = new mat(bmat);
		// a.print();
		// b.print();
		mat c = mat.rotate(a);
		c.print();

	}
}