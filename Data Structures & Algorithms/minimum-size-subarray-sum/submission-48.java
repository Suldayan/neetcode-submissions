class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = nums.length;
        boolean isValid = false;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target && j < nums.length) {
                min = Math.min(min, Math.abs(i - j + 1));
                isValid = true;

                sum -= nums[j];
                j++;                
            }
        }

        if (isValid) {
            return min;
        }

        return 0;
    }
}