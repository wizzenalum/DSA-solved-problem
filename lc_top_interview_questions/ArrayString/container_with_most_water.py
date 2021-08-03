from typing import List


class Solution:
    def mostWater(self,water:List[int])->int:
        vol,maxVol = 0,0
        i,j = 0,len(water)-1
        while(j>i):
            print(i,j,end=" ")
            if(water[i]<water[j]):
                vol = water[i]*(j-i)
                i=i+1
                print(vol,end=" ")
            else:
                vol = water[j]*(j-i)
                j = j-1
                print(vol,end=" ")
            if(vol>maxVol): 
                maxVol = vol
                print("updated",end=" ")
            print("end")
        print(maxVol)
        return maxVol

s = Solution()
water = [4,3,2,1,4]
res = s.mostWater(water)
print(res)
