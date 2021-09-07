def count_cycle(mat):
    count = 0
    for i in range(len(mat)):
        for j in range(i+1,len(mat)):
            if(mat[i][j]==1):
                for k in range(j+1,len(mat)):
                    if mat[j][k] == 1 and mat[k][i]==1:
                        count += 1
    return count






n,m = [int(i) for i in input().strip().split(" ")]
matrix = [[0]*n for i in range(n)]
for randomsi in range(m):
    r,c = [int(i) for i in input().strip().split(" ")]
    matrix[r][c],matrix[c][r] = 1,1

# print(n,m,matrix)
print(count_cycle(matrix))

