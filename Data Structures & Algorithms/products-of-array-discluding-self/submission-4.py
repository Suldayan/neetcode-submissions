class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        if 0 <= len(nums) <= 1:
            return []

        i = 0
        products = []
        while i < len(nums):
            product = 1
            for j in range(len(nums)):
                if j != i:
                    product *= nums[j]

            products.append(product)
            i += 1

        return products

        