from typing import List
class Solution:
    def findProduct(self,nums:List[int],result:List[int],index:int,multiplier:int)-> int:
        if index == len(nums)-1:
            result[index] = multiplier
            return nums[index]
        result[index] = multiplier
        reValue = self.findProduct(nums,result,index+1,multiplier*nums[index])
        result[index] *= reValue
        return reValue*nums[index]

    def productExceptSelf(self, nums: List[int]) -> List[int]:
       result = [0]*len(nums)
       self.findProduct(nums,result,0,1)
       print(result)
       return result
    def productExceptSelf1(self,nums:List[int]) -> List[int]:
        result = [1]*len(nums)
        forward = 1
        for i in range(len(nums)):
            result[i] = forward
            forward *= nums[i]
        backward = 1
        for i in range(len(nums)-1,-1,-1):
            result[i]  *= backward
            backward *= nums[i]
        print(result)
        return result

s = Solution();
nums = [1,2,3,4]
s.productExceptSelf(nums)

s.productExceptSelf1(nums)

