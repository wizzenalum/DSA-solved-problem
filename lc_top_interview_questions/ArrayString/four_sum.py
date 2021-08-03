"""
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

    0 <= i, j, k, l < n
    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0



Example 1:

    Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    Output: 2
    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

Example 2:

    Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    Output: 1

"""
from typing import List



class Solution:
    def fourSumCount(self,nums1:List[int], nums2:List[int], 
                nums3:List[int], nums4:List[int])->int:
        '''bruitforce method time O(n^4)  space O(1)'''
        count = 0
        for eleNum1 in nums1:
            for eleNum2 in nums2:
                for eleNum3 in nums3:
                    for eleNum4 in nums4:
                        if(eleNum1+eleNum2+eleNum3+eleNum4 == 0):
                            count +=1
        print(count)
        return count
    def merge(self,arr:List[int],start,mid,end):
       #print("merge",start,mid,end,arr)
        i,j,k = 0,mid-start,start
        end = end+1
        arr1 = [arr[i+start] for i in range(end-start)]
       #print(arr1,i,j,k,start,mid,end)
        while i<mid-start and j<end-start:
           #print(i,j,arr1[i],arr1[j],arr)
            if(arr1[i]<=arr1[j]):
                arr[k] = arr1[i]
                i,k = i+1,k+1
            if(arr1[i]>=arr1[j]):
                arr[k] = arr1[j]
                j,k = j+1,k+1
        while i<mid-start:
           #print(i,j,arr1[i],arr)
            arr[k] = arr1[i]
            i,k = i+1,k+1
        while j<end-start:


            arr[k] = arr1[j]
            j,k = j+1,k+1
      # print(arr)
    def sort(self, arr:List[int],start:int,end:int):
       # print("sort call", arr, start,end)
        if(end<=start): return
        mid = (end+start)//2
        self.sort(arr,start,mid)
        self.sort(arr,mid+1,end)
        self.merge(arr,start,mid+1,end)
        
    def fourSumCount2(self,nums1:List[int], nums2:List[int], 
                nums3:List[int], nums4:List[int])->int:
        '''optimising this bruitforce method '''
        n = len(nums1)-1  
       # lets sort them first then do the operation
        self.sort(nums1,0,n)
        self.sort(nums2,0,n)
        self.sort(nums3,0,n)
        self.sort(nums4,0,n)
        # print(nums1,nums2,nums3,nums4)
        count = 0
      
        for eleNum1 in nums1:
            # print("first",eleNum1)
            if(eleNum1+nums2[0]+nums3[0]+nums4[0]>0):break
            elif(eleNum1+nums2[0]+nums3[0]+nums4[0]<=0<=eleNum1+nums2[n]+nums3[n]+nums4[n]):
                for eleNum2 in nums2:
                    # print("second",eleNum1,eleNum2)
                    if(eleNum1+eleNum2+nums3[0]+nums4[0]>0):break
                    elif(nums3[0]+nums4[0]+eleNum1+eleNum2<=0<=nums3[n]+nums4[n]+eleNum1+eleNum2):
                        for eleNum3 in nums3:
                            # print("third",eleNum1,eleNum2,eleNum3)
                            if(eleNum1+eleNum2+eleNum3+nums4[0]>0):break
                            elif(nums4[0]+eleNum1+eleNum2+eleNum3<=0<=nums4[n]+eleNum1+eleNum2+eleNum3):
                                for eleNum4 in nums4:
                                    # print("forth",eleNum4,end=" ")
                                    if(eleNum1+eleNum2+eleNum3+eleNum4 == 0):
                                        count +=1
        # print(count)
        return count
    def fourSumCount3(self,nums1:List[int], nums2:List[int], 
                nums3:List[int], nums4:List[int])->int:
        n = len(nums1)
        arr = [[0,0] for i in range(4*n)] 
        for i in range(4*n):
            print(i)
            if i<n:
                print("Int")
                arr[i][0] = nums1[i]
                arr[i][1] = 2
            elif n<=i<2*n:
                arr[i][0] = nums2[i-n]
                arr[i][1] = 3
            elif 2*n<=i<3*n:
                arr[i][0] = nums3[i-2*n]
                arr[i][1] = 5
            elif 3*n<=i<4*n:
                arr[i][0] = nums4[i-3*n]
                arr[i][1] = 7
        arr.sort(key = lambda ele:ele[0])
        print(arr)
        count = 0
        for i in range(4*n-3):
            for j in range(4*n-1,i+2,-1):
                k,l = i+1, j-1
                while k<l:
                    check = arr[i][1]*arr[j][1]*arr[k][1]*arr[l][1]
                    print(i,k,l,j,check)
                    if arr[i][1]*arr[j][1]*arr[k][1]*arr[l][1]==210:
                        sum = arr[i][0]+arr[j][0]+arr[k][0]+arr[l][0]
                        print("in if condition",sum)
                        if(sum==0):
                            k,count = k+1,count+1
                        elif(sum<0):
                            k = k+1
                        elif(sum>0):
                            j = j-1
                    else:k = k+1
        print(count)
    def fourSumCount4(self,nums1:List[int], nums2:List[int], 
                nums3:List[int], nums4:List[int])->int:
        map = {}
        n = len(nums1)
        for i in range(n):
            for j in range(n):
                if nums1[i]+nums2[j] in map:
                    map[nums1[i]+nums2[j]] = map[nums1[i]+nums2[j]]+1
                else: map[nums1[i]+nums2[j]] = 1
        auxArr = []
        for i in range(n):
            for j in range(n):
                auxArr.append(nums3[i]+nums4[j])
        count = 0
        auxArr.sort()
        #print(map,auxArr)
        i = 0
        while(i<n*n):
            #print(i, " start  ")
            freq = 1
            while(i+1<n*n and auxArr[i]==auxArr[i+1]):
                i,freq = i+1,freq+1
                #print(i,freq,end="  ")
            if(-1*auxArr[i] in map):
                #print("count add",freq*map[-1*auxArr[i]])
                count+= freq*map[-1*auxArr[i]]
            i = i+1
        #print(count)
        return count
                

        




s= Solution()
# nums1,nums2,nums3,nums4 = [1,2],[-2,-1],[-1,2],[0,2]
nums1,nums2,nums3,nums4 = [0,1,-1], [-1,1,0], [0,0,1], [-1,1,1]
# l = s.fourSumCount3(nums1,nums2,nums3,nums4) 
l = s.fourSumCount4(nums1,nums2,nums3,nums4) 
print(l)
arr = [2,9,3,5,7,9,1,2,8,9,4,5]
#s.merge(arr,2,6,9)
# s.sort(arr,0,len(arr)-1)
#print(arr)
