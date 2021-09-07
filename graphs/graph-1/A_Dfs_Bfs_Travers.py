from typing import List
from collections import deque


class A_DfsBfsTravers:
    def dfs(self,edges:List[List]):
        """ 
            
        """
        visited = [False]*(len(edges))
        def dfs_recursion(index):
            if index>=len(visited):return
            adjcents = edges[index]
            print(index)
            visited[index] = True
            for adjcent in adjcents:
                if not visited[adjcent]:
                    dfs_recursion(adjcent)
        dfs_recursion(1)
    def bfs(self,edges:List[List]):
        que = deque()
        visited = [False]*len(edges)
        index = 1
        que.appendleft(index)
        visited[index] = True
        print(index)
        while que:
            index = que.pop()
            adjcents = edges[index]
            for adjcent in adjcents:
                if not visited[adjcent]:
                    visited[adjcent] = True
                    print(adjcent)
                    que.appendleft(adjcent)


obj = A_DfsBfsTravers()
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
# obj.dfs(edges)
obj.bfs(edges)
