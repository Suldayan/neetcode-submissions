class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:        
        if 0 <= len(nums) <= 1:
            return []

        seen = {}
        
        for i, num in enumerate(nums):
            complement = target - nums[i]
            if complement in seen:
                return [seen[complement], i]
            seen[num] = i