class p:
    def manacher(self,string:str)->str:
        if(len(string)==0):return
        LPS = [0]*(2*len(string)+1)
        LPS[1] =1
        c, cr = 1,2
        maxPalindromeIndex = 0
        # print(f"string is ${string} and Longest palendromic string is ${LPS} ")
        for index in range(2,len(LPS)):
            indexMirror = 2*c-index
            diff = cr-index
            if(diff>0): # it means index position is contain by center palendromic string
                LPS[index] = min(LPS[indexMirror],diff)
                # if string contained id smaller or diff is smaller we chose that.

            try:
                while(index-LPS[index]>0 and index+LPS[index]<len(LPS)) and \
                    ((index+LPS[index]+1)%2==0 or\
                        (string[(index+LPS[index]+1)//2]==string[(index-LPS[index]-1)//2])):
                        LPS[index]+=1
            except Exception as e:
                pass
            if(index+LPS[index]>cr):
                    c,cr = index,index+LPS[index]
            if(LPS[maxPalindromeIndex]<LPS[index]): maxPalindromeIndex = index
        start = (maxPalindromeIndex-LPS[maxPalindromeIndex])//2
        end = (maxPalindromeIndex+LPS[maxPalindromeIndex]-1)//2
        # print(LPS,maxPalindromeIndex)
        return string[start:end+1]
obj = p()
print(obj.manacher("babcbabcbaccba"))
print(obj.manacher("abcbabcbabcba"))
print(obj.manacher("abacdfgdcabba"))
        
        
            


    