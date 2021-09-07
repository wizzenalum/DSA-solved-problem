direction = [[0,1],[1,0],[0,-1],[-1,0]]
def count_ones(graph,visited,row,col):
    # print(row,col,graph,visited)
    if row<0 or col<0 or row>=len(graph) or col>=len(graph[0]): return 0
    if visited[row][col] or graph[row][col]==0: return 0
    visited[row][col] = True
    count = 0
    for dir in direction:
        r = row+dir[0]
        c = col+dir[1]
        count = count+count_ones(graph,visited,r,c)
    return count+1

    


def largest_piece(graph):
    max = -1
    temp = 0
    visited = [[False]*len(graph[0]) for i in range(len(graph))]
    for row in range(len(graph)):
        for col in range(len(graph[0])):
            if(graph[row][col]==1 and (not visited[row][col])):
                temp = count_ones(graph,visited,row,col)
                if temp>max: max = temp

    return max

#@main
n = int(input())
graph = [[int(i) for i in input().strip().split(" ")] for i in range(n)]
# print(graph)
print(largest_piece(graph))

