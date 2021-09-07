"""" graph has no negative cycles means not has any -ve weitage and source is known"""
import heapq as hq
# method 1 lazy dijkstras algo

def create_priority_queue(list,action="p"):
    def push(value):
        hq.heappush(list,value)
    def pop(value):
        return hq.heappop(list,value)
    if(action =="push"):
        return push
    return pop

def dijkstras(graph,source):
    que = []
    pop = create_priority_queue(que)
    push = create_priority_queue(que,"push")
    push([0,source])
    weight_to_reach = [None]*len(graph)
    weight_to_reach[0] = [source,0]
    # visited = [False]*len(graph)

    while que:
        current = pop()
        adjacents = graph[current[0]]
        for adj in adjacents:
            vertex = adj[0]
            weig = adj[1]
            if(weight_to_reach[vertex] and weight_to_reach[vertex]>weig+current[1]):
                pass
                






graph = [
    [1,5],                  #0
    [[0,5],[2,2],[3,1]],    #1
    [[1,2],[3,2],[5,3]],    #2
    [[1,1],[2,2],[4,1]],    #3
    [[3,1],[5,2],[6,3]],    #4
    [[2,3],[4,2],[6,2]],    #5
    [[5,2],[4,3]]]            #6

