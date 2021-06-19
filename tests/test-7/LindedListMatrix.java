class Node{
    int data;
    Node right,down;
    Node(int data){
        this.data=data;
        right=null;
        down=null;
    }
}
public class LindedListMatrix {


    // using n*n space complexity
    public static Node construct1(int mat[][],int n) {
        Node[][] nodeMat = new Node[n][n];
        for (int i = 0; i < nodeMat.length; i++) {
            for (int j = 0; j < nodeMat.length; j++) {
                nodeMat[i][j] = new Node(mat[i][j]);

                // making links to up node and left node
                if(j!=0){
                    nodeMat[i][j-1].right = nodeMat[i][j];
                }
                if(i!=0){
                    nodeMat[i-1][j].down = nodeMat[i][j];
                }
            }
        }
        return nodeMat[0][0];
        
    }
// here using n space complexity.
    static Node construct(int arr[][],int n){
        Node[] pre = new Node[n];
        Node head =null, temp = null;
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                temp = new Node(arr[i][j]);
                if(i==0){
                    if(j==0) head = temp;
                    pre[j] = temp;
                    if(j!=0) pre[j-1].right = temp;
                }else{
                    pre[j].down = temp;
                    pre[j] = temp;
                    if(j!=0) pre[j-1].right = temp;
                }
            }
        }
        return head; 
    }

    // here we will got space complexity of O(1)
    static Node construct2(int arr[][],int n){
        Node head =null, up = null, left = null, nextUpNode = null, current = null;
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n;j++){
                current = new Node(arr[i][j]);
                if(i==0&&j==0){
                    head = current;
                }
                if(left==null) {
                    nextUpNode = current;
                }else{
                    left.right = current;
                }
                left = current;
                if(up!=null){
                    up.down = current;
                    up = up.right;
                }
            }
            up = nextUpNode;
            left = null;
        }
        return head; 
    }
    // to print the matrix
    static void printMat(Node head){
        Node nextRow = head;
        while(nextRow!=null){
            head = nextRow;
            while(head!=null){
                System.out.print(head.data+" ");
                head = head.right;
            }
            System.out.println();
            nextRow = nextRow.down;
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        construct(mat, mat.length);
        printMat(construct2(mat, mat.length));
        // this problem has multiple ways to approach

    }
}
