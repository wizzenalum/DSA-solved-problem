class p:
    def pls3_helper(self,li:list,i:int,j:int,map:dict)->int:
        '''' 1. here i used dp to track already visited indeces.
             2. time Complexity O(3^n) space complexity O(n^2)  '''
        if(j<i): return 0
        if(str(i)+str(j) in map):
            return map[str(i)+str(j)]
        # print(i,j)
        if i==j: 
            return 1
        elif li[i]==li[j]:
            result =  1 + self.pls3_helper(li,i+1,j,map)+self.pls3_helper(li,i,j-1,map)
        else: 
            result =  self.pls3_helper(li,i+1,j,map)+self.pls3_helper(li,i,j-1,map)-self.pls3_helper(li,i+1,j-1,map)
        map[str(i)+str(j)] = result
        return result

    def pls3(self,string:str)->int:
        li = list(string)
        return self.pls3_helper(li,0,len(li)-1,{})
    def countPs(self,string):
        # Code here
        return self.pls3(string)
o  = p()
print(o.pls3("absdfgfbaaaaaaaaacd"))