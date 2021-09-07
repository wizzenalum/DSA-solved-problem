def visit_connected_islands(graph,visited,index):
    if index>= len(graph): return
    visited[index] = True
    connected_islands = graph[index]
    for island in connected_islands:
        if not visited[island]:
            visit_connected_islands(graph,visited,island)
        


def count_islands(graph):
    if len(graph)<0: return 0
    if len(graph)<2: return len(graph)
    visited =[False]*len(graph)
    count = 0
    for i in range(len(graph)):
        if not visited[i]:
            count +=1
            visit_connected_islands(graph,visited,i)
    return count
    




vertices,edges = [int(i) for i in input().split()]
print(vertices,edges)
graph = [[] for i in range(vertices)]
for i in range(edges):
    v1 ,v2 = [int(i) for i in input().split()]

    graph[v1].append(v2)
    graph[v2].append(v1) 

print(graph)
print(count_islands(graph))

