""""
    Given an m x n matrix, return all elements of the matrix in spiral order.
    Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]
"""

from typing import List



class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # this is bruitforce method for the solution
        m,n = len(matrix),len(matrix[0])
        top,right,bottom,left = 0,n-1,m-1,0
        row, col = 0, 0
        switch = 0
        result = [0]*(n*m)
        for k in range(n*m):
            result[k] = matrix[row][col]
            if (switch ==3 or switch == 0) and top==row and col<right:
                col+=1
                if switch!=0:
                    switch = 0
                    left+=1
            elif (switch ==0 or switch == 1) and right==col and row<bottom:
                row+=1
                if switch!=1:
                    switch = 1
                    top+=1
            elif (switch ==1 or switch == 2) and bottom==row and col>left:
                col-=1
                if switch!=2:
                    right-=1
                    switch = 2
            elif (switch ==2 or switch == 3) and col == left and row>top:
                row-=1
                if switch!=3:
                    bottom-=1
                    switch = 3
        print(result)
        return result
s = Solution()
mat = [[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5],[1,2,3,4,5]]
s.spiralOrder(mat)
