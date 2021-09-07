class CodingNinjas:
    # def create_graph(self,mat):
    #     graph = {}
    #     direction = [[1,1],[-1,-1],[-1,1],[1,-1],[0,1],[1,0],[0,-1],[-1,0]]
    #     key = ""
    #     for i in range(len(mat)):
    #         for j in range(len(mat[0])):
    #             key = str(i)+str(j)
    #             graph[key] = [mat[i][j]]
    #             for dirs in direction:
    #                 r = i+dirs[0]
    #                 c = j+dirs[1]
    #                 if r>=0 and c>=0 and r<len(mat) and c<len(mat[0]):
    #                     graph[key].append(str(r)+str(c))
    #     return graph
    # def is_possible(self,graph,key,string,index,visited):
    #     if(index>=len(string)): return True
    #     if(graph[key][0]!=string[index]): return False
    #     adjacents = graph[key]
    #     for i in range(1,len(adjacents)):
    #         if(key in visited):

        
    # def can_create(self,mat,string):
    #     graph = self.create_graph(mat)
    #     for key in graph:
    #         if(self.is_possible(graph,key,string,0,{})): return True
    #     return False

    # back tracking into this problem
    def check_path(self,mat,row,col,string,map, index):
        # print(row,col,index)
        if(index>=len(string)):return 1
        if(row>=len(mat) or col >= len(mat[0]) or row<0 or col<0 or index<0): return 0
        if(map[row][col]): return 0
        map[row][col] = True
        # print('reach calls')
        if(string[index]==mat[row][col]):
            if  self.check_path(mat,row+1,col,string,map, index+1) or\
                self.check_path(mat,row+1,col+1,string,map, index+1) or\
                self.check_path(mat,row,col+1,string,map, index+1) or\
                self.check_path(mat,row-1,col+1,string,map, index+1) or\
                self.check_path(mat,row-1,col,string,map, index+1) or\
                self.check_path(mat,row-1,col-1,string,map, index+1) or\
                self.check_path(mat,row,col-1,string,map, index+1) or\
                self.check_path(mat,row+1,col-1,string,map, index+1)\
                    : return 1
        else:
            if  self.check_path(mat,row+1,col,string,map, 0) or\
                self.check_path(mat,row+1,col+1,string,map, 0) or\
                self.check_path(mat,row,col+1,string,map, 0) or\
                self.check_path(mat,row-1,col+1,string,map, 0) or\
                self.check_path(mat,row-1,col,string,map, 0) or\
                self.check_path(mat,row-1,col-1,string,map, 0) or\
                self.check_path(mat,row,col-1,string,map, 0) or\
                self.check_path(mat,row+1,col-1,string,map, 0)\
                    : return 1
        map[row][col] = False
        return 0


    def check_path_help(self,mat,row,col,string,map, index):
        print(row,col,index)
        if(index>=len(string)):return 1
        if(row>=len(mat) or col >= len(mat[0]) or row<0 or col<0 or index<0): return 0
        if(map[row][col]): return 0
        map[row][col] = True
        print('reach calls')
        if(string[index]==mat[row][col]):
            if  self.check_path_help(mat,row+1,col,string,map, index+1) or\
                self.check_path_help(mat,row+1,col+1,string,map, index+1) or\
                self.check_path_help(mat,row,col+1,string,map, index+1) or\
                self.check_path_help(mat,row-1,col+1,string,map, index+1) or\
                self.check_path_help(mat,row-1,col,string,map, index+1) or\
                self.check_path_help(mat,row-1,col-1,string,map, index+1) or\
                self.check_path_help(mat,row,col-1,string,map, index+1) or\
                self.check_path_help(mat,row+1,col-1,string,map, index+1)\
                    : return 1
        map[row][col] = False
        return 0
    def check_path1(self,mat,string):
        map = [[False]*(len(mat[0])) for i in range(len(mat))]
        for row in range(len(mat)):
            for col in range(len(mat[0])):
                if(mat[row][col] == string[0]):
                    print(row,col)
                    if(self.check_path_help(mat,row,col,string,map,0)): return 1

        return 0



obj = CodingNinjas()
# mat = [ "CANAA", "IOAII", "DDIND", "AJINS", "XINNG" ]
mat = ["CXDXNXNXNXA", "XOXIXGXIXJX"]
string = "CODINGNINJA"
map = [[False]*(len(mat[0])) for i in range(len(mat))]
# print(map)
# res = obj.check_path(mat,0,0,string,map,0)
res = obj.check_path1(mat,string)
print(res)
# obj.can_create(mat,string)

