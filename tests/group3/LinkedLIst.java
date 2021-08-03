package group3;
import java.io.*;
import java.util.*;
class Node{
    int data;
    Node right,down;
    Node(int data){
        this.data=data;
        right=null;
        down=null;
    }
}
/*  Linked List Matrix
Send Feedback
Given a Matrix mat of N*N size, write a program that constructs a 2D linked list representation of the given matrix.
Input : 2D matrix

1 2 3
4 5 6
7 8 9

Output :

1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL

Input Format :

 The first line takes an integer N as input.
 The next line input n*n integers denoting the matrix.

Output format:

Print the matrix using the linked list header.

Sample Input:

3
1 2 3 4 5 6 7 8 9

Sample Output:

1 2 3
4 5 6
7 8 9

 */
public class LinkedLIst {
static Node construct(int arr[][],int n){
        if(n<=0) return null; 

        Node[][] mat = new Node[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = new Node(arr[i][j]);
                
                if(i!=0) mat[i-1][j].down = mat[i][j];
                if(j!=0) mat[i][j-1].right = mat[i][j];
            } 
        }

        return mat[0][0];
       
    }
    static void display(Node head)
    {
        Node rp;
        Node dp=head;
        while(dp!=null){
            rp=dp;
            while(rp!=null){
                System.out.print(rp.data+" ");
                rp=rp.right;
            }
            dp=dp.down;
            System.out.println();
        }
        
    }
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int [][]arr=new int[n][n];
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<n;j++)
		    arr[i][j]=s.nextInt();
		}
		Node head=construct(arr,n);
		display(head);
	}
}
