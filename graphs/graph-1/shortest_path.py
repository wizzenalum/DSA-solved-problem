# find the shortest path if you are at "s" and reach to "e" where you can 
# move only up,down,left right and 0 are osticles
from collections import deque
direction = [[0,1],[1,0],[0,-1],[-1,0]]

def shortest_path(graph,que,visited):
    row,col,pr,pc = que.popleft()  
    if(graph[row][col]=="e"): return [[pr,pc],[row,col]]
    for i in direction:
        r = i[0]+row
        c = i[1]+col
        if(r>=0 and c>=0 and r <len(graph) and c<len(graph[0]) and graph[r][c]!=0):
            if not visited[r][c]:
                que.append([r,c,row,col])
                visited[r][c] = True
    path = shortest_path(graph,que,visited)
    if(path and path[0][0]==row and path[0][1]==col):
        path[0][0], path[0][1] = pr,pc
        path.append([row,col])
    return path
    
graph  = [    
        ["s",1,1,0,1,1,1],
        [1,0,1,1,1,0,1],
        [1,0,1,1,1,1,1],
        [1,1,0,0,1,1,1],
        [0,1,0,"e",1,0,1],
            ]
sr, sc = 0,0
visited = [[False]*len(graph[0]) for i in range(len(graph))]
visited[sr][sc] = True
que = deque()
que.append([sr,sc,-1,-1])
print(shortest_path(graph,que,visited))
