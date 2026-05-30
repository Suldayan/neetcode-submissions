class Solution {
    private int prefix(int maxSize, int[] nums) {
        int product = 1;
        for (int i = 0; i < maxSize; i++) {
            product *= nums[i];
        }

        return product;
    }

    private int suffix(int currIndex, int size, int[] nums) {
        int product = 1;
        for (int i = size; i > currIndex; i--) {
            product *= nums[i];
        }

        return product;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix(i, nums) * suffix(i, nums.length - 1, nums);
        }

        return output;
    }
}  
