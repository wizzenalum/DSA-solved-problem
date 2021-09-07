from typing import List


class palindrome:

# QUESTION 1: check string is palindromic or not 
    # method 1   
    def p1(self,string:str)->bool:
        """step 1 reverse the string if reversed string and original strings are same then it is palindrome. 
        time complexity O(n) space complexity O(n) where n is total letters"""
        i,j = 0,len(string)-1
        reversed_string = ""
        for leter in string:
            reversed_string = leter+reversed_string
        if(reversed_string == string):
            return True
        return False
    # method 2   
    def p2(self,string:str)->bool:
        """traverse from start and check it is similar to the traverese from the end or not.
        time complexity O(n) space complexity O(1) where n is total letters"""
        i,j = 0,len(string)-1
        # print(string)
        while i<j:
            if string[i]!=string[j]: return False
            i+=1; j-=1
        return True

# QUESTION 2:check number is palindromic or not
    # method 1 
    def pn1(self,num:int)->bool:
        ''' convert number into string and check for the palindrom
        time complexity O(n) space complexity O(n) where n is total letters'''
        string = str(num)
        return self.p1(string)
    # method 2
    def pn2(self,num:int)->bool:
        '''create a arr of each digit then traverse from end and start to check
        time complexity O(n) space complexity O(n) where n is total letters'''
        arr = []
        while num>0:
            arr.append(num%10)
            num//=10
        i,j = 0,len(arr)-1
        while i<j:
            if arr[i]!=arr[j]: return False
            i+=1; j-=1
        return True
    # method 3 check a number is palindrom or not without using extra space
    def pn3(self,num:int)->bool:
        ''' compare  front and back of the digits by finding them by little math calculations 
        time complexity O(n) space complexity O(1) where n is total letters'''
        n,m = 1,10
        count = 1
        while num//n>10:
            n *=10
            count+=1
        
        while(n>=m):
            if(num!=0 and num//n!=num%m): return False
            n = n/10
            m = n*10
        return True

# QUESTION 3:find longest palindrom substring of the string
    # method 1 bruitforce
    def pl1(self,string:str)->str:
        '''first two loops will find all the substring possible and then last loop will check for palindrome
        time complexity O(n^3) space complexity O(1) where n is total letters '''
        start, end = 0,0
        n = len(string)
        for i in range(n):
            for j in range(i,n):
                # print(i,j, start,end," next",end=" ")
                if(j-i>end-start and self.p1(string[i:j+1])): start,end = i , j
        return string[start:end+1]
    # method 2 dynamic programing
    def pl2(self,string:str)->str:
        ''' for each substring store value of palindrome in a matrix of n*n whre n is len(string)
            1. value of mat[i][j] is true if mat[i+1][j-1] and char at i and j are same then true, else false.
            2. initiate matrix for length 1 and length 2 sub string then loop it to find matrix values
            time complexity O(n^2) space complexity O(n^2) where n is total letters'''
        n = len(string)
        start,end = 0,0
        mat = [[False for i in range(n)] for i in range(n)]
        # setting value for length 1 substrings
        for i in range(n):
            mat[i][i] = True
        # setting value for length 2 substrigs
        for i in range(n-1):
            if string[i]==string[i+1]:
                mat[i][i+1] = True

        # print(mat, start ,end)
        # setting all other values`
        for i in range(n-3,-1,-1):
            for j in range(i,n):
                # print(i,j)
                if string[i]==string[j] and mat[i+1][j-1]:
                    mat[i][j] = True
        for i in range(0,n):
            for j in range(i,n):
                if(mat[i][j] and j-i>end-start): start,end = i,j  
        return string[start:end+1]
    # method 3 tracking all even oddd length palndroms
    def pl3(self,string:str)->str:
        ''' 1. for odd length palindrome track i1=i+1 and i2=i-1 around each i if i1 == i2 then increase i1 and decreasei2.
            2. for even length palindrome track i1 = i and i2 = i+1 and increase i2 and decrese i1.
            time complexity is O(n^2) and space complexity is O(1)  '''
        n = len(string)
        start, end = 0,0
        for i in range(1,n-1):
            i1, i2  = i-1, i+1
            while i1>=0 and i2<n and string[i1]==string[i2] :
                if(i2-i1>end-start):start,end = i1,i2
                i1, i2 = i1-1, i2+1
        for i in range(0,n-1):
            i1, i2  = i, i+1
            while i1>=0 and i2<n and string[i1]==string[i2] :
                if(i2-i1>end-start):start,end = i1,i2
                i1, i2 = i1-1, i2+1
        return string[start:end+1]
     # method 4 manacher's algorithm preaty great and beutiful.
    def pl4(self,string:str)->str:
        ''' 1. create a length of palidromic string array  and not counting fot those which aare alredy counted.
            time complexity is O(n) and space complexity is O(n)  '''
        n = len(string)*2+1
        L = [0]*n
        L[0],L[1] = 0,1
        C,R,li,diff = 1,2,0,0
        result_center, result_length = 1,1
        for i in range(2,n):
            li, diff = 2*C-i, R-i
            if diff>0:
                L[i] = min(L[li],diff)
            # print(li,diff,L[i],C,R,i,L, result_center, result_length)
            try:
                while(  i+L[i]+1 < n and
                        i-L[i]-1 > 0 and
                        ((i+L[i])%2==1 or string[(i+L[i]+1)//2]== string[(i-L[i]-1)//2])):
                    L[i] +=1
            except Exception as error:
                pass
            if L[i] > result_length:
                result_length = L[i]
                result_center = i
            if R < i+L[i]:
                C,R = i, i+L[i]
        start = (result_center-result_length)//2
        end = start+result_length-1
        return string[int(start):int(end)+1]

# QUESTION 4: count all posible substring palindromes
    # in previoius question put a counter wherever the palindrome is posible.
# QUESTION 5: count all unique substring palindromes
    # method 1 
    def psu1(self,string:str)->int:
        '''' 1. use above method and add all strings in map and lenth of that dictionary will be the count of unique palindrome
             2. time Complexity O(n^2) space complexity O(n^2)  '''
        map = {}
        n = len(string)
        for i in string:
            map[i] = True
        # odd palindrom counted
        for i in range(1,n):
            i1,i2 = i-1, i+1
            while(i1>=0 and i2<n and string[i1]==string[i2]):
                map[string[i1:i2+1]] = True
                i1,i2 = i1-1,i2+1
        # even palndrome counting
        for i in range(0,n-1):
            i1,i2 = i, i+1
            while(i1>=0 and i2<n and string[i1]==string[i2]):
                map[string[i1:i2+1]] = True
                i1,i2 = i1-1,i2+1
        # print(type(map),map)
        return len(map)
   
            

# QUESTION 6: count all palindromic subsequence
    # method 1 bruit force method 
    def pls1(self,string:str,index:int = 0,count:int = 0)->int:
        '''' 1. here i am crating all posible strings and then checking is it palindrome or not.
             2. time Complexity O(2^n*n) space complexity O(n^2)  '''
        # print(string,index,count)
        if(index>= len(string)):
            if len(string)!=0 and self.p1(string):
                # print(string,"R-1")
                return count+1
            # print(count,"R-2")
            return count
        first = self.pls1(string,index+1,count)
        # print(first,"R-3")
        second = self.pls1((string[0:index]+string[index+1:len(string)]),index,first)
        # print(second,"R-4")
        return second
    # method 2 traversing from both ends
    def pls2_helper(self,li:list,i:int,j:int)->int:
        '''' 1. here i am traversing from both end and check simultaneously.
             2. time Complexity O(3^n) space complexity O(n)  '''
        # print(i,j)
        if(j<i):return 0
        if i==j: 
            return 1
        elif li[i]==li[j]:
            return 1 + self.pls2_helper(li,i+1,j)+self.pls2_helper(li,i,j-1)
        else: 
            return self.pls2_helper(li,i+1,j)+self.pls2_helper(li,i,j-1)-self.pls2_helper(li,i+1,j-1)
    def pls2(self,string:str)->int:
        li = list(string)
        return self.pls2_helper(li,0,len(li)-1)

    # method 3 using dp recursivly
    def pls3_helper(self,li:list,i:int,j:int,map:dict)->int:
        '''' 1. here i used dp to track already visited indeces.
             2. time Complexity O(3^n) space complexity O(n^2)  '''
        if(j<i):return 0
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

    # method 4 itterative dp.
    def pls4(self,string:str)->int:
        '''' 1. if len1 is number of all pair in forrward with same digit
            2. then total sub sequences are len1+len(string) 
             2. time Complexity O(2^n) space complexity O(n^2)  '''
        # created ta 2d array
        store = [[0 for i in range(len(string))] for j in range(len(string))]
        for i in range(len(string)):
            store[i][i] = 1
        for k in range(1,len(string)):
            i,j = 0,k
            while i < len(string) and j < len(string):
                if string[i]==string[j]:
                    store[i][j] = store[i][j-1]+store[i+1][j]+1
                else:
                    store[i][j] = store[i][j-1]+store[i+1][j]-store[i+1][j-1]
                i,j = i+1,j+1
        # print(store)
        return store[0][len(string)-1]
# QUESTION 7: count all unique palindromic subsequences 
    # method 1 bruit force method
    def plsu1(self,string:str, i =  0, map = {})->int:
        if(i==len(string)):
            if(string not in map and self.p2(string)):
                # print("count 1 dear")
                map[string] = True
                print(string)
               # print(map)
                return 1
            else: return 0
        return self.plsu1(string,i+1,map)+self.plsu1(string[0:i]+string[i+1:len(string)],i,map)
        """ """
    # method 2 appliying uniqueness check on question6 method4
    def plsu2(self,string:str)->int:
        n = len(string)
        store = [[0 for i in range(n)] for j in range(n)]
        unique = {}
        # print(string)
        for i in range(n):
            for j in range(0,i+1):
                store[i][j] = True
            unique[string[i]] = True
        # print(store,unique)
        for k in range(1,n):
            i = 0
            for j in range(k,n):
                # print(i,j,store,unique)
                if string[i]==string[j] and store[i+1][j-1]:
                    store[i][j] = True
                    unique[string[i:j+1]] = True
                    unique[string[i]+string[j]] = True
                i +=1
        print(unique,store)
        return len(unique)

    
p= palindrome()
# QUESTION 1
# print(p.p1("aba"))
# print(p.p2("aba"))

# QUESTION 2
# print(p.pn1(1001))
# print(p.pn2(150051))
# print(p.pn3(150051))

# QUESTION 3
# print(p.pl1("aagshbaabjc"))
# print(p.pl2("bdddddabfbadddddd"))
# print(p.pl3("aabbba"))
# print(p.pl4("aabbba"))

# QUESTION 5
# print(p.psu1("add"))

# QUESTION 6
# string = "aaa"
# print(p.pls1(string))
# print(p.pls2(string))
# print(p.pls3(string1))
# print(p.pls4("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))

# question 7
string ="bccb"
print(p.plsu1(string)-1)
print(p.plsu2(string))



