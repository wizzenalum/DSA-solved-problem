from collections import deque
class HasPath:
    def has_path(self,edges,v1,v2,bfs=False):
        index = v1
        visited = [False]*len(edges)
        path = False
        if(bfs):
            que = deque()
            que.appendleft(index)
            visited[index] = True
            if index == v2 : return True
            while que:
                index = que.pop()
                adjcents = edges[index]
                for adjcent in adjcents:
                    if not visited[adjcent]:
                        if(adjcent==v2): return True
                        visited[adjcent] = True
                        que.appendleft(adjcent)


        else:
            def dfs(index):
                if index>=len(edges): return False

                visited[index]=True
                # print(index,visited)
                if(index==v2): return True
                adjcents = edges[index]
                for adjcent in adjcents:
                    if not visited[adjcent]:
                        # print(visited[adjcent])
                        if(dfs(adjcent)): return True
                return False
            path = dfs(index)
        return path
                    




obj = HasPath()
vertices = [0,1,2,3,4,5,6,7,8]
edges = [
            [6],
            [2,5,4],
            [1,3,4],
            [2,7,8],
            [1,2,8],
            [1,7],
            [0],
            [3,5,8],
            [3,4,7],
        ]
print(obj.has_path(edges,1,2,True))
print(obj.has_path(edges,1,2))